package com.example.a30june_validateuser_performlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity {

    private TextView showUserId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        showUserId = findViewById(R.id.tvEmail);
        String email = getIntent().getStringExtra("email");
        showUserId.setText(email);

    }
}