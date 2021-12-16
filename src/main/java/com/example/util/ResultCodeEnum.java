package com.example.util;

public enum ResultCodeEnum {
    SUCCESS(true, 200, "成功"),

    UNKNOWN_ERROR(false, 500, "内部错误,请联系管理员"),

    TOkEN_EXPIRED(false, 401, "token过期"),

    LOGIN_EXPIRED(false, 405, "登录信息过期"),

    PARAM_ERROR(false, 400, "参数错误");

    // 响应是否成功
    private Boolean success;

    // 响应状态码
    private Integer code;

    // 响应信息
    private String message;

    ResultCodeEnum(boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
