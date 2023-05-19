package com.example.doan.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.doan.Model.User;
import com.example.doan.Model.UserApiResponse;
import com.example.doan.Repository.UserRepository;
import com.example.doan.Utils.SaveToken;

public class SignUpViewModel extends ViewModel {

    private MutableLiveData<Boolean> isSignUp = new MutableLiveData<>();
    private MutableLiveData<UserApiResponse> userLiveData = new MutableLiveData<>();
    private UserRepository userRepository;
    public SignUpViewModel() {
        userRepository = new UserRepository();
    }

    public MutableLiveData<Boolean> getIsLogin() {
        return isSignUp;
    }

    public  void register(User user ) throws InterruptedException {
        userRepository.registerUser(user).observeForever(new Observer<UserApiResponse>() {
            @Override
            public void onChanged(UserApiResponse userApiResponse) {
                if(userApiResponse.getStatus() == 1) {
                    isSignUp.setValue(true);
                    SaveToken.saveTokens(userApiResponse.getToken());
                } else {
                    isSignUp.setValue(false);
                }
            }
        });
    }

    public MutableLiveData<Boolean> getIsSignUp() {
        return isSignUp;
    }
}
