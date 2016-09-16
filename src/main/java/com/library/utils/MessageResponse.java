package com.library.utils;

/**
 * Created by dmitry on 16.09.16.
 */
public class MessageResponse {

    private String code;
    private String message;

    public MessageResponse() {
    }

    public MessageResponse(String code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
