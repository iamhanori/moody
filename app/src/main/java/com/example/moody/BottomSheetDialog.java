package com.example.moody;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import io.github.muddz.styleabletoast.StyleableToast;

public class BottomSheetDialog extends BottomSheetDialogFragment {
    private View view;
    private BottomSheetListener mListener;
    private Button btn_cart;
    private Button btn_buy;

    private ImageButton btnMinus;
    private ImageButton btnPlus;
    private TextView numTextView;

    private int num = 0;    // 상품 개수

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.bottom_sheet, container, false);

        mListener = (BottomSheetListener) getContext();
        numTextView.setText(num+"");

        btn_cart = view.findViewById(R.id.btn_cart);
        btn_buy = view.findViewById(R.id.btn_buy);

        btn_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onButtonClicked("장바구니 이동");
                dismiss();
            }
        });

        btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onButtonClicked("바로 구매");
                dismiss();
            }
        });

        btnMinus = view.findViewById(R.id.btn_minus);
        btnPlus = view.findViewById(R.id.btn_plus);

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getContext();
                if(num < 0) {
                    new StyleableToast.Builder(context).text("0개 아래의 상품은 구매하실 수 없습니다!").iconStart(R.drawable.moody).length(Toast.LENGTH_SHORT).show();
                }
                else {
                    num--;
                    numTextView.setText(num+"");
                }
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num++;
                numTextView.setText(num+"");
            }
        });

        return view;
    }


    public interface BottomSheetListener {
        void onButtonClicked(String text);
    }
}
