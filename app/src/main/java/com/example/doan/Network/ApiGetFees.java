package com.example.doan.Network;

import com.example.doan.Model.District;
import com.example.doan.Model.FeesResponse;
import com.example.doan.Model.Province;
import com.example.doan.Model.Response;
import com.example.doan.Model.ServiceFeeResponse;
import com.example.doan.Model.ServiceFeeShip;
import com.example.doan.Model.Ward;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiGetFees {

    // GET LIST PROVINCES
   @GET("shiip/public-api/master-data/province")
   @Headers("token:c8fd103b-c7ba-11ed-bcba-eac62dba9bd9")
    Call<FeesResponse<Province>> getLProvinces();

   @GET("shiip/public-api/master-data/district")
   @Headers("token:c8fd103b-c7ba-11ed-bcba-eac62dba9bd9")
    Call<FeesResponse<District>> getDistricts(@Query("province_id") Integer id);

    @GET("shiip/public-api/master-data/ward")
    @Headers("token:c8fd103b-c7ba-11ed-bcba-eac62dba9bd9")
    Call<FeesResponse<Ward>> getWards(@Query("district_id") Integer id);

    @GET("shiip/public-api/v2/shipping-order/available-services")
    @Headers("token:c8fd103b-c7ba-11ed-bcba-eac62dba9bd9")
    Call<ServiceFeeResponse> getService(@Query("shop_id") Integer shop_id,@Query("from_district") Integer from_district,@Query("to_district") Integer to_district);

    @GET("shiip/public-api/v2/shipping-order/fee")
    @Headers("token:c8fd103b-c7ba-11ed-bcba-eac62dba9bd9")
    Call<Response> getFee(@QueryMap Map<String, Object> queries);

}
