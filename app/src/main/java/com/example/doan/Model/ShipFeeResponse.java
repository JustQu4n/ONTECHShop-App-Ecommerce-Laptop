package com.example.doan.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ShipFeeResponse {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("service_fee")
    @Expose
    private Integer serviceFee;
    @SerializedName("insurance_fee")
    @Expose
    private Integer insuranceFee;
    @SerializedName("pick_station_fee")
    @Expose
    private Integer pickStationFee;
    @SerializedName("coupon_value")
    @Expose
    private Integer couponValue;
    @SerializedName("r2s_fee")
    @Expose
    private Integer r2sFee;
    @SerializedName("document_return")
    @Expose
    private Integer documentReturn;
    @SerializedName("double_check")
    @Expose
    private Integer doubleCheck;
    @SerializedName("cod_fee")
    @Expose
    private Integer codFee;
    @SerializedName("pick_remote_areas_fee")
    @Expose
    private Integer pickRemoteAreasFee;
    @SerializedName("deliver_remote_areas_fee")
    @Expose
    private Integer deliverRemoteAreasFee;
    @SerializedName("cod_failed_fee")
    @Expose
    private Integer codFailedFee;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(Integer serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Integer getInsuranceFee() {
        return insuranceFee;
    }

    public void setInsuranceFee(Integer insuranceFee) {
        this.insuranceFee = insuranceFee;
    }

    public Integer getPickStationFee() {
        return pickStationFee;
    }

    public void setPickStationFee(Integer pickStationFee) {
        this.pickStationFee = pickStationFee;
    }

    public Integer getCouponValue() {
        return couponValue;
    }

    public void setCouponValue(Integer couponValue) {
        this.couponValue = couponValue;
    }

    public Integer getR2sFee() {
        return r2sFee;
    }

    public void setR2sFee(Integer r2sFee) {
        this.r2sFee = r2sFee;
    }

    public Integer getDocumentReturn() {
        return documentReturn;
    }

    public void setDocumentReturn(Integer documentReturn) {
        this.documentReturn = documentReturn;
    }

    public Integer getDoubleCheck() {
        return doubleCheck;
    }

    public void setDoubleCheck(Integer doubleCheck) {
        this.doubleCheck = doubleCheck;
    }

    public Integer getCodFee() {
        return codFee;
    }

    public void setCodFee(Integer codFee) {
        this.codFee = codFee;
    }

    public Integer getPickRemoteAreasFee() {
        return pickRemoteAreasFee;
    }

    public void setPickRemoteAreasFee(Integer pickRemoteAreasFee) {
        this.pickRemoteAreasFee = pickRemoteAreasFee;
    }

    public Integer getDeliverRemoteAreasFee() {
        return deliverRemoteAreasFee;
    }

    public void setDeliverRemoteAreasFee(Integer deliverRemoteAreasFee) {
        this.deliverRemoteAreasFee = deliverRemoteAreasFee;
    }

    public Integer getCodFailedFee() {
        return codFailedFee;
    }

    public void setCodFailedFee(Integer codFailedFee) {
        this.codFailedFee = codFailedFee;
    }

}
