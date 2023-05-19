package com.example.doan.Network;

import com.example.doan.Model.DataResponse;
import com.example.doan.Model.GeneralResponse;
import com.example.doan.Model.InforShipping;
import com.example.doan.Model.ShippingDefault;
import com.example.doan.Model.UserProfile;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiUser {

    @GET("api/v1/user")
    Call<UserProfile> getProfile(@Header("Authorization") String token);

    @GET("api/v1/user/address")
    Call<GeneralResponse<InforShipping>> getAllAddress(@Header("Authorization") String token);

    @GET("api/v1/user/address/default")
    Call<GeneralResponse<InforShipping>> getAddressDefault(@Header("Authorization") String token);

    // update shipping
    @PUT("api/v1/user/address/{id}")
    Call<GeneralResponse<InforShipping>> updateAddress(@Header("Authorization") String token , @Path("id") int  id);

    @POST("api/v1/user/address")
    Call<Void> insertShippingDefault (@Header("Authorization") String token, @Body ShippingDefault data);



}
