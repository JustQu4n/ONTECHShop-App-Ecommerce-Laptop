package com.example.doan.View.activity;

import static com.example.doan.Utils.SaveToken.getToken;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doan.Model.District;
import com.example.doan.Model.Province;
import com.example.doan.Model.ShippingDefault;
import com.example.doan.Model.Ward;
import com.example.doan.Network.ApiGetFees;
import com.example.doan.R;
import com.example.doan.View.adapter.FeesShipAdapter;
import com.example.doan.ViewModel.FeesViewModel;
import com.example.doan.ViewModel.HomeViewModel;
import com.example.doan.ViewModel.ProfileViewModel;

import java.util.ArrayList;
import java.util.List;

public class AddAddressActivity extends AppCompatActivity {

    private ImageView back ;
    private Button btnAdd ;
    private AutoCompleteTextView autoProvince;

    private AutoCompleteTextView autoDistrict;
    private AutoCompleteTextView autoWards;
    private EditText edPhone;

    private EditText edVillage;
    private FeesViewModel feesViewModel;


    private List<String> listProvinces;
    private  List<Integer> listProvinceId;
    private List<String> listDistrict;
    private List<Integer> listDistrictId;
    private List<String> listWard;
    private  List<String> listWardId;
    private  Integer provincePosition;
    private  Integer districtPosition;
    private  Integer wardPosition;
    private  Boolean isBuy  ;
    private  Intent intent ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);

        back = findViewById(R.id.backAddAddress);
        btnAdd = findViewById(R.id.btnAddAddress);
        autoProvince = findViewById(R.id.autoProvince);
        autoDistrict = findViewById(R.id.autoDistrict);
        autoWards = findViewById(R.id.autoWards);

        edPhone = findViewById(R.id.edtPhoneAdd);
        edVillage = findViewById(R.id.edtAddressAddd);
        feesViewModel = new ViewModelProvider(this).get(FeesViewModel.class);
        feesViewModel.setProvinceList();

        intent  = getIntent() ;
        isBuy = intent.getBooleanExtra("isBuy", false);
        feesViewModel.getProvinceList().observeForever(new Observer<List<Province>>() {
            @Override
            public void onChanged(List<Province> provinces) {
                List<String> list = new ArrayList<>();
                List<Integer> list_id = new ArrayList<>();

                for (Province item: provinces) {
                    list.add(item.getProvinceName());
                    list_id.add(item.getProvinceID());

                }
                listProvinces = list;
                listProvinceId = list_id;
                ArrayAdapter provincesAdapter = new ArrayAdapter(AddAddressActivity.this, android.R.layout.simple_list_item_1, listProvinces);
                FeesShipAdapter feesShipAdapter = new FeesShipAdapter(AddAddressActivity.this,android.R.layout.simple_list_item_1, listProvinces);
                autoProvince.setAdapter(provincesAdapter);
            }
        });

        // set apdapter for ward
        feesViewModel.getListWard().observeForever(new Observer<List<Ward>>() {
            @Override
            public void onChanged(List<Ward> wards) {
                List<String> list = new ArrayList<>();
                List<String> list_id = new ArrayList<>();
                for (Ward item: wards) {
                    list.add(item.getWardName());
                    list_id.add(item.getWardCode());
                }
                listWard = list;
                listWardId = list_id;
                ArrayAdapter provincesAdapter = new ArrayAdapter(AddAddressActivity.this, android.R.layout.simple_list_item_1, listWard);
                FeesShipAdapter feesShipAdapter = new FeesShipAdapter(AddAddressActivity.this,android.R.layout.simple_list_item_1, listWard);
                autoWards.setAdapter(provincesAdapter);
            }
        });



        autoProvince.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // get list district of province
                provincePosition = position ;
                feesViewModel.setListDistrict(listProvinceId.get(position));
            }
        });

        autoDistrict.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                districtPosition = position;
                feesViewModel.setListWard(listDistrictId.get(position));
            }
        });

        autoWards.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                wardPosition = position;
            }
        });



        // set list district for adapter
        feesViewModel.getListDistrict().observeForever(new Observer<List<District>>() {
            @Override
            public void onChanged(List<District> districts) {
                List<String> listName = new ArrayList<>();
                List<Integer> listId = new ArrayList<>();
                for (District item: districts) {
                    listName.add(item.getDistrictName());
                    listId.add(item.getDistrictID());
                }
                listDistrict = listName;
                listDistrictId = listId;
                ArrayAdapter adapter = new ArrayAdapter(AddAddressActivity.this, android.R.layout.simple_list_item_1, listDistrict);
                autoDistrict.setAdapter(adapter);

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        autoProvince.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) autoProvince.showDropDown();
            }
        });

        autoDistrict.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) autoDistrict.showDropDown();
            }
        });

        autoWards.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) autoWards.showDropDown();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addShipping();

            }
        });

        feesViewModel.getIsInsertShippingDefault().observeForever(new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean && !isBuy) {
                    Intent i = new Intent(AddAddressActivity.this, ShippingActivity.class);
                    startActivity(i);
                } else {

                    Intent i = new Intent(AddAddressActivity.this, BuyNowActivity.class);
                    Boolean isBuyNow = intent.getBooleanExtra("isBuyNow", false);
                    if(isBuyNow) {
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
//        autoProvince.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                autoProvince.showDropDown();
//            }
//        });

    }

    private void addShipping() {

        String phone = edPhone.getText().toString().trim();
        String village = edVillage.getText().toString().trim();
        Boolean check = check(phone, village);
        if (!check)  {
            Toast.makeText(AddAddressActivity.this, "Please check input", Toast.LENGTH_LONG).show();
        } else {
            String address = village + " " + listWard.get(wardPosition) + " " + listDistrict.get(districtPosition)
                        + " " + listProvinces.get(districtPosition);
            ShippingDefault data = new ShippingDefault(address, phone,Integer.parseInt(listWardId.get(wardPosition)), listDistrictId.get(districtPosition));
            feesViewModel.setIsInsertShippingDefault(getToken(), data);
        }
    }

    private Boolean check(String phone, String village) {
        Boolean rs = true ;
        String isSelectedProvince = autoProvince.getText().toString().trim();
        String isSelectedDistrict = autoDistrict.getText().toString().trim();
        String isSelectedWard = autoWards.toString().trim();

        if (phone.isEmpty() || village.isEmpty() || isSelectedWard.isEmpty() ||
                isSelectedDistrict.isEmpty() || isSelectedProvince.isEmpty() ) {
            rs = false ;
        } else {
            rs = true;
        }
        return rs;
    }
}