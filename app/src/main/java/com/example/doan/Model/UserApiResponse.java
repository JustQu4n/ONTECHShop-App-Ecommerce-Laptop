package com.example.doan.Model;

public class UserApiResponse {

    private Integer status ;
    private String message;
    private String token;

    public UserApiResponse(Integer status, String message) {
        this.status = status;
        this.message = message;
    }



    public UserApiResponse(Integer status, String message, String token) {
        this.status = status;
        this.message = message;
        this.token = token;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getToken() {
        return token;
    }
}
