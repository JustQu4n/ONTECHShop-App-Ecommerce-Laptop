package com.example.doan.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ShippingBuy {

    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("notes")
    @Expose
    private String notes;

    public ShippingBuy(String address, String phone, String notes, Double feesShip) {
        this.address = address;
        this.phone = phone;
        this.notes = notes;
        this.feesShip = feesShip;
    }

    @SerializedName("fees_ship")
    @Expose
    private Double feesShip;

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

    public Double getFeesShip() {
        return feesShip;
    }

    public void setFeesShip(Double feesShip) {
        this.feesShip = feesShip;
    }

}