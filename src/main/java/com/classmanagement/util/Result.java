package com.classmanagement.util;

public class Result {

    public static Integer SUCCESS = 1;
    public static Integer FAIL = 0;

    /*状态码*/
    private Integer code;
    /*消息*/
    private String message;
    /*数据*/
    private Object data;

    public static Result success(String message, Object data){
        return new Result(SUCCESS, message, data);
    }

    public static Result success(String message){
        return success(message, null);
    }

    public static Result fail(String message, Object data){
        return new Result(FAIL, message, data);
    }

    public static Result fail(String message){
        return fail(message, null);
    }

    public Result() {
    }

    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
