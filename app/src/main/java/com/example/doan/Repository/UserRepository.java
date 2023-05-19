package com.example.doan.Repository;

import static com.example.doan.Utils.SaveToken.getToken;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.doan.Model.GeneralResponse;
import com.example.doan.Model.InforShipping;
import com.example.doan.Model.ShippingDefault;
import com.example.doan.Model.User;
import com.example.doan.Model.UserApiResponse;
import com.example.doan.Network.ApiLogin;
import com.example.doan.Network.ApiUser;
import com.example.doan.Network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UserRepository {

    private UserApiResponse userApiResponse;
    private ApiLogin loginService;
    private static ApiUser userService;

    private Integer status ;
    public UserRepository() {
        Retrofit retrofit = RetrofitClient.create();
        loginService = retrofit.create(ApiLogin.class);
        userService = retrofit.create(ApiUser.class);
    }
    public MutableLiveData<UserApiResponse> loginUser(User user) {
        MutableLiveData<UserApiResponse> userLiveData = new MutableLiveData<>();
        loginService.login(user).enqueue(new Callback<UserApiResponse>() {
            @Override
            public void onResponse(Call<UserApiResponse> call, Response<UserApiResponse> response) {
                if (response.isSuccessful()) {
                    Integer status = response.body().getStatus();
                    String message = response.body().getMessage();

                    if(status == 1) {
                        String token = response.headers().get("Authorization");
                        userLiveData.setValue(new UserApiResponse(status,message, token));
                    } else {
                        userLiveData.setValue(new UserApiResponse(status,message, null ));

                    }
                }
            }
            @Override
            public void onFailure(Call<UserApiResponse> call, Throwable t) {
            }
        });
        return userLiveData;
    }
    public Integer getStatus() {
        return status;
    }

    public MutableLiveData<UserApiResponse> registerUser(User user ) {
        MutableLiveData<UserApiResponse> userLiveData = new MutableLiveData<>();
        loginService.register(user).enqueue(new Callback<UserApiResponse>() {
            @Override
            public void onResponse(Call<UserApiResponse> call, Response<UserApiResponse> response) {
                if (response.isSuccessful()) {
                    Integer status = response.body().getStatus();
                    String message = response.body().getMessage();

                    if(status == 1) {
                        String token = response.headers().get("Authorization");
                        userLiveData.setValue(new UserApiResponse(status,message, token));
                    } else {
                        userLiveData.setValue(new UserApiResponse(status,message, null ));
                    }
                }
            }
            @Override
            public void onFailure(Call<UserApiResponse> call, Throwable t) {
            }
        });
        return userLiveData;

    }

     public MutableLiveData<List<InforShipping>> getAllAdress(String token) {
        MutableLiveData<List<InforShipping>> list = new MutableLiveData<>();
        userService.getAllAddress(token).enqueue(new Callback<GeneralResponse<InforShipping>>() {
            @Override
            public void onResponse(Call<GeneralResponse<InforShipping>> call, Response<GeneralResponse<InforShipping>> response) {
                if(response.isSuccessful()) {
                    GeneralResponse data = response.body();
                    if(data.getStatus() == 1) {// equal 1 has address 0 is no address
                        list.setValue(data.getData());
                    } else list.postValue(null);
                }
            }
            @Override
            public void onFailure(Call<GeneralResponse<InforShipping>> call, Throwable t) {

            }
        });
        return  list ;
    }

    public MutableLiveData<InforShipping> getAddressDefault() {
        MutableLiveData<InforShipping> data = new MutableLiveData<>();
        userService.getAddressDefault(getToken()).enqueue(new Callback<GeneralResponse<InforShipping>>() {
            @Override
            public void onResponse(Call<GeneralResponse<InforShipping>> call, Response<GeneralResponse<InforShipping>> response) {
                if(response.isSuccessful()) {
                    if(response.body().getStatus() == 1) {
                        InforShipping inforShipping = response.body().getData().get(0);
                        data.setValue(inforShipping);
                    } else {
                        data.setValue(null);

                    }

                }
            }
            @Override
            public void onFailure(Call<GeneralResponse<InforShipping>> call, Throwable t) {

            }
        });

        return  data;
    }

    public MutableLiveData<Boolean> updateAddress (String token, int id) {
        MutableLiveData<Boolean> check = new MutableLiveData<>() ;
        userService.updateAddress(token, id).enqueue(new Callback<GeneralResponse<InforShipping>>() {
            @Override
            public void onResponse(Call<GeneralResponse<InforShipping>> call, Response<GeneralResponse<InforShipping>> response) {
                if(response.isSuccessful()) {
                    GeneralResponse<InforShipping> result = response.body();
                    if(result.getStatus() == 1) {
                        check.setValue(true);
                    } else check.setValue(false);
                }
            }

            @Override
            public void onFailure(Call<GeneralResponse<InforShipping>> call, Throwable t) {

            }
        });
        return  check;

    }

    public MutableLiveData<Boolean> insertShippingDefault(String token, ShippingDefault data) {
        MutableLiveData<Boolean> rs = new MutableLiveData<>();
        userService.insertShippingDefault(token, data).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    rs.setValue(true);
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
        return  rs;
    }
}
