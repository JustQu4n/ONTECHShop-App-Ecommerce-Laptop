package com.example.doan.View.activity;

import static com.example.doan.Utils.SaveToken.getToken;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.doan.Model.InforShipping;
import com.example.doan.R;
import com.example.doan.Utils.DividerItemDecoration;
import com.example.doan.View.adapter.AddressAdapter;
import com.example.doan.ViewModel.LoginViewModel;
import com.example.doan.ViewModel.ProfileViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ShippingActivity extends AppCompatActivity {

    private ProfileViewModel profileViewModel ;
    private RecyclerView recyclerView;

    private FloatingActionButton btnNew ;

    private ImageView back ;
    private  Intent intent ;
    private  Boolean isBuy ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shiping_address);
        recyclerView = findViewById(R.id.rcAddress);
        btnNew = findViewById(R.id.addAddress_ShippingPage);
        back = findViewById(R.id.back_shipping);
        profileViewModel =  new ViewModelProvider(this).get(ProfileViewModel.class);
        profileViewModel.setValueAddress(getToken());
        intent = getIntent();
        isBuy = intent.getBooleanExtra("isBuy", false);
        profileViewModel.getListInforShipping().observeForever(new Observer<List<InforShipping>>() {
            @Override
            public void onChanged(List<InforShipping> inforShippings) {

                if(inforShippings != null) {
                    recyclerView.setLayoutManager(new LinearLayoutManager(ShippingActivity.this, LinearLayoutManager.VERTICAL, false));
                    recyclerView.setAdapter(new AddressAdapter(ShippingActivity.this, inforShippings));
                }

            }
        });
        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(ShippingActivity.this, AddAddressActivity.class);
                    startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isBuy) {
                    Intent i = new Intent(ShippingActivity.this, BuyNowActivity.class);
                    Boolean isBuyNow = intent.getBooleanExtra("isBuyNow", false);
                    if(isBuyNow) {
                        Integer qty = intent.getIntExtra("qty",0);
                        Integer laptopId = intent.getIntExtra("laptopId", 0);
                        i.putExtra("qty", qty);
                        i.putExtra("laptopId", laptopId);
                    }
                    startActivity(i);
                } else {
                    Intent i = new Intent(ShippingActivity.this, HomeActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}