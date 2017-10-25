package cn.lu.cloud.client;

import cn.lu.cloud.common.ResponseResult;
import cn.lu.cloud.dto.UpdateAccountDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lutiehua on 2017/10/25.
 */
@FeignClient(value = "service-provider", fallback = AccountClientFallback.class)
@RequestMapping({"/api/accounts"})
public interface AccountClient {

    @PutMapping({"/balance"})
    ResponseResult updateBalance(@RequestBody UpdateAccountDTO updateAccountDTO);

}