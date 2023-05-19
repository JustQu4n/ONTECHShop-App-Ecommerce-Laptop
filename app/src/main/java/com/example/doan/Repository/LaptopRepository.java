package com.example.doan.Repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;


import com.example.doan.Model.DataResponse;
import com.example.doan.Model.GeneralResponse;
import com.example.doan.Model.Laptop;
import com.example.doan.Model.LaptopResponse;
import com.example.doan.Network.ApiLaptop;
import com.example.doan.Network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LaptopRepository {

    private ApiLaptop laptopService;

    public LaptopRepository() {
        laptopService = RetrofitClient.create().create(ApiLaptop.class);
    }

    public MutableLiveData<DataResponse> getLaptops() {
        MutableLiveData<DataResponse> liveData = new MutableLiveData<>();
        laptopService.getLaptops().enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if (response.isSuccessful()) {
                    liveData.setValue(response.body());
                }
            }
            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
            }
        });
        return  liveData;
    }

    public  MutableLiveData<Laptop> getLaptop(Integer id) {
        MutableLiveData<Laptop> data = new MutableLiveData<>();
        laptopService.getLaptop(id).enqueue(new Callback<LaptopResponse>() {
            @Override
            public void onResponse(Call<LaptopResponse> call, Response<LaptopResponse> response) {
                if(response.isSuccessful()) {
                    if(response.body().getStatus() == 1) {
                        Laptop laptop = response.body().getLaptop();
                        data.setValue(laptop);
                    }
                }
            }
            @Override
            public void onFailure(Call<LaptopResponse> call, Throwable t) {

            }
        });
        return  data ;
    }
    public  MutableLiveData<DataResponse> getCategoryLaptop(Integer id) {
        MutableLiveData<DataResponse> liveData = new MutableLiveData<>();
        laptopService.getCategoryLaptop(id).enqueue(new Callback<DataResponse>() {
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

    public MutableLiveData<List<Laptop>> getCommendLaptop(Integer id) {
        MutableLiveData<List<Laptop>> data = new MutableLiveData<>();
        laptopService.getCommendLaptop(id).enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if(response.isSuccessful()) {
                    if(response.body().getStatus() == 1) {
                        List<Laptop> listLaptop = response.body().getData().getRows();
                        data.setValue(listLaptop);
                    }
                }
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {

            }
        });
        return data ;
    }

    public MutableLiveData<List<Laptop>> getLaptopSearch(String keySearch) {
        MutableLiveData<List<Laptop>> data = new MutableLiveData<>() ;

        laptopService.getSearch(keySearch).enqueue(new Callback<GeneralResponse<Laptop>>() {
            @Override
            public void onResponse(Call<GeneralResponse<Laptop>> call, Response<GeneralResponse<Laptop>> response) {
                if(response.isSuccessful()) {
                    if(response.body().getStatus() == 1) {
                        data.setValue(response.body().getData());
                    }
                }
            }

            @Override
            public void onFailure(Call<GeneralResponse<Laptop>> call, Throwable t) {

            }
        });

        return data ;
    }



}
