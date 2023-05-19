package com.example.doan.Network;



import com.example.doan.Model.User;
import com.example.doan.Model.UserApiResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiLogin {

    @POST("/api/v1/auth/login")
    Call<UserApiResponse> login(@Body User user);

    @POST("/api/v1/auth/register")
    Call<UserApiResponse> register(@Body User user);
}
