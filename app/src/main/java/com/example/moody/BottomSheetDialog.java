package com.example.moody;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetDialog extends BottomSheetDialogFragment {
    private View view;
    private BottomSheetListener mListener;
    private Button btn_cart;
    private Button btn_buy;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.bottom_sheet, container, false);

        mListener = (BottomSheetListener) getContext();

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

        return view;
    }


    public interface BottomSheetListener {
        void onButtonClicked(String text);
    }
}
