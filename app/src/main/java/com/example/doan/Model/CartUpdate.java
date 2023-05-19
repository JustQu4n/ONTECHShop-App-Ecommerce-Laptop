package com.example.doan.Model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CartUpdate {
    @SerializedName("qty")
    @Expose
    private Integer qty;


    public Integer getLaptopId() {
        return qty;
    }

    public void setLaptopId(Integer laptopId) {
        this.qty = laptopId;
    }
    public CartUpdate(Integer qty) {
        this.qty = qty;
    }
}