package com.thingcom.demo.exception;

import com.thingcom.demo.common.ResponseCode;

public class MyException extends RuntimeException{

    private Integer code;

    public MyException(Integer code,String msg){
        super(msg);
        this.code = code;
    }

    public MyException(ResponseCode responseCode){
        super(responseCode.getMsg());
        this.code = responseCode.getCode();
    }
}
