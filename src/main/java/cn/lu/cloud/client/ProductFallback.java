package cn.lu.cloud.client;

import cn.lu.cloud.common.ResponseResult;
import org.springframework.stereotype.Component;

/**
 * Created by lutiehua on 2017/10/10.
 */
@Component
public class ProductFallback implements ProductClient {

    @Override
    public ResponseResult getProductList() {
        ResponseResult responseResult = new ResponseResult(ResponseResult.TIMEOUT, ResponseResult.TIMEOUT_TXT);
        return responseResult;
    }

    @Override
    public ResponseResult getProduct(String productUUid) {
        ResponseResult responseResult = new ResponseResult(ResponseResult.TIMEOUT, ResponseResult.TIMEOUT_TXT);
        return responseResult;
    }
}
