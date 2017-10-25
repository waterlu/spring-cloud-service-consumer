package cn.lu.cloud.client;

import cn.lu.cloud.common.ResponseResult;
import cn.lu.cloud.dto.UpdateAccountDTO;
import org.springframework.stereotype.Component;

/**
 * Created by lutiehua on 2017/10/25.
 */
@Component
public class AccountClientFallback implements AccountClient {

    @Override
    public ResponseResult updateBalance(UpdateAccountDTO updateAccountDTO) {
        ResponseResult responseResult = new ResponseResult(ResponseResult.TIMEOUT, ResponseResult.TIMEOUT_TXT);
        return responseResult;
    }
}