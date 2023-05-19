package com.example.doan.Repository;

import androidx.lifecycle.MutableLiveData;

import com.example.doan.Model.DataResponse;
import com.example.doan.Model.UserProfile;
import com.example.doan.Network.ApiCart;
import com.example.doan.Network.ApiUser;
import com.example.doan.Network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileRepository {

    private static ApiUser profileService;
//    private static UserProfile userProfile;

    public ProfileRepository() {
        profileService = RetrofitClient.create().create(ApiUser.class);
    }
    public MutableLiveData<UserProfile> getProfile(String token) {
        MutableLiveData<UserProfile> userProfile = new MutableLiveData<>();

        profileService.getProfile(token).enqueue(new Callback<UserProfile>() {
            @Override
            public void onResponse(Call<UserProfile> call, Response<UserProfile> response) {
                if (response.isSuccessful()) {
                    userProfile.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<UserProfile> call, Throwable t) {

            }
        });
        return userProfile;
    }
}


