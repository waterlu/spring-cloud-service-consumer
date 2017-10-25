package cn.lu.cloud.client;

import cn.lu.cloud.common.ResponseResult;
import cn.lu.cloud.dto.UserLoginDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lutiehua on 2017/10/25.
 */
@FeignClient(value = "service-provider", fallback = UserClientFallback.class)
@RequestMapping({"/api/users"})
public interface UserClient {

    @PostMapping({"/login"})
    ResponseResult login(@RequestBody UserLoginDTO userLoginDTO);

}
