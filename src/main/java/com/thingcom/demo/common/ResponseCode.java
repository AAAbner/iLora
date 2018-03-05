package com.thingcom.demo.common;

import lombok.Getter;

@Getter
public enum ResponseCode {

    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    ILLEGAL_PARAM(2,"参数不合法"),
    USEREXIT(3,"用户已存在"),
    PHONEEXIT(4,"电话已存在"),
    EMAILEXIT(5,"邮箱已存在");

    private final int code;
    private final String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
