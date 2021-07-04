package com.example.a30june_validateuser_performlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginPage extends AppCompatActivity {

    private Button mbtnlogin;
    private EditText metEmail;
    private EditText metPassword;
    private final String emailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        initViews();

        mbtnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean emailValid = isEmailValid();
                boolean passwordValid = isPasswordValid();
                if(emailValid && passwordValid){
                    Intent intent = new Intent(LoginPage.this,HomeScreen.class);
                    intent.putExtra("email",metEmail.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }

    private void initViews(){
        mbtnlogin = findViewById(R.id.btnLogin);
        metEmail = findViewById(R.id.etEmail);
        metPassword = findViewById(R.id.etPassword);

    }

    private boolean isEmailValid() {
        if (metEmail.getText().toString().matches(emailValidation)) {
            return true;
        } else {
            metEmail.setError("Email is invalid!");
            return false;
        }
    }

    private boolean isPasswordValid() {
        if (metPassword.getText().length() >= 6) {
            return true;
        } else {
            metPassword.setError("Invalid Password!");
            return false;
        }
    }


}