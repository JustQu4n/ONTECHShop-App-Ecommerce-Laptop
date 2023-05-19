package com.example.doan.Model;

public class Product  {
    private Integer id;
    private String nameProduct;
    private Integer price;
    private  Integer quanty;
    private Integer image;

    public Product(Integer id, String nameProduct, Integer price, Integer quanty, Integer image) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
        this.quanty = quanty;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuanty() {
        return quanty;
    }

    public void setQuanty(Integer quanty) {
        this.quanty = quanty;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
