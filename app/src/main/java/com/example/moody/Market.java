package com.example.moody;

import static androidx.fragment.app.FragmentManager.TAG;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Market extends AppCompatActivity {

    ImageView market_img;
    TextView market_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        // 앱바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        String market = getIntent().getStringExtra("market");
        String name = getIntent().getStringExtra("name");

        market_img = findViewById(R.id.mid_market);
        market_name = findViewById(R.id.mtv_name);

      //  market_img.setText(market);
        market_name.setText(name);

    }
}