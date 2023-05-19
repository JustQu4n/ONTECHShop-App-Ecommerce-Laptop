package com.example.doan.Repository;

import androidx.lifecycle.MutableLiveData;

import com.example.doan.Model.DataResponse;
import com.example.doan.Model.GeneralResponse;
import com.example.doan.Network.ApiSlider;
import com.example.doan.Network.RetrofitClient;
import com.google.android.material.slider.Slider;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SliderRepository {

    private ApiSlider sliderService ;
    private DataResponse dataResponse ;

    public SliderRepository() {
        sliderService= RetrofitClient.create().create(ApiSlider.class);
    }

    public MutableLiveData<List<com.example.doan.Model.Slider>> getSliders() {
        MutableLiveData<List<com.example.doan.Model.Slider>> liveData = new MutableLiveData<>();
        sliderService.getSliders().enqueue(new Callback<GeneralResponse<com.example.doan.Model.Slider>>() {
            @Override
            public void onResponse(Call<GeneralResponse<com.example.doan.Model.Slider>> call, Response<GeneralResponse<com.example.doan.Model.Slider>> response) {
                if(response.isSuccessful()) {
                    Integer status = response.body().getStatus();
                    if(status == 1) {
                        List<com.example.doan.Model.Slider> listSlider = response.body().getData();
                        liveData.setValue(listSlider);
                    }
                }
            }
            @Override
            public void onFailure(Call<GeneralResponse<com.example.doan.Model.Slider>> call, Throwable t) {

            }
        });
        return liveData;
    }


}
