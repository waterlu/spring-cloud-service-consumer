package cn.lu.cloud.client;

import cn.lu.cloud.common.ResponseResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by lutiehua on 2017/9/30.
 */
@FeignClient(value = "service-provider", fallback = ProductFallback.class)
public interface ProductClient {

    @GetMapping("/api/products/")
    ResponseResult getProductList();

    @GetMapping("/api/products/{productUUid}")
    ResponseResult getProduct(@PathVariable("productUUid") String productUUid);

}
