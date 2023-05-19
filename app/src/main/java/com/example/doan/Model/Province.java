package com.example.doan.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Province {

    @SerializedName("ProvinceID")
    @Expose
    private Integer provinceID;
    @SerializedName("ProvinceName")
    @Expose
    private String provinceName;
    @SerializedName("CountryID")
    @Expose
    private Integer countryID;
    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("NameExtension")
    @Expose
    private List<String> nameExtension;
    @SerializedName("IsEnable")
    @Expose
    private Integer isEnable;
    @SerializedName("RegionID")
    @Expose
    private Integer regionID;
    @SerializedName("RegionCPN")
    @Expose
    private Integer regionCPN;
    @SerializedName("UpdatedBy")
    @Expose
    private Integer updatedBy;
    @SerializedName("CreatedAt")
    @Expose
    private String createdAt;
    @SerializedName("UpdatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("CanUpdateCOD")
    @Expose
    private Boolean canUpdateCOD;
    @SerializedName("Status")
    @Expose
    private Integer status;

    public Integer getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(Integer provinceID) {
        this.provinceID = provinceID;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Integer getCountryID() {
        return countryID;
    }

    public void setCountryID(Integer countryID) {
        this.countryID = countryID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<String> getNameExtension() {
        return nameExtension;
    }

    public void setNameExtension(List<String> nameExtension) {
        this.nameExtension = nameExtension;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    public Integer getRegionID() {
        return regionID;
    }

    public void setRegionID(Integer regionID) {
        this.regionID = regionID;
    }

    public Integer getRegionCPN() {
        return regionCPN;
    }

    public void setRegionCPN(Integer regionCPN) {
        this.regionCPN = regionCPN;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getCanUpdateCOD() {
        return canUpdateCOD;
    }

    public void setCanUpdateCOD(Boolean canUpdateCOD) {
        this.canUpdateCOD = canUpdateCOD;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}