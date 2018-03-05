package com.thingcom.demo.constant;

public class Const {

    public static final String CURRENT_USER = "currentuser";

    public static final String USERNAME = "username";

    public static final String EMAIL = "email";

    public static final String PHONE = "phone";

    public enum Role{
        ROLE_ORDIN(1,"普通用户"),
        ROLE_ADMIN(0,"管理员");

        private int code;
        private String value;

        Role(int code,String value){
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }



}
