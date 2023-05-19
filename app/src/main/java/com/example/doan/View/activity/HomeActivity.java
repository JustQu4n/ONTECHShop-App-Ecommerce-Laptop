package com.example.doan.View.activity;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import com.example.doan.R;
import com.example.doan.View.fragment.BagFragment;
import com.example.doan.View.fragment.FavFragment;
import com.example.doan.View.fragment.HomeFragment;
import com.example.doan.View.fragment.ProfileFragment;
import com.example.doan.View.fragment.ShopFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Set;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent i = getIntent();
        boolean isSave = i.getBooleanExtra("isSave", false);
        if(isSave) {
            String email = i.getStringExtra("email");
            String password = i.getStringExtra("password");
            String token = i.getStringExtra("token");
            SharedPreferences preferences = getSharedPreferences("myPreferences", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("email", email );
            editor.putString("password", password );
            editor.putBoolean("isSave", true);
            editor.putString("token", token);
            editor.apply();
            Log.d("isSave", email);
        }


        bottomNavigationView = findViewById(R.id.bottomNavMenu);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_fragment, new HomeFragment()).commit();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.homeMenu: {
                HomeFragment fragment = new HomeFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_fragment, fragment, fragment.getClass().getSimpleName())
                        .commit();
                return true;
            }
            case R.id.shopMenu: {
                ShopFragment fragment = new ShopFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_fragment, fragment, fragment.getClass().getSimpleName())
                        .commit();
                return true;
            }
            case R.id.bagMenu: {
                BagFragment fragment = new BagFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_fragment, fragment, fragment.getClass().getSimpleName())
                        .commit();
                return true;
            }
            case R.id.favMenu: {
                FavFragment fragment = new FavFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_fragment, fragment, fragment.getClass().getSimpleName())
                        .commit();
                return true;
            }
            case R.id.profileMenu: {
                ProfileFragment fragment = new ProfileFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_fragment, fragment, fragment.getClass().getSimpleName())
                        .commit();
                return true;
            }
        }
        return false;
    }
}
