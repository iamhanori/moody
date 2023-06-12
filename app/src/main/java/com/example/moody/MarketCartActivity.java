package com.example.moody;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MarketCartActivity extends AppCompatActivity {

    private ImageButton cart_backward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_cart);

        // 앱바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        cart_backward = findViewById(R.id.cart_backward);
        cart_backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}