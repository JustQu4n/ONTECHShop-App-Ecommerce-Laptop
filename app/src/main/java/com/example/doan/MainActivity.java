package com.example.doan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.doan.Utils.SaveToken;
import com.example.doan.View.activity.HomeActivity;
import com.example.doan.View.activity.LoginActivity;
import com.example.doan.ViewModel.HomeViewModel;
import com.example.doan.ViewModel.LoginViewModel;

public class MainActivity extends AppCompatActivity {


    private LoginViewModel loginViewModel ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler();
        SaveToken.init(this);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences userPref = getApplication().getSharedPreferences("myPreferences", Context.MODE_PRIVATE);
                boolean isLogged = userPref.getBoolean("isFirst", false);
                SharedPreferences preferences = getApplication().getSharedPreferences("onBoard", Context.MODE_PRIVATE);
                boolean isFirstTime = preferences.getBoolean("isFirstTime", true);

                if(!isFirstTime) {
                    boolean isSave = userPref.getBoolean("isSave", false);
                    if(isSave) {
                        String password = userPref.getString("password", null);
                        String email  = userPref.getString("email", null);
                        loginViewModel = new ViewModelProvider(MainActivity.this).get(LoginViewModel.class);
                        try {

                            loginViewModel.login(email, password);
                            loginViewModel.getIsLogin().observeForever(new Observer<Boolean>() {
                                @Override
                                public void onChanged(Boolean aBoolean) {
                                    if(aBoolean) {
                                        Intent i = new Intent(MainActivity.this, HomeActivity.class);
                                        startActivity(i);
                                    }
                                }
                            });
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    } else {
                        Intent i = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(i);
                    }

                } else {
                    isFirstTime();
                }
            }
        }, 1500);
    }

    private void isFirstTime() {
        SharedPreferences preferences = getApplication().getSharedPreferences("onBoard", Context.MODE_PRIVATE);
        boolean isFirstTime = preferences.getBoolean("isFirstTime", true);
        // default value true
        if (isFirstTime) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("isFirstTime", false);
            editor.apply();
            Intent i = new Intent(MainActivity.this, OnboardScreen.class);
            startActivity(i);
            finish();
        } else {
            // start login
            Intent i = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(i);
        }
    }
}