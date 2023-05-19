package com.example.doan.View.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doan.LoadingDialog;
import com.example.doan.R;
import com.example.doan.Utils.SaveToken;
import com.example.doan.ViewModel.LoginViewModel;

import java.util.logging.Logger;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    private EditText edtEmail ;
    private EditText edtPassword ;
    private Button btnLogin ;
    private TextView signUp ;

    private  TextView emailError ;
    private  TextView passwordError ;
    private LoadingDialog loadingDialog;
    private LoginViewModel loginViewModel ;
    private CheckBox cbSaveLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SaveToken.init(this);

        edtEmail = findViewById(R.id.emailEt);
        edtPassword = findViewById(R.id.PassEt);
        btnLogin = findViewById(R.id.loginBtn);
        signUp = findViewById(R.id.signUpTv);
        emailError = findViewById(R.id.emailError);
        passwordError = findViewById(R.id.passwordError);

        cbSaveLogin = findViewById(R.id.checkBox);

        loginViewModel =new ViewModelProvider(this).get(LoginViewModel.class);
        loadingDialog = new LoadingDialog(this);

        textAutoCheck();

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    checkInput();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        loginViewModel.getToken().observeForever(new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if(s.isEmpty()) {
                    emailError.setVisibility(View.VISIBLE);
                    emailError.setText("Email or password is invalid");
                } else {
                    Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                    if(cbSaveLogin.isChecked()) {
                        i.putExtra("email", edtEmail.getText().toString().trim());
                        i.putExtra("password", edtPassword.getText().toString().trim());
                        i.putExtra("isSave", true);
                        i.putExtra("token", s);
                    }
                    startActivity(i);
                }

            }
        });
    }

    private Integer checkInput() throws InterruptedException {
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        if(email== null ) {
            emailError.setVisibility(View.VISIBLE);
            emailError.setText("Email can't be null");
            return 0 ;
        } else {
            Boolean isEmail = checkEmail(email, "^(.+)@(\\S+)$");
            if(!isEmail) {
                emailError.setVisibility(View.VISIBLE);
                emailError.setText("Email incorrect");
                return 0 ;
            }
        }
        if(password == null) {
            edtPassword.setVisibility(View.VISIBLE);
            edtPassword.setText("Password can't be null");
            return 0 ;
        }

        if(email != null && password !=null) {
            login(email, password);
        }
        return 1 ;
    }

    private Boolean checkEmail(String email, String s) {
        return Pattern.compile(s)
                .matcher(email)
                .matches();
    }

    private void login(String email, String password) throws InterruptedException {
        loginViewModel.login(email,password);
    }

    private void textAutoCheck() {
        edtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                edtEmail.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (Patterns.EMAIL_ADDRESS.matcher(edtEmail.getText().toString()).matches()) {
                    edtEmail.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(getApplicationContext(),
                            R.drawable.ic_check), null);
                    emailError.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (edtEmail.getText().toString().isEmpty()) {
                    edtEmail.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                } else if (Patterns.EMAIL_ADDRESS.matcher(edtEmail.getText().toString()).matches()) {
                    edtEmail.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(getApplicationContext(),
                            R.drawable.ic_check), null);
                    emailError.setVisibility(View.GONE);
                }
            }
        });

        edtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                if (edtPassword.getText().toString().isEmpty()) {
                    edtPassword.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                } else if (edtPassword.getText().toString().length() > 4) {
                    edtPassword.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(getApplicationContext(),
                            R.drawable.ic_check), null);
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                edtPassword.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                passwordError.setVisibility(View.GONE);
                if (count > 6) {
                    edtPassword.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(getApplicationContext(),
                            R.drawable.ic_check), null);
                }
            }
        });

    }

}