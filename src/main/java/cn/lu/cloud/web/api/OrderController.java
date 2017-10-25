package cn.lu.cloud.web.api;

import cn.lu.cloud.client.AccountClient;
import cn.lu.cloud.client.ProductClient;
import cn.lu.cloud.client.UserClient;
import cn.lu.cloud.common.ResponseResult;
import cn.lu.cloud.data.OrderData;
import cn.lu.cloud.dto.CreateOrderDTO;
import cn.lu.cloud.dto.ProductDTO;
import cn.lu.cloud.dto.UpdateAccountDTO;
import cn.lu.cloud.dto.UserLoginDTO;
import cn.lu.cloud.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by lutiehua on 2017/10/10.
 */
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private ProductClient productClient;

    @Autowired
    private UserClient userClient;

    @Autowired
    private AccountClient accountClient;

    @PostMapping("/")
    public ResponseResult createOrder(@RequestBody CreateOrderDTO createOrderDTO) {

        logger.info("user {} order product {} by {}",
                createOrderDTO.getUsername(), createOrderDTO.getProductUuid(), createOrderDTO.getAmount());

        int errorCode = 1001;
        String errorMessage = "生成订单失败";

        ResponseResult responseResult = new ResponseResult();

        UserLoginDTO userLoginDTO = new UserLoginDTO();
        userLoginDTO.setUsername(createOrderDTO.getUsername());
        userLoginDTO.setPassword(createOrderDTO.getPassword());
        ResponseResult clientResponse = userClient.login(userLoginDTO);
        if (!clientResponse.isSuccessful()) {
            responseResult.setCode(clientResponse.getCode());
            responseResult.setMsg(clientResponse.getMsg());
            return responseResult;
        }

        Map<String, String> data = (Map<String, String>)clientResponse.getData();
        createOrderDTO.setUserUuid(data.get("userUuid"));
        createOrderDTO.setAccountUuid(data.get("accountUuid"));

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

        UpdateAccountDTO updateAccountDTO = new UpdateAccountDTO();
        updateAccountDTO.setAccountUuid(createOrderDTO.getAccountUuid());
        BigDecimal decimal = createOrderDTO.getAmount().multiply(new BigDecimal(-1));
        updateAccountDTO.setBalanceChanged(decimal);
        ResponseResult accountResponse = accountClient.updateBalance(updateAccountDTO);
        if (!accountResponse.isSuccessful()) {
            responseResult.setCode(accountResponse.getCode());
            responseResult.setMsg(accountResponse.getMsg());
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
