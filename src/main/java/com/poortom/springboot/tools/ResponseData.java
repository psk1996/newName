package com.poortom.springboot.tools;

/**
 * Created by 13620 on 2019/6/16.
 */

public class ResponseData {

    //状态码
    private  int code;

    private String resMessage;

    private Object output;

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getResMessage() {
        return resMessage;
    }

    public void setResMessage(String resMessage) {
        this.resMessage = resMessage;
    }

    public Object getOutput() {
        return output;
    }

    public void setOutput(Object output) {
        this.output = output;
    }

    public ResponseData(int code, String resMessage) {
        this.code = code;
        this.resMessage = resMessage;
    }

    public  ResponseData(int code, String resMessage, String token) {
        this.code = code;
        this.resMessage = resMessage;
        this.token = token;
    }

    public ResponseData(int code, String resMessage, Object output) {
        this.code = code;
        this.resMessage = resMessage;
        this.output = output;
    }

    public ResponseData(int code, String resMessage, Object output, String token) {
        this.code = code;
        this.resMessage = resMessage;
        this.output = output;
        this.token = token;
    }
}
