package com.example.doan.Network;

import com.example.doan.Model.Category;
import com.example.doan.Model.GeneralResponse;
import com.example.doan.Model.User;
import com.example.doan.Model.UserApiResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiCategories {
    @GET("/api/v1/category")
    Call<GeneralResponse<Category>> getAllCategories();

}
