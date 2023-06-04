package com.example.moody;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    private ArrayList<RankData> rankList;
    private Context context;

    public CustomAdapter(ArrayList<RankData> rankList, Context context) {
        this.rankList = rankList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ranklist_item, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.tv_ranking.setText(rankList.get(position).getRanking());
        Glide.with(holder.itemView)
                .load(rankList.get(position).getMarket())
                .into(holder.iv_market);
        holder.tv_name.setText(rankList.get(position).getName());
        holder.tv_detail.setText(rankList.get(position).getDetail());
    }

    @Override
    public int getItemCount() {
        // 삼항 연산자
        return (rankList != null ? rankList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView tv_ranking;
        ImageView iv_market;
        TextView tv_name;
        TextView tv_detail;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_market = itemView.findViewById(R.id.iv_market);
            this.tv_ranking = itemView.findViewById(R.id.tv_ranking);
            this.tv_name = itemView.findViewById(R.id.tv_name);
            this.tv_detail = itemView.findViewById(R.id.tv_detail);
        }
    }


}
