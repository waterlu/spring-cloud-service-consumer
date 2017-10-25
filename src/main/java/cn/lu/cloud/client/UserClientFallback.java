package cn.lu.cloud.client;

import cn.lu.cloud.common.ResponseResult;
import cn.lu.cloud.dto.UserLoginDTO;
import org.springframework.stereotype.Component;

/**
 * Created by lutiehua on 2017/10/25.
 */
@Component
public class UserClientFallback implements UserClient {

    @Override
    public ResponseResult login(UserLoginDTO userLoginDTO) {
        ResponseResult responseResult = new ResponseResult(ResponseResult.TIMEOUT, ResponseResult.TIMEOUT_TXT);
        return responseResult;
    }
}