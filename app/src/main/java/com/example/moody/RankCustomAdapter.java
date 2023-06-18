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

public class RankCustomAdapter extends RecyclerView.Adapter<RankCustomAdapter.RankCustomViewHolder> {
    private ArrayList<RankData> rankList;
    private Context context;

    public RankCustomAdapter(ArrayList<RankData> rankList, Context context) {
        this.rankList = rankList;
        this.context = context;
    }

    @NonNull
    @Override
    public RankCustomAdapter.RankCustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ranklist_item, parent, false);
        RankCustomViewHolder holder = new RankCustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RankCustomViewHolder holder, int position) {
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

    public class RankCustomViewHolder extends RecyclerView.ViewHolder {
        TextView tv_ranking;
        ImageView iv_market;
        TextView tv_name;
        TextView tv_detail;
        public RankCustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_market = itemView.findViewById(R.id.iv_market);
            this.tv_ranking = itemView.findViewById(R.id.tv_ranking);
            this.tv_name = itemView.findViewById(R.id.tv_name);
            this.tv_detail = itemView.findViewById(R.id.tv_detail);
        }
    }
}
