package com.example.doan.Network;

import com.example.doan.Model.DataResponse;
import com.example.doan.Model.GeneralResponse;
import com.example.doan.Model.Slider;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ApiSlider {

    @GET("/api/v1/slider")
    Call<GeneralResponse<Slider>> getSliders();
}
