package com.example.doan.Repository;

import static com.example.doan.Utils.SaveToken.getToken;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;


import com.example.doan.Model.CartRequest;
import com.example.doan.Model.CartUpdate;
import com.example.doan.Model.DataResponse;
import com.example.doan.Network.ApiCart;
import com.example.doan.Network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartRepository {

    private static  ApiCart cartService ;
    private DataResponse dataResponse ;

    public CartRepository() {
        cartService= RetrofitClient.create().create(ApiCart.class);
    }

    public MutableLiveData<DataResponse> getAllItem(String token) {
        MutableLiveData<DataResponse> liveData = new MutableLiveData<>();

        cartService.getCarts(token).enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if(response.isSuccessful()) {
                    liveData.setValue(response.body());
                }
            }
            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
            }
        });

        return  liveData;
    }
    public static   MutableLiveData<Boolean> removeItem(Integer position) {
        MutableLiveData<Boolean> rs = new MutableLiveData<>();

        cartService.removeItem(getToken(), position).enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                Log.d(" Da vaof ", "oenee ");
                if(response.isSuccessful()) {
                    Integer status = response.body().getStatus();
                    if(status == 1 ) {
                        rs.setValue(true);
                    } else rs.setValue(false);
                }
            }
            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {

            }
        });
        return rs;
    }
    public static   MutableLiveData<Boolean> updateItem(Integer laptop_id, Integer qty) {
        MutableLiveData<Boolean> rs = new MutableLiveData<>();

        cartService.updateItem(getToken(), laptop_id, new CartUpdate(qty)).enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if(response.isSuccessful()) {
                    Integer status = response.body().getStatus();
                    if(status == 1 ) {
                        rs.setValue(true);
                    } else rs.setValue(false);
                }
            }
            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {

            }
        });
        return rs;
    }

    public  MutableLiveData<Boolean> insertCart(CartRequest cartRequest) {
        MutableLiveData<Boolean> rs = new MutableLiveData<>();
        cartService.insertItemCart(getToken(), cartRequest).enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if(response.isSuccessful()) {
                    if(response.body().getStatus() == 1) {
                        // add success
                        rs.setValue(true);
                    } else rs.setValue(false);
                }
            }
            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {

            }
        });

        return rs ;
    }

}
