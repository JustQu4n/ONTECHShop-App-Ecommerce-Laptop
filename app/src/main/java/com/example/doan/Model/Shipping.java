package com.example.doan.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Shipping {

    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("notes")
    @Expose
    private String notes;
    @SerializedName("fees_ship")
    @Expose
    private Integer feesShip;

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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getFeesShip() {
        return feesShip;
    }

    public void setFeesShip(Integer feesShip) {
        this.feesShip = feesShip;
    }

}