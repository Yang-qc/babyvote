package com.babyvote.common.response;

import com.ketai.common.constants.ResultCodeEnum;
import com.ketai.common.model.response.ResponseResult;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ResultMap extends ResponseResult {

    @ApiModelProperty(value = "返回数据")
    public Map<String, Object> data = new HashMap<String, Object>();

    public ResultMap() {
    }

    public static ResultMap ok() {
        ResultMap r = new ResultMap();
        r.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        r.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return r;
    }

    public static ResultMap error() {
        ResultMap r = new ResultMap();
        r.setSuccess(ResultCodeEnum.UNKNOWN_REASON.getSuccess());
        r.setCode(ResultCodeEnum.UNKNOWN_REASON.getCode());
        r.setMessage(ResultCodeEnum.UNKNOWN_REASON.getMessage());
        return r;
    }

    public static ResultMap setResult(ResultCodeEnum resultCodeEnum) {
        ResultMap r = new ResultMap();
        r.setSuccess(resultCodeEnum.getSuccess());
        r.setCode(resultCodeEnum.getCode());
        r.setMessage(resultCodeEnum.getMessage());
        return r;
    }

    public ResultMap success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    public ResultMap message(String message) {
        this.setMessage(message);
        return this;
    }

    public ResultMap code(Integer code) {
        this.setCode(code);
        return this;
    }

    public ResultMap data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public ResultMap data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }
}