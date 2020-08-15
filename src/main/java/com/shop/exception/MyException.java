package com.shop.exception;

//自定义异常
public class MyException extends Exception{
    //打印错误信息
    private String msg;
    public MyException(String msg) {
        this.msg = msg;
    }

    public MyException() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
