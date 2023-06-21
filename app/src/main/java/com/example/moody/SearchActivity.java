package com.example.moody;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Array;
import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity implements RankRecyclerViewInterface {

    ImageButton back_img;

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<RankData> rankList;
    FirebaseDatabase database;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // 앱바 없애기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        back_img = findViewById(R.id.btn_back_search);

        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 텍스트 바꾸기
//                idText.setText();
                Intent intent = new Intent(SearchActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        recyclerView = findViewById(R.id.rankView);
        layoutManager = new LinearLayoutManager(SearchActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        rankList = new ArrayList<>();

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("rankList");

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                rankList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    RankData rd = snapshot.getValue(RankData.class);
                    rankList.add(rd);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("SearchActivity", String.valueOf(error.toException()));
            }
        });

        adapter = new RankCustomAdapter(rankList, SearchActivity.this, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(SearchActivity.this, Market.class);
        intent.putExtra("market", rankList.get(position).getMarket());
        intent.putExtra("name", rankList.get(position).getName());
        startActivity(intent);
        finish();
    }
}