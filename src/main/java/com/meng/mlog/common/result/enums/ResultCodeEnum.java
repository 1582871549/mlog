package com.meng.mlog.common.result.enums;

public enum ResultCodeEnum {

    SUCCESS("0000", "成功"),
    FAILED("0001", "失败"),

    REGISTER_ERROR("A0100", "用户注册错误"),
    LOGIN_FAILED("A0101", "登陆失败"),
    AUTH_FAILED("A0102", "认证失败"),
    USERNAME_LOCKED("A0103", "账号冻结"),
    USER_NOT_EXIST("A0104", "用户不存在"),
    VALIDATE_FAILED("A0105", "参数校验失败"),


    SYSTEM_ERROR("B0001","系统执行出错"),
    RETURN_STRING_TYPE_ERROR("B0100","返回String类型错误"),
    ;

    private String code;
    private String message;

    ResultCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }

    public static ResultCodeEnum getResultCodeEnum(String code) {
        for (ResultCodeEnum codeEnum : values()) {
            if (code.equals(codeEnum.code())) {
                return codeEnum;
            }
        }
        return null;
    }

}
