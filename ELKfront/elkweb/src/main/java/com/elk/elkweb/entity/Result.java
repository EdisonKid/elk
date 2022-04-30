package com.elk.elkweb.entity;

/**
 * @author Edison
 * @create 2022-04-30 19:28
 */
public class Result {
    //响应码
    private int code;

    public Result(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
