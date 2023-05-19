package com.example.doan.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ServiceFeeResponse {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("code_message_value")
    @Expose
    private String codeMessageValue;
    @SerializedName("data")
    @Expose
    private List<ServiceFeeShip> data;
    @SerializedName("message")
    @Expose
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getCodeMessageValue() {
        return codeMessageValue;
    }

    public void setCodeMessageValue(String codeMessageValue) {
        this.codeMessageValue = codeMessageValue;
    }

    public List<ServiceFeeShip> getData() {
        return data;
    }

    public void setData(List<ServiceFeeShip> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }}

