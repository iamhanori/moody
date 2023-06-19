package com.example.moody;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Review extends Fragment {
    private ImageButton btn_search;
    private FloatingActionButton btn_add_review;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_review, container, false);

        btn_search = view.findViewById(R.id.btn_search);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        btn_add_review = view.findViewById(R.id.btn_add_review);
        btn_add_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WriteReviewActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        return view;
    }
}