package cn.lu.cloud.client;

import cn.lu.cloud.common.ResponseResult;

/**
 * Created by lutiehua on 2017/10/10.
 */
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
