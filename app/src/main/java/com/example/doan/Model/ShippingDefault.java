package com.example.doan.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ShippingDefault {

    @SerializedName("address")
    @Expose
    private String address;

    public ShippingDefault(String address, String phone, Integer wardId, Integer districtId) {
        this.address = address;
        this.phone = phone;
        this.wardId = wardId;
        this.districtId = districtId;
    }

    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("ward_id")
    @Expose
    private Integer wardId;
    @SerializedName("district_id")
    @Expose
    private Integer districtId;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getWardId() {
        return wardId;
    }

    public void setWardId(Integer wardId) {
        this.wardId = wardId;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

}