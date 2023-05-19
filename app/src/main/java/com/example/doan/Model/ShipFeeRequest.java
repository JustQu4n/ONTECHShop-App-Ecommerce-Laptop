package com.example.doan.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ShipFeeRequest {

    @SerializedName("service_id")
    @Expose
    private Integer serviceId;

    public ShipFeeRequest(Integer serviceId, Integer insuranceValue, Object coupon, Integer fromDistrictId, Integer toDistrictId, String toWardCode, Integer height, Integer length, Integer weight, Integer width) {
        this.serviceId = serviceId;
        this.insuranceValue = insuranceValue;
        this.coupon = coupon;
        this.fromDistrictId = fromDistrictId;
        this.toDistrictId = toDistrictId;
        this.toWardCode = toWardCode;
        this.height = height;
        this.length = length;
        this.weight = weight;
        this.width = width;
    }

    @SerializedName("insurance_value")
    @Expose
    private Integer insuranceValue;
    @SerializedName("coupon")
    @Expose
    private Object coupon;
    @SerializedName("from_district_id")
    @Expose
    private Integer fromDistrictId;
    @SerializedName("to_district_id")
    @Expose
    private Integer toDistrictId;
    @SerializedName("to_ward_code")
    @Expose
    private String toWardCode;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("length")
    @Expose
    private Integer length;
    @SerializedName("weight")
    @Expose
    private Integer weight;
    @SerializedName("width")
    @Expose
    private Integer width;

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getInsuranceValue() {
        return insuranceValue;
    }

    public void setInsuranceValue(Integer insuranceValue) {
        this.insuranceValue = insuranceValue;
    }

    public Object getCoupon() {
        return coupon;
    }

    public void setCoupon(Object coupon) {
        this.coupon = coupon;
    }

    public Integer getFromDistrictId() {
        return fromDistrictId;
    }

    public void setFromDistrictId(Integer fromDistrictId) {
        this.fromDistrictId = fromDistrictId;
    }

    public Integer getToDistrictId() {
        return toDistrictId;
    }

    public void setToDistrictId(Integer toDistrictId) {
        this.toDistrictId = toDistrictId;
    }

    public String getToWardCode() {
        return toWardCode;
    }

    public void setToWardCode(String toWardCode) {
        this.toWardCode = toWardCode;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

}