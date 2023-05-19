package com.example.doan.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class DetailLaptop {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("cpu")
    @Expose
    private String cpu;
    @SerializedName("ram")
    @Expose
    private String ram;
    @SerializedName("rom")
    @Expose
    private String rom;
    @SerializedName("card_vga")
    @Expose
    private String cardVga;
    @SerializedName("webcam")
    @Expose
    private String webcam;
    @SerializedName("connect")
    @Expose
    private String connect;
    @SerializedName("weight")
    @Expose
    private Double weight;
    @SerializedName("pin")
    @Expose
    private String pin;
    @SerializedName("os")
    @Expose
    private String os;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("other")
    @Expose
    private Object other;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public String getCardVga() {
        return cardVga;
    }

    public void setCardVga(String cardVga) {
        this.cardVga = cardVga;
    }

    public String getWebcam() {
        return webcam;
    }

    public void setWebcam(String webcam) {
        this.webcam = webcam;
    }

    public String getConnect() {
        return connect;
    }

    public void setConnect(String connect) {
        this.connect = connect;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getOther() {
        return other;
    }

    public void setOther(Object other) {
        this.other = other;
    }

}