package com.example.doan.Repository;
import static com.example.doan.Utils.SaveToken.getToken;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;


import com.example.doan.Model.BuyResponse;
import com.example.doan.Model.CartUpdate;
import com.example.doan.Model.DataResponse;
import com.example.doan.Model.GeneralResponse;
import com.example.doan.Model.Order;
import com.example.doan.Network.ApiCart;
import com.example.doan.Network.ApiOrder;
import com.example.doan.Network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderRepository {

    private static ApiOrder orderService ;
    private static Boolean isNull ;

    public OrderRepository() {
        orderService= RetrofitClient.create().create(ApiOrder.class);
    }

    public MutableLiveData<List<Order>> getAllOrder(String token) {
        MutableLiveData<List<Order>> listOrder = new MutableLiveData<>();
        orderService.getAllOrder(token).enqueue(new Callback<GeneralResponse<Order>>() {
            @Override
            public void onResponse(Call<GeneralResponse<Order>> call, Response<GeneralResponse<Order>> response) {
                if(response.isSuccessful()) {
                    if(response.body().getStatus() == 1) {
                        List<Order> list = response.body().getData();
                        listOrder.setValue(list);
                    } else {
                        listOrder.setValue(null);
                    }
                }
            }

            @Override
            public void onFailure(Call<GeneralResponse<Order>> call, Throwable t) {

            }
        });
        return  listOrder;
    }

    public  MutableLiveData<Boolean> insertOrder(String token, BuyResponse buyResponse) {
        MutableLiveData<Boolean> result = new MutableLiveData<>();
        orderService.insertOrder(token, buyResponse).enqueue(new Callback<GeneralResponse<Order>>() {
            @Override
            public void onResponse(Call<GeneralResponse<Order>> call, Response<GeneralResponse<Order>> response) {
                if(response.isSuccessful()) {
                    if(response.body().getStatus()==1) result.setValue(true);
                    else result.setValue(false);
                } else result.setValue(false);
            }

            @Override
            public void onFailure(Call<GeneralResponse<Order>> call, Throwable t) {

            }
        });
        return result ;
    }





}
