package com.example.doan.View.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.doan.Model.CartRequest;
import com.example.doan.Model.Image;
import com.example.doan.Model.Laptop;
import com.example.doan.R;
import com.example.doan.View.adapter.ImageAdapter;
import com.example.doan.View.adapter.LaptopAdapter;
import com.example.doan.View.adapter.ViewPagerAdapter;
import com.example.doan.View.adapter.ViewPagerDetailAdapter;
import com.example.doan.View.fragment.HomeFragment;
import com.example.doan.ViewModel.DetailViewModel;
import com.example.doan.ViewModel.FeesViewModel;
import com.example.doan.ViewModel.HomeViewModel;
import com.google.android.material.tabs.TabLayout;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import android.app.AlertDialog;
import android.content.Context;

public class DetailActivity extends AppCompatActivity {

    private DetailViewModel detailViewModel ;
    private RecyclerView rcListImage;
    private RecyclerView rcRecomendLaptop;
    private TextView tvLaptopName;
    private TextView tvLaptopPrice;
    private ViewPagerAdapter viewPagerAdapter ;
    private TabLayout tabLayout ;
    private ViewPager viewPager;
    private ImageView back ;
    private ImageView increase;
    private ImageView decrease;
    private TextView qtyCart ;
    private Button btnAddCart ; 
    private Button btnBuyNow ;
    private Integer laptopId ;
    private  Integer qty ;
    private TextView back_detail;
    private TextView brand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        rcListImage = findViewById(R.id.recycleImageDetail);
        rcRecomendLaptop = findViewById(R.id.RecomRecView_ProductDetailsPage);
        tvLaptopName = findViewById(R.id.productName_ProductDetailsPage);
        tvLaptopPrice = findViewById(R.id.productPrice_ProductDetailsPage);
        rcRecomendLaptop = findViewById(R.id.RecomRecView_ProductDetailsPage);
        tabLayout = findViewById(R.id.tabLayOutDetailPage);
        viewPager = findViewById(R.id.viewPagerDetail);
        back = findViewById(R.id.back_detail);
        increase = findViewById(R.id.increaseDetail);
        decrease = findViewById(R.id.decreseDetail);
        btnAddCart = findViewById(R.id.btnAddToCart); 
        btnBuyNow = findViewById(R.id.btnBuyNow);
        brand = findViewById(R.id.productBrand_ProductDetailsPage);
        qtyCart = findViewById(R.id.quantityTvCartDetail);
     back.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent i =new Intent(DetailActivity.this, HomeFragment.class);
             finish();
             startActivity(i);

         }
     });
        qty = 1;
        
        // qty
        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = qtyCart.getText().toString();
                qty = Integer.parseInt(value);
                qty +=1 ;
                qtyCart.setText(qty + "");
            }
        });
        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = qtyCart.getText().toString();
                Integer qty = Integer.parseInt(value);
                if( !(qty==1)) {
                    qty -= 1 ;
                }
                qtyCart.setText(qty + "");
            }
        });


        Intent intent = getIntent();
        laptopId = intent.getIntExtra("laptopId", 0);

        detailViewModel =  new ViewModelProvider(this).get(DetailViewModel.class);

        detailViewModel.setLaptop(laptopId);
        detailViewModel.getLaptop().observeForever(new Observer<Laptop>() {
            @Override
            public void onChanged(Laptop laptop) {
                List<Image> listImage = laptop.getImages();
                rcListImage.setLayoutManager(new LinearLayoutManager(DetailActivity.this, LinearLayoutManager.HORIZONTAL, false));
                rcListImage.setHasFixedSize(true);
                rcListImage.setAdapter(new ImageAdapter(DetailActivity.this, listImage ));
                brand.setText(laptop.getBrand().getBrandName());
                tvLaptopName.setText(laptop.getLaptopName());
                Locale locale = new Locale("vi", "VN");
                NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
                tvLaptopPrice.setText(nf.format(Double.valueOf(laptop.getPrice())));
                String desc = laptop.getDetailLaptop().getDesc();
                ViewPagerDetailAdapter viewPagerDetailAdapter = new ViewPagerDetailAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, desc);
                viewPager.setAdapter(viewPagerDetailAdapter);
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        detailViewModel.setLaptopRecommend(laptopId);
        detailViewModel.getLaptopRecommend().observeForever(new Observer<List<Laptop>>() {
            @Override
            public void onChanged(List<Laptop> laptops) {
                rcRecomendLaptop.setLayoutManager(new LinearLayoutManager(DetailActivity.this, LinearLayoutManager.HORIZONTAL, false));

                rcRecomendLaptop.setAdapter(new LaptopAdapter(laptops, DetailActivity.this));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        
        // add to cart 
        btnAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart(); 
            }
        });
        btnBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buyNow(); 
            }
        });
    }
    private void buyNow() {
        Intent intent = new Intent(DetailActivity.this, BuyNowActivity.class);
        intent.putExtra("isBuyNow", true);
        intent.putExtra("laptopId", laptopId);
        intent.putExtra("qty", qty );

        startActivity(intent);
    }
    private void addToCart() {
        String value = qtyCart.getText().toString().trim();
        Integer qty = Integer.parseInt(value);
        CartRequest cartRequest = new CartRequest(laptopId, qty);

        detailViewModel.setIsAddCart(cartRequest);
        detailViewModel.getIsAddCart().observeForever(new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DetailActivity.this);
                builder.setTitle("Notification");

              if (aBoolean) {
                  SpannableString spannableString = new SpannableString("Laptop add into cart success");
                  Drawable icon = getResources().getDrawable(R.drawable.icon_success_add);
                  icon.setBounds(0, 0, icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                  ImageSpan imageSpan = new ImageSpan(icon, ImageSpan.ALIGN_BASELINE);
                  spannableString.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                  builder.setMessage(spannableString);


              } else {
                  SpannableString spannableString = new SpannableString("Laptop had in cart");
                  Drawable icon = getResources().getDrawable(R.drawable.icon_warning_add);
                  icon.setBounds(0, 0, icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                  ImageSpan imageSpan = new ImageSpan(icon, ImageSpan.ALIGN_BASELINE);
                  spannableString.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                  builder.setMessage(spannableString);
              }

                builder.setPositiveButton("OK", null);
                builder.show();
            }
        });
    }




}