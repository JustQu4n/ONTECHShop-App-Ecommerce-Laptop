package com.example.doan.Model;

public class CartRequest {

    private  Integer laptop_id ;
    private Integer qty;

    public CartRequest(Integer laptop_id, Integer qty) {
        this.laptop_id = laptop_id;
        this.qty = qty;
    }

    public Integer getLaptop_id() {
        return laptop_id;
    }

    public void setLaptop_id(Integer laptop_id) {
        this.laptop_id = laptop_id;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}
