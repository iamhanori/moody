package com.example.moody;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Store extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManger;
    private ArrayList<RankData> rankList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_store, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.rankView);
        // recyclerView.setHasFixedSize(true);
        layoutManger = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManger);
        rankList = new ArrayList<>();;

        //FirebaseData
        database = FirebaseDatabase.getInstance();

        databaseReference = database.getReference("rankList");

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // firedatabase의 데이터를 받아오는 곳
                rankList.clear(); // 초기화
                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    RankData rd = snapshot.getValue(RankData.class); // 만들어뒀던 RankData에 객체담기
                    rankList.add(rd);
                }
                adapter.notifyDataSetChanged(); // 리스트 저장 및 새로고침
            }

            // error
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Store", String.valueOf(error.toException()));
            }
        });

        adapter = new RankCustomAdapter(rankList, getActivity());
        recyclerView.setAdapter(adapter); // 리사이클러뷰에 어댑터 연결

       return view;
    }

}