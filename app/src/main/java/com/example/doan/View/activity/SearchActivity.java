package com.example.doan.View.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.doan.Model.Laptop;
import com.example.doan.R;
import com.example.doan.View.adapter.LaptopAdapter;
import com.example.doan.View.fragment.HomeFragment;
import com.example.doan.ViewModel.HomeViewModel;

import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private RecyclerView rcSearch ;
    private ImageView back ;
    private HomeViewModel homeViewModel ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        Intent i = getIntent();
        String keySearch = i.getStringExtra("keySearch");
        homeViewModel = new ViewModelProvider(SearchActivity.this).get(HomeViewModel.class);

        back = findViewById(R.id.backIv_search);
        rcSearch = findViewById(R.id.rcSearchLaptop);

        // get product

        homeViewModel.setListLaptopSearch(keySearch);
        homeViewModel.getListLaptopSearch().observeForever(new Observer<List<Laptop>>() {
            @Override
            public void onChanged(List<Laptop> laptops) {
                Log.d("laptop", laptops.toString());
                rcSearch.setLayoutManager(new GridLayoutManager(SearchActivity.this,1));
                rcSearch.setHasFixedSize(true);
                rcSearch.setAdapter(new LaptopAdapter(laptops, SearchActivity.this));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(SearchActivity.this, HomeFragment.class);
                finish();
                startActivity(i);
            }
        });
    }
}