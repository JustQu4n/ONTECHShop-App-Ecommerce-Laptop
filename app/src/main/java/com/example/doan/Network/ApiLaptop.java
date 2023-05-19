package com.example.doan.Network;


import com.example.doan.Model.BuyResponse;
import com.example.doan.Model.DataResponse;
import com.example.doan.Model.GeneralResponse;
import com.example.doan.Model.Laptop;
import com.example.doan.Model.LaptopResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiLaptop {

    @GET("/api/v1/laptop")
    Call<DataResponse> getLaptops();

    @GET("api/v1/laptop/{id}")
    Call<LaptopResponse> getLaptop(@Path("id") Integer id);

    @GET("api/v1/laptop/category/{id}")
    Call<DataResponse> getCategoryLaptop(@Path("id") Integer id);

    @GET("api/v1/laptop/commend/{id}")
    Call<DataResponse> getCommendLaptop(@Path("id") Integer id);

    @GET("api/v1/laptop/search/search")
    Call<GeneralResponse<Laptop>> getSearch(@Query("keySearch") String keySearch);

}
