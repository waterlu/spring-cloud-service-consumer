package cn.lu.cloud.web.api;

import cn.lu.cloud.client.ProductClient;
import cn.lu.cloud.common.ResponseResult;
import cn.lu.cloud.data.OrderData;
import cn.lu.cloud.dto.CreateOrderDTO;
import cn.lu.cloud.dto.ProductDTO;
import cn.lu.cloud.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * Created by lutiehua on 2017/10/10.
 */
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private ProductClient productClient;

    @PostMapping("/")
    public ResponseResult createOrder(@RequestBody CreateOrderDTO createOrderDTO) {
        int errorCode = 1001;
        String errorMessage = "生成订单失败";

        ResponseResult responseResult = new ResponseResult();
        ResponseResult productResponse = productClient.getProduct(createOrderDTO.getProductUuid());
        if (!productResponse.isSuccessful()) {
            responseResult.setCode(productResponse.getCode());
            responseResult.setMsg(productResponse.getMsg());
            return responseResult;
        }

        ProductDTO product = productResponse.getData(ProductDTO.class);

        if (null == product) {
            responseResult.setCode(errorCode);
            responseResult.setMsg(errorMessage);
            return responseResult;
        }

        if (createOrderDTO.getAmount().compareTo(product.getProductMinInvestment()) < 0) {
            responseResult.setCode(errorCode);
            responseResult.setMsg(errorMessage);
            return responseResult;
        }

        if (createOrderDTO.getAmount().compareTo(product.getProductMaxInvestment()) > 0) {
            responseResult.setCode(errorCode);
            responseResult.setMsg(errorMessage);
            return responseResult;
        }

        BigDecimal remaining = product.getProductScale().subtract(product.getProductAccumulation());
        if (createOrderDTO.getAmount().compareTo(remaining) > 0) {
            responseResult.setCode(errorCode);
            responseResult.setMsg(errorMessage);
            return responseResult;
        }

        Order order = new Order();
        order.setUserUuid(createOrderDTO.getUserUuid());
        order.setProductUuid(createOrderDTO.getProductUuid());
        order.setAccountUuid(createOrderDTO.getAccountUuid());
        order.setAmount(createOrderDTO.getAmount());
        order = OrderData.add(order);
        responseResult.setData(order);

        return responseResult;
    }

    @GetMapping("/")
    public ResponseResult getOrderList() {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setData(OrderData.getAll());
        return responseResult;
    }

}
