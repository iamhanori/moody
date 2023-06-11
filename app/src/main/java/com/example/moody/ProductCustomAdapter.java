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

public class ProductCustomAdapter extends RecyclerView.Adapter<ProductCustomAdapter.ProductViewHolder> {

    public ProductCustomAdapter(ArrayList<ProductData> productList, Context context) {
        this.productList = productList;
        this.context = context;
    }

    private ArrayList<ProductData> productList;
    private Context context;

    @NonNull
    @Override
    public ProductCustomAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.marketdetail_item, parent, false);
        ProductViewHolder holder = new ProductViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductCustomAdapter.ProductViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(productList.get(position).getProduct())
                .into(holder.iv_product);
        holder.tv_price.setText(productList.get(position).getPrice());
        holder.tv_name.setText(productList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return (productList != null ? productList.size() : 0);
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_product;
        TextView tv_price;
        TextView tv_name;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_product = itemView.findViewById(R.id.iv_product);
            this.tv_price = itemView.findViewById(R.id.tv_price);
            this.tv_name = itemView.findViewById(R.id.tv_name);
        }
    }
}
