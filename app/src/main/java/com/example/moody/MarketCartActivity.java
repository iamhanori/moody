package com.example.moody;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import io.github.muddz.styleabletoast.StyleableToast;

public class MarketCartActivity extends AppCompatActivity {

    private ImageButton cart_backward;
    private Button cartBuyButton;

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
                Intent intent = new Intent(MarketCartActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        cartBuyButton = findViewById(R.id.buy_button);
        cartBuyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = MarketCartActivity.this;
                new StyleableToast.Builder(context).text("구매 완료! 곧 자택으로 배송됩니다!").iconStart(R.drawable.moody).length(Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MarketCartActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}