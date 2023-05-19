package com.example.doan.View.activity;

import static com.example.doan.Utils.SaveToken.getToken;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doan.Model.BuyResponse;
import com.example.doan.Model.InforShipping;
import com.example.doan.Model.Laptop;
import com.example.doan.Model.LaptopBuy;
import com.example.doan.Model.MyRequest;
import com.example.doan.Model.ShipFeeRequest;
import com.example.doan.Model.ShippingBuy;
import com.example.doan.Model.UserProfile;
import com.example.doan.R;
import com.example.doan.Utils.NotificationCustom;
import com.example.doan.View.adapter.LaptopBuyAdapter;
import com.example.doan.ViewModel.CartViewModel;
import com.example.doan.ViewModel.DetailViewModel;
import com.example.doan.ViewModel.FeesViewModel;
import com.example.doan.ViewModel.OrderViewModel;
import com.example.doan.ViewModel.ProfileViewModel;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BuyNowActivity extends AppCompatActivity {
    private  DetailViewModel detailViewModel ;
    private FeesViewModel feesViewModel ;
    private ProfileViewModel profileViewModel ;
    private OrderViewModel orderViewModel ;
    private CartViewModel cartViewModel ;
    private List<Laptop> listLaptops = new ArrayList<>();
    private RecyclerView rcListItem ;
    private Integer qty ;
    private Double totalProduct ;
    private Double feeShip ;
    private String name ;
    private TextView tvName ;
    private  TextView tvAddress ;
    private TextView tvTotalProduct ;
    private  TextView tvShippingFee ;
    private TextView tvTotalPayment ;
    private TextView tvLastTotalPayment ;

    private MyRequest serviceRequest ;
    private  Integer wardId;
    private  Integer districtId;
    private Integer service_id ;
    private Integer height ;
    private Integer length ;
    private Integer width ;
    private Integer weight ;
    private Button btnBuyNow ;
    private Integer methodPayment;
    private String address ;
    private String phone ;
    private List<LaptopBuy> listLaptopBuy ;
    private ProgressDialog progressDialog;
    private TextView tvMethodPayment;
    private  Boolean isHasAddress ;
    private LinearLayout selectAddress ;
    private Boolean  isBuyNow ;
    private Integer laptopId ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_now);

        rcListItem = findViewById(R.id.rcLaptopsOrderPage);
        tvName = findViewById(R.id.tvNameBuy);
        tvAddress = findViewById(R.id.tvAddressBuy);
        tvTotalProduct = findViewById(R.id.tvTotalProducts);
        tvShippingFee = findViewById(R.id.tvShippingFee);
        tvTotalPayment = findViewById(R.id.tvTotalPayment);
        tvLastTotalPayment = findViewById(R.id.tvLastTotalPayment);
        btnBuyNow = findViewById(R.id.btnBuyNow);
        progressDialog = new ProgressDialog(BuyNowActivity.this);
        tvMethodPayment = findViewById(R.id.tvmethodPayment);
        selectAddress = findViewById(R.id.selectAddress);
        methodPayment = 1;

        Intent intent = getIntent();
        detailViewModel = new ViewModelProvider(this).get(DetailViewModel.class);
        feesViewModel = new ViewModelProvider(this).get(FeesViewModel.class);
        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        orderViewModel = new ViewModelProvider(this).get(OrderViewModel.class);

        isBuyNow = intent.getBooleanExtra("isBuyNow", false );
        listLaptopBuy = new ArrayList<>();
        Locale locale = new Locale("vi", "VN");
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        totalProduct = 0.0 ;
        qty = 0 ;
        rcListItem.setLayoutManager(new LinearLayoutManager(BuyNowActivity.this, LinearLayoutManager.VERTICAL, false));
        rcListItem.setHasFixedSize(true);
        isHasAddress = true ;
        if(isBuyNow) { // when come from detail page
            laptopId = intent.getIntExtra("laptopId", 0 );
            qty  = intent.getIntExtra("qty", 1);
            feeShip = 20000.0*qty ;
            detailViewModel.setLaptop(laptopId);
            detailViewModel.getLaptop().observeForever(new Observer<Laptop>() {
                @Override
                public void onChanged(Laptop laptop) {
                    laptop.setQty(qty);
                    listLaptops.add(laptop);
                    totalProduct = qty * laptop.getPrice() + 0.0;
                    tvTotalProduct.setText(nf.format(Double.valueOf(totalProduct)));
                    tvLastTotalPayment.setText(nf.format(Double.valueOf(totalProduct + feeShip)));
                    tvTotalPayment.setText(nf.format(Double.valueOf(totalProduct + feeShip)));
                    // set for list laptop
                    LaptopBuy laptopBuy = new LaptopBuy(laptop.getId(), laptop.getPrice()*qty, qty);
                    listLaptopBuy.add(laptopBuy);
                    rcListItem.setAdapter(new LaptopBuyAdapter(BuyNowActivity.this, listLaptops));
                }
            });
        } else {
            cartViewModel = new ViewModelProvider(this).get(CartViewModel.class);
            cartViewModel.setCart();
            cartViewModel.getCart().observeForever(new Observer<List<Laptop>>() {
                @Override
                public void onChanged(List<Laptop> laptops) {
                    listLaptops = laptops ;
                    totalProduct = 0.0 ;
                   for (int i=0 ; i< laptops.size(); i++) {
                        LaptopBuy laptopBuy = new LaptopBuy(laptops.get(i).getId(),  laptops.get(i).getPrice(), laptops.get(i).getQty());
                        listLaptopBuy.add(laptopBuy);
                        qty += laptops.get(i).getQty();
                        totalProduct += laptops.get(i).getPrice()*laptops.get(i).getQty() + 0.0 ;
                   }
                   feeShip = 20000.0 * qty ;
                    tvTotalProduct.setText(nf.format(Double.valueOf(totalProduct)));
                    tvLastTotalPayment.setText(nf.format(Double.valueOf(totalProduct + feeShip)));
                    tvTotalPayment.setText(nf.format(Double.valueOf(totalProduct + feeShip)));
                }
            });
        };
        // set up for delivery
        rcListItem.setAdapter(new LaptopBuyAdapter(BuyNowActivity.this, listLaptops));

        profileViewModel.setAddressDefault();
        profileViewModel.getAddressDefault().observeForever(new Observer<InforShipping>() {
            @Override
            public void onChanged(InforShipping inforShipping) {
                    name = inforShipping.getPhone();
                    districtId = inforShipping.getDistrictId();
                    wardId = inforShipping.getWardId();
                    tvAddress.setText(inforShipping.getAddress());
                    serviceRequest = new MyRequest(1529, districtId);
                    profileViewModel.getProfile(getToken());
                    Locale locale = new Locale("vi", "VN");
                    NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
                    tvShippingFee.setText(nf.format(Double.valueOf(feeShip)));
                    address = inforShipping.getAddress();
                    phone = inforShipping.getPhone();
                    feesViewModel.setService(serviceRequest);
            }
        });
        profileViewModel.getIsHasAddressDefault().observeForever(new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(!aBoolean) {
                    isHasAddress = false ;
                    tvTotalPayment.setText("Add address delivery");
                    tvLastTotalPayment.setText("Add address delivery");
                    tvShippingFee.setText("Add address delivery");
                    tvName.setText("Add address delivery");
                    tvAddress.setVisibility(View.INVISIBLE);
                } else  {
                    isHasAddress = true ;
                }
            }
        });
        profileViewModel.getUserProfile().observeForever(new Observer<UserProfile>() {
            @Override
            public void onChanged(UserProfile userProfile) {
                name  = userProfile.getName() + " | " + name ;
                tvName.setText(name);
            }
        });

        // get fee ship
        feesViewModel.getService().observeForever(new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                service_id = integer ;
                ShipFeeRequest shipFeeRequest = new ShipFeeRequest(service_id, 500000, null,
                                                        1529, districtId, wardId+"", height, length, weight, width);
                feesViewModel.setFee(shipFeeRequest);
            }
        });
        if(methodPayment == 1) {
            tvMethodPayment.setText("Method payment: " + "COD");
        }
        btnBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isHasAddress) {
                    Toast.makeText(BuyNowActivity.this, "Please add address delivery", Toast.LENGTH_LONG).show();
                } else  buyNow();
            }
        });

        selectAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isHasAddress) {
                    Intent i = new Intent(BuyNowActivity.this, ShippingActivity.class);
                    i.putExtra("isBuy", true);
                    if(isBuyNow) {
                        i.putExtra("isBuyNow", true);
                        i.putExtra("laptopId", laptopId);
                        i.putExtra("qty", qty);
                        Integer qty = i.getIntExtra("qty", 0);
                        Integer laptopId = i.getIntExtra("laptopId", 0 );
                        i.putExtra("isBuyNow", true);
                        i.putExtra("qty", qty);
                        i.putExtra("laptopId", laptopId);
                    }
                    startActivity(i);
                } else {
                    Intent i = new Intent(BuyNowActivity.this, AddAddressActivity.class);
                    i.putExtra("isBuy", true);
                    if(isBuyNow) {
                        i.putExtra("isBuyNow", true);
                        i.putExtra("laptopId", laptopId);
                        i.putExtra("qty", qty);
                        Integer qty = i.getIntExtra("qty", 0);
                        Integer laptopId = i.getIntExtra("laptopId", 0 );
                        i.putExtra("isBuyNow", true);
                        i.putExtra("qty", qty);
                        i.putExtra("laptopId", laptopId);
                    }
                    startActivity(i);
                }

            }
        });

    }
    private void buyNow() {

        ShippingBuy shippingBuy = new ShippingBuy(address, phone, "Notes ", feeShip);
        BuyResponse buyResponse = new BuyResponse(listLaptopBuy, methodPayment, shippingBuy);

        orderViewModel.setIsOrder(buyResponse);
        orderViewModel.getIsOrder().observeForever(new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    progressDialog.setMessage("Order success ...");
                    progressDialog.show();
                    new NotificationCustom(BuyNowActivity.this);
                    Intent intent = new Intent(BuyNowActivity.this, OrderActivity.class);
                    intent.putExtra("isBuy", true);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(BuyNowActivity.this, "Order false", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}