package com.example.moody;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProductActivity extends AppCompatActivity implements BottomSheetDialog.BottomSheetListener {

    // bottom dialog 띄우기 버튼 (제품 상세 페이지에서 구매 버튼)
    private Button btn_buy_product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        btn_buy_product = findViewById(R.id.btn_buy_product);
        btn_buy_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog();
                bottomSheetDialog.show(getSupportFragmentManager(), "BottomSheet");
            }
        });
    }

    @Override
    public void onButtonClicked(String text) {
        String a = "haha";
    }
}