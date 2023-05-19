package com.example.doan.View.activity;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.doan.Model.Laptop;
import com.example.doan.R;
import com.example.doan.View.adapter.LaptopAdapter;
import com.example.doan.View.fragment.HomeFragment;
import com.example.doan.View.fragment.ShopFragment;
import com.example.doan.ViewModel.HomeViewModel;

import java.security.Provider;
import java.util.List;

public class CateogryActivity extends AppCompatActivity {

    private TextView categoryName ;
    private RecyclerView recyclerCategories ;
    private HomeViewModel homeViewModel ;
    private ImageView backView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cateogry);
        Intent i = getIntent() ;
        Integer category_id = i.getIntExtra("category_id", 0 );
        String name = i.getStringExtra("categoryName");
        categoryName = findViewById(R.id.categoryName);
        recyclerCategories = findViewById(R.id.recycleCategory);
        backView = findViewById(R.id.searchIv_ProfileFrag);

        backView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(CateogryActivity.this, ShopFragment.class);
                finish();
                startActivity(i);

            }
        });
        categoryName.setText(name);

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        homeViewModel.setListLaptopSale(category_id);
        homeViewModel.getListLaptopSale().observeForever(new Observer<List<Laptop>>() {
            @Override
            public void onChanged(List<Laptop> laptops) {
                recyclerCategories.setLayoutManager(new GridLayoutManager(CateogryActivity.this, 2));
                recyclerCategories.setAdapter( new LaptopAdapter(laptops, CateogryActivity.this));
            }
        });
    }
}