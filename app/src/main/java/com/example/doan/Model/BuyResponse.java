package com.example.doan.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class BuyResponse {

    @SerializedName("laptops")
    @Expose
    private List<LaptopBuy> laptops;
    @SerializedName("payment")
    @Expose
    private Integer payment;
    @SerializedName("shipping")
    @Expose
    private ShippingBuy shipping;

    public BuyResponse(List<LaptopBuy> laptops, Integer payment, ShippingBuy shipping) {
        this.laptops = laptops;
        this.payment = payment;
        this.shipping = shipping;
    }

    public List<LaptopBuy> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<LaptopBuy> laptops) {
        this.laptops = laptops;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public ShippingBuy getShipping() {
        return shipping;
    }

    public void setShipping(ShippingBuy shipping) {
        this.shipping = shipping;
    }

}