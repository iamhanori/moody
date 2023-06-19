package com.example.moody;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import io.github.muddz.styleabletoast.StyleableToast;

public class Profile extends Fragment {

    private FirebaseAuth mFirebaseAuth;
    private Button updateProfile;
    private TextView logoutText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        mFirebaseAuth = FirebaseAuth.getInstance();

        updateProfile = (Button) view.findViewById(R.id.btn_update_profile);
        updateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ProfileUpdateActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        logoutText = (TextView) view.findViewById(R.id.logout_text);
        logoutText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getContext();
                new AlertDialog.Builder(getActivity()).setTitle("로그아웃").setMessage("로그아웃 하시겠습니까?").setIcon(R.drawable.moody).setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mFirebaseAuth.signOut();
                        new StyleableToast.Builder(context).text("로그아웃 하였습니다").iconStart(R.drawable.moody).length(Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        new StyleableToast.Builder(context).text("로그아웃을 취소하였습니다.").iconStart(R.drawable.moody).length(Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });



        return view;
    }
}