package cn.lu.cloud.common;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Created by lutiehua on 2017/10/9.
 */
public class ResponseResult {

    public static int OK = 200;

    public static int TIMEOUT = 408;

    public static String OK_TXT = "";

    public static String TIMEOUT_TXT = "timeout";

    private int code;

    private String msg;

    private Object data;

    public ResponseResult() {
        this.code = OK;
        this.msg = OK_TXT;
        this.data = null;
    }

    public ResponseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public boolean isSuccessful() {
        return this.code == OK;
    }

    public <T> T getData(Class<T> clazz) {
        String jsonString = JSONObject.toJSONString(getData());
        return JSONObject.parseObject(jsonString, clazz);
    }

    public <T> List<T> getDataArray(Class<T> clazz) {
        String jsonString = JSONObject.toJSONString(getData());
        return JSONObject.parseArray(jsonString, clazz);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
