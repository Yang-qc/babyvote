package com.babyvote.common.exception;


import com.babyvote.common.model.response.ResultCode;

public class ExceptionThrowOut {

    public static void cast(ResultCode resultCode){
        throw new KetaiException(resultCode);
    }
}
