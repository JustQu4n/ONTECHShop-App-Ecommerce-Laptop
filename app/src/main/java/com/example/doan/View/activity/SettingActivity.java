package com.example.doan.View.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.doan.R;
import com.example.doan.View.fragment.HomeFragment;
import com.example.doan.View.fragment.ProfileFragment;

public class SettingActivity extends AppCompatActivity {
    private EditText etName;
    private EditText etPassword ;
    private Button btn ;
    private ImageView back;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        etName = findViewById(R.id.nameEt_SettingsPage);
        etPassword = findViewById(R.id.EmailEt_SettingsPage);

        btn = findViewById(R.id.saveSetting_SettingsBtn);

        back = findViewById(R.id.back_shipping);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i =new Intent(SettingActivity.this, ProfileFragment.class);
                finish();
                startActivity(i);
            }
        });


    }
}