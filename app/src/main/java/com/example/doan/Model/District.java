package com.example.doan.Model;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class District {

    @SerializedName("DistrictID")
    @Expose
    private Integer districtID;
    @SerializedName("ProvinceID")
    @Expose
    private Integer provinceID;
    @SerializedName("DistrictName")
    @Expose
    private String districtName;
    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("Type")
    @Expose
    private Integer type;
    @SerializedName("SupportType")
    @Expose
    private Integer supportType;
    @SerializedName("NameExtension")
    @Expose
    private List<String> nameExtension;
    @SerializedName("IsEnable")
    @Expose
    private Integer isEnable;
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
    @SerializedName("PickType")
    @Expose
    private Integer pickType;
    @SerializedName("DeliverType")
    @Expose
    private Integer deliverType;
    @SerializedName("WhiteListClient")
    @Expose
    private WhiteListClient whiteListClient;
    @SerializedName("WhiteListDistrict")
    @Expose
    private WhiteListDistrict whiteListDistrict;
    @SerializedName("ReasonCode")
    @Expose
    private String reasonCode;
    @SerializedName("ReasonMessage")
    @Expose
    private String reasonMessage;
    @SerializedName("OnDates")
    @Expose
    private List<String> onDates;
    @SerializedName("UpdatedIP")
    @Expose
    private String updatedIP;
    @SerializedName("UpdatedEmployee")
    @Expose
    private Integer updatedEmployee;
    @SerializedName("UpdatedSource")
    @Expose
    private String updatedSource;
    @SerializedName("UpdatedDate")
    @Expose
    private String updatedDate;

    public Integer getDistrictID() {
        return districtID;
    }

    public void setDistrictID(Integer districtID) {
        this.districtID = districtID;
    }

    public Integer getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(Integer provinceID) {
        this.provinceID = provinceID;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSupportType() {
        return supportType;
    }

    public void setSupportType(Integer supportType) {
        this.supportType = supportType;
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

    public Integer getPickType() {
        return pickType;
    }

    public void setPickType(Integer pickType) {
        this.pickType = pickType;
    }

    public Integer getDeliverType() {
        return deliverType;
    }

    public void setDeliverType(Integer deliverType) {
        this.deliverType = deliverType;
    }

    public WhiteListClient getWhiteListClient() {
        return whiteListClient;
    }

    public void setWhiteListClient(WhiteListClient whiteListClient) {
        this.whiteListClient = whiteListClient;
    }

    public WhiteListDistrict getWhiteListDistrict() {
        return whiteListDistrict;
    }

    public void setWhiteListDistrict(WhiteListDistrict whiteListDistrict) {
        this.whiteListDistrict = whiteListDistrict;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getReasonMessage() {
        return reasonMessage;
    }

    public void setReasonMessage(String reasonMessage) {
        this.reasonMessage = reasonMessage;
    }

    public List<String> getOnDates() {
        return onDates;
    }

    public void setOnDates(List<String> onDates) {
        this.onDates = onDates;
    }

    public String getUpdatedIP() {
        return updatedIP;
    }

    public void setUpdatedIP(String updatedIP) {
        this.updatedIP = updatedIP;
    }

    public Integer getUpdatedEmployee() {
        return updatedEmployee;
    }

    public void setUpdatedEmployee(Integer updatedEmployee) {
        this.updatedEmployee = updatedEmployee;
    }

    public String getUpdatedSource() {
        return updatedSource;
    }

    public void setUpdatedSource(String updatedSource) {
        this.updatedSource = updatedSource;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

}

class WhiteListClient {

    @SerializedName("From")
    @Expose
    private Object from;
    @SerializedName("To")
    @Expose
    private Object to;
    @SerializedName("Return")
    @Expose
    private Object _return;

    public Object getFrom() {
        return from;
    }

    public void setFrom(Object from) {
        this.from = from;
    }

    public Object getTo() {
        return to;
    }

    public void setTo(Object to) {
        this.to = to;
    }

    public Object getReturn() {
        return _return;
    }

    public void setReturn(Object _return) {
        this._return = _return;
    }

}

class WhiteListDistrict {

    @SerializedName("From")
    @Expose
    private Object from;
    @SerializedName("To")
    @Expose
    private Object to;

    public Object getFrom() {
        return from;
    }

    public void setFrom(Object from) {
        this.from = from;
    }

    public Object getTo() {
        return to;
    }

    public void setTo(Object to) {
        this.to = to;
    }

}
