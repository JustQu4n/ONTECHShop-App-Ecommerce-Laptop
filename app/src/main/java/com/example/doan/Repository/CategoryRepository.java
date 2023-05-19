package com.example.doan.Repository;

import androidx.lifecycle.MutableLiveData;

import com.example.doan.Model.Category;
import com.example.doan.Model.GeneralResponse;
import com.example.doan.Network.ApiCategories;
import com.example.doan.Network.ApiLaptop;
import com.example.doan.Network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryRepository {

    private ApiCategories apiCategories;





    public  CategoryRepository() {
        apiCategories =  RetrofitClient.create().create(ApiCategories.class);
    }

    public MutableLiveData<List<Category>> getAllCategories() {
        MutableLiveData<List<Category>> list = new MutableLiveData<>();
        apiCategories.getAllCategories().enqueue(new Callback<GeneralResponse<Category>>() {
            @Override
            public void onResponse(Call<GeneralResponse<Category>> call, Response<GeneralResponse<Category>> response) {
                if(response.isSuccessful()) {
                    list.setValue(response.body().getData());
                }
            }
            @Override
            public void onFailure(Call<GeneralResponse<Category>> call, Throwable t) {

            }
        });
        return  list ;
    }
}
