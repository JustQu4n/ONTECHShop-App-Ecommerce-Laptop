package com.example.doan.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class LaptopBuy {

    @SerializedName("laptop_id")
    @Expose
    private Integer laptopId;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("qty")
    @Expose
    private Integer qty;

    public LaptopBuy(Integer laptopId, Integer price, Integer qty) {
        this.laptopId = laptopId;
        this.price = price;
        this.qty = qty;
    }

    public Integer getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(Integer laptopId) {
        this.laptopId = laptopId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

}