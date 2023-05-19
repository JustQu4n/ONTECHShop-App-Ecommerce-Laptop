package com.example.doan.Network;



import com.example.doan.Model.CartRequest;
import com.example.doan.Model.CartUpdate;
import com.example.doan.Model.DataResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiCart {
    @GET("/api/v1/cart")
    Call<DataResponse> getCarts(@Header("Authorization") String token);


    @DELETE("/api/v1/cart/{laptop_id}")
    Call<DataResponse> removeItem(@Header("Authorization") String token, @Path("laptop_id") Integer id);
    @PUT("/api/v1/cart/{laptop_id}")
    Call<DataResponse> updateItem(@Header("Authorization") String token, @Path("laptop_id") Integer id, @Body CartUpdate qty);

    @POST("/api/v1/cart")
    Call<DataResponse> insertItemCart(@Header("Authorization") String token, @Body CartRequest cartRequest);

}
