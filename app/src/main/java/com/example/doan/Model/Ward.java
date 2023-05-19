package com.example.doan.Model;



import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Ward {

    @SerializedName("WardCode")
    @Expose
    private String wardCode;
    @SerializedName("DistrictID")
    @Expose
    private Integer districtID;
    @SerializedName("WardName")
    @Expose
    private String wardName;
    @SerializedName("NameExtension")
    @Expose
    private List<String> nameExtension;
    @SerializedName("CanUpdateCOD")
    @Expose
    private Boolean canUpdateCOD;
    @SerializedName("SupportType")
    @Expose
    private Integer supportType;
    @SerializedName("PickType")
    @Expose
    private Integer pickType;
    @SerializedName("DeliverType")
    @Expose
    private Integer deliverType;
    @SerializedName("WhiteListClient")
    @Expose
    private WhiteListClient whiteListClient;
    @SerializedName("WhiteListWard")
    @Expose
    private WhiteListWard whiteListWard;
    @SerializedName("Status")
    @Expose
    private Integer status;
    @SerializedName("ReasonCode")
    @Expose
    private String reasonCode;
    @SerializedName("ReasonMessage")
    @Expose
    private String reasonMessage;
    @SerializedName("OnDates")
    @Expose
    private Object onDates;
    @SerializedName("CreatedIP")
    @Expose
    private String createdIP;
    @SerializedName("CreatedEmployee")
    @Expose
    private Integer createdEmployee;
    @SerializedName("CreatedSource")
    @Expose
    private String createdSource;
    @SerializedName("CreatedDate")
    @Expose
    private String createdDate;
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

    public String getWardCode() {
        return wardCode;
    }

    public void setWardCode(String wardCode) {
        this.wardCode = wardCode;
    }

    public Integer getDistrictID() {
        return districtID;
    }

    public void setDistrictID(Integer districtID) {
        this.districtID = districtID;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    public List<String> getNameExtension() {
        return nameExtension;
    }

    public void setNameExtension(List<String> nameExtension) {
        this.nameExtension = nameExtension;
    }

    public Boolean getCanUpdateCOD() {
        return canUpdateCOD;
    }

    public void setCanUpdateCOD(Boolean canUpdateCOD) {
        this.canUpdateCOD = canUpdateCOD;
    }

    public Integer getSupportType() {
        return supportType;
    }

    public void setSupportType(Integer supportType) {
        this.supportType = supportType;
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

    public WhiteListWard getWhiteListWard() {
        return whiteListWard;
    }

    public void setWhiteListWard(WhiteListWard whiteListWard) {
        this.whiteListWard = whiteListWard;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Object getOnDates() {
        return onDates;
    }

    public void setOnDates(Object onDates) {
        this.onDates = onDates;
    }

    public String getCreatedIP() {
        return createdIP;
    }

    public void setCreatedIP(String createdIP) {
        this.createdIP = createdIP;
    }

    public Integer getCreatedEmployee() {
        return createdEmployee;
    }

    public void setCreatedEmployee(Integer createdEmployee) {
        this.createdEmployee = createdEmployee;
    }

    public String getCreatedSource() {
        return createdSource;
    }

    public void setCreatedSource(String createdSource) {
        this.createdSource = createdSource;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
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

public class WhiteListWard {

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

}}