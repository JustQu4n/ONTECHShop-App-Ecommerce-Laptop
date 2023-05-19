package com.example.doan.View.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.doan.Model.Order;
import com.example.doan.R;
import com.example.doan.View.adapter.ViewPagerAdapter;
import com.example.doan.View.fragment.ProfileFragment;
import com.example.doan.ViewModel.OrderViewModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {


    private TabLayout tabLayout ;
    private ViewPager viewPager ;
    private ImageView back ;
    private List<Order> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        tabLayout = findViewById(R.id.tabLayoutOrder);
        viewPager = findViewById(R.id.viewPagerOrder);
        back = findViewById(R.id.backIv_PaymentMethodsPageOrder);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        Intent i = getIntent();
        Boolean isBuyNow = i.getBooleanExtra("isBuyNow", false);
        if(isBuyNow) {

        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OrderActivity.this, HomeActivity.class);
                startActivity(i);
            }
        });

    }

}
