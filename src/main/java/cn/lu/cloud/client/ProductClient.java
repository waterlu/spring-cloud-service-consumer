package cn.lu.cloud.client;

import cn.lu.cloud.api.ProductAPI;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by lutiehua on 2017/9/30.
 */
@FeignClient(value = "service-provider", fallback = ProductFallback.class)
public interface ProductClient extends ProductAPI {

}
