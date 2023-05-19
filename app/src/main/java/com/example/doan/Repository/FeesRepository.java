package com.example.doan.Repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.doan.Model.District;
import com.example.doan.Model.FeesResponse;
import com.example.doan.Model.Province;
import com.example.doan.Model.ServiceFeeResponse;
import com.example.doan.Model.ServiceFeeShip;
import com.example.doan.Model.MyRequest;
import com.example.doan.Model.ShipFeeRequest;
import com.example.doan.Model.Ward;
import com.example.doan.Network.ApiGetFees;
import com.example.doan.Network.RetrofitShipping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeesRepository {
    private ApiGetFees apiGetFees ;

    public FeesRepository() {
        this.apiGetFees = RetrofitShipping.create().create(ApiGetFees.class);
    }

    public MutableLiveData<List<Province>> getProvinces() {
        MutableLiveData<List<Province>> list = new MutableLiveData<>();
        apiGetFees.getLProvinces().enqueue(new Callback<FeesResponse<Province>>() {
            @Override
            public void onResponse(Call<FeesResponse<Province>> call, Response<FeesResponse<Province>> response) {
                if(response.isSuccessful()) {
                    List<Province> data = response.body().getData();
                    list.setValue(data);
                }
            }

            @Override
            public void onFailure(Call<FeesResponse<Province>> call, Throwable t) {
            }
        });
        return list ;
    }
    public MutableLiveData<List<District>> getDistricts(int idProvinces) {
        MutableLiveData<List<District>> list = new MutableLiveData<>();
        apiGetFees.getDistricts(idProvinces).enqueue(new Callback<FeesResponse<District>>() {
            @Override
            public void onResponse(Call<FeesResponse<District>> call, Response<FeesResponse<District>> response) {
                if(response.isSuccessful()){
                    List<District> data = response.body().getData();
                    list.setValue(data);
                }
            }
            @Override
            public void onFailure(Call<FeesResponse<District>> call, Throwable t) {

            }
        });

        return  list;
    }

    public  MutableLiveData<List<Ward>> getWards(int provinceId) {
        MutableLiveData<List<Ward>> list = new MutableLiveData<>();

        apiGetFees.getWards(provinceId).enqueue(new Callback<FeesResponse<Ward>>() {
            @Override
            public void onResponse(Call<FeesResponse<Ward>> call, Response<FeesResponse<Ward>> response) {
                if(response.isSuccessful()) {
                    list.setValue(response.body().getData());
                }
            }
            @Override
            public void onFailure(Call<FeesResponse<Ward>> call, Throwable t) {
            }
        });
        return list;
    }

    public MutableLiveData<Integer> getService(MyRequest serviceRequest) {


        MutableLiveData<Integer> data = new MutableLiveData<>();
//        Map<String, Integer> queryMap = new HashMap<>();
//        queryMap.put("shop_id", serviceRequest.getShop_id());
//        queryMap.put("from_district", serviceRequest.getFrom_district());
//        queryMap.put("to_district", serviceRequest.getTo_district());
//        System.out.println(queryMap);

        apiGetFees.getService(serviceRequest.getShop_id(),serviceRequest.getFrom_district(),serviceRequest.getTo_district()).enqueue(new Callback<ServiceFeeResponse>() {
            @Override
            public void onResponse(Call<ServiceFeeResponse> call, Response<ServiceFeeResponse> response) {
            }

            @Override
            public void onFailure(Call<ServiceFeeResponse> call, Throwable t) {

            }
        });
        return data ;
    }

    public  MutableLiveData<Double> getFee(ShipFeeRequest shipFeeRequest) {
        MutableLiveData<Double> data = new MutableLiveData<>();
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("service_id", shipFeeRequest.getServiceId());
        queryMap.put("insurance_value", shipFeeRequest.getInsuranceValue());
        queryMap.put("coupon", shipFeeRequest.getCoupon());
        queryMap.put("from_district_id", shipFeeRequest.getFromDistrictId());
        queryMap.put("to_district_id", shipFeeRequest.getToDistrictId());
        queryMap.put("to_ward_code", shipFeeRequest.getToWardCode());
        queryMap.put("height", shipFeeRequest.getHeight());
        queryMap.put("length", shipFeeRequest.getLength());
        queryMap.put("weight", shipFeeRequest.getWeight());
        queryMap.put("width", shipFeeRequest.getWidth());
        apiGetFees.getFee(queryMap).enqueue(new Callback<com.example.doan.Model.Response>() {
            @Override
            public void onResponse(Call<com.example.doan.Model.Response> call, Response<com.example.doan.Model.Response> response) {
                if(response.isSuccessful()) {
                    if(response.body().getCode() == 200 ) {
                        data.setValue(response.body().getData().getTotal().doubleValue());
                    }
                }
            }

            @Override
            public void onFailure(Call<com.example.doan.Model.Response> call, Throwable t) {

            }
        });
        return data ;
    }
}
