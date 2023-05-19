package com.example.doan.View.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doan.LoadingDialog;
import com.example.doan.Model.User;
import com.example.doan.R;
import com.example.doan.ViewModel.SignUpViewModel;

public class SignUpActivity extends AppCompatActivity {

    private EditText edtEmail ;
    private EditText edtName ;
    private EditText edtPassword ;
    private EditText edtConfirmPassword ;
    private Button btnSignUp ;
    private TextView textSignIn ;
    private String emailPattern ;

    private SignUpViewModel signUpViewModel;
    private  ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edtEmail = findViewById(R.id.emailEt_signUpPage);
        edtName = findViewById(R.id.nameEt_signUpPage);
        edtPassword = findViewById(R.id.PassEt_signUpPage);
        edtConfirmPassword = findViewById(R.id.cPassEt_signUpPage);
        btnSignUp = findViewById(R.id.signUpBtn_signUpPage);

        textSignIn = findViewById(R.id.signInTv_signUpPage);

        emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        signUpViewModel = new ViewModelProvider(this).get(SignUpViewModel.class);

        progressDialog = new ProgressDialog(SignUpActivity.this);


        textAutoCheck();

        textSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInput();
            }
        });

        signUpViewModel.getIsSignUp().observeForever(new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean) {
                    Intent i = new Intent(SignUpActivity.this, HomeActivity.class);
                    startActivity(i);
                } else {
                    progressDialog.dismiss();
                    Toast.makeText(SignUpActivity.this, "Email is exit ", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void checkInput() {
        if (edtName.getText().toString().isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Name can't null", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!edtEmail.getText().toString().matches(emailPattern)) {
            Toast.makeText(SignUpActivity.this, "Enter valid email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (edtPassword.getText().toString().isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Password can't empty!", Toast.LENGTH_SHORT).show();

            return;
        } else {
            if(!edtPassword.getText().toString().matches("[a-zA-Z0-9]{6,30}")) {
                Toast.makeText(SignUpActivity.this, "Password is not space!", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        if (!edtConfirmPassword.getText().toString().equals(edtConfirmPassword.getText().toString())) {
            Toast.makeText(SignUpActivity.this, "Password not Match!", Toast.LENGTH_SHORT).show();

            return;
        }

        signIn();
    }
    private void signIn() {

        progressDialog.setMessage("Creating Account ...");
        progressDialog.show();

        String name = edtName.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        String password= edtPassword.getText().toString().trim();
        String repate_password = edtConfirmPassword.getText().toString().trim();

        User user = new User(name, email, password, repate_password);
        try {
            signUpViewModel.register(user);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    private void textAutoCheck() {
        edtName.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                if (edtName.getText().toString().isEmpty()) {
                    edtName.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                } else if (edtName.getText().toString().length() >= 4) {
                    edtName.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(getApplicationContext(),
                            R.drawable.ic_check
                    ), null);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                edtName.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count >= 4) {
                    edtName.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(getApplicationContext(),
                            R.drawable.ic_check
                    ), null);
                }
            }
        });

        edtEmail.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                if (edtEmail.getText().toString().isEmpty()) {
                    edtEmail.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                } else if (edtEmail.getText().toString().matches(emailPattern)) {
                    edtEmail.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(getApplicationContext(),
                            R.drawable.ic_check
                    ), null);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                edtEmail.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (edtEmail.getText().toString().matches(emailPattern)) {
                    edtEmail.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(getApplicationContext(),
                            R.drawable.ic_check
                    ), null);
                }
            }
        });

        edtPassword.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                if (edtPassword.getText().toString().isEmpty()) {
                    edtPassword.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                } else if (edtPassword.getText().toString().length() > 5) {
                    edtPassword.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(getApplicationContext(),
                            R.drawable.ic_check
                    ), null);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                edtPassword.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count > 5) {
                    edtPassword.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(getApplicationContext(),
                            R.drawable.ic_check
                    ), null);
                }
            }
        });

        edtConfirmPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                if (edtConfirmPassword.getText().toString().isEmpty()){
                    edtConfirmPassword.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);

                } else if (edtConfirmPassword.getText().toString().equals(edtPassword.getText().toString())){
                    edtConfirmPassword.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(getApplicationContext(),
                            R.drawable.ic_check
                    ), null);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                edtConfirmPassword.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if (edtConfirmPassword.getText().toString().equals(edtPassword.getText().toString())){
                    edtConfirmPassword.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(getApplicationContext(),
                            R.drawable.ic_check
                    ), null);
                }
            }
        });
    }

}



