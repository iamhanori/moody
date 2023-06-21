package com.example.moody;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import io.github.muddz.styleabletoast.StyleableToast;

public class ProductActivity extends AppCompatActivity implements BottomSheetDialog.BottomSheetListener {

    // bottom dialog 띄우기 버튼 (제품 상세 페이지에서 구매 버튼)
    private Button btn_buy_product;
    private ImageButton btnCart;
    private ImageButton btnBack;
    private ImageButton btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        // 앱바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        btn_buy_product = findViewById(R.id.btn_buy_product);
        btn_buy_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog();
                bottomSheetDialog.show(getSupportFragmentManager(), "BottomSheet");
            }
        });

        btnCart = findViewById(R.id.btn_cart);
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = ProductActivity.this;
                new StyleableToast.Builder(context).text("현재 오픈 준비 중인 서비스입니다.").iconStart(R.drawable.moody).length(Toast.LENGTH_SHORT).show();
            }
        });

        btnBack = findViewById(R.id.btn_product_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnSearch = findViewById(R.id.btn_search);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductActivity.this, SearchActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onButtonClicked(String text) {
        String a = "haha";
    }
}