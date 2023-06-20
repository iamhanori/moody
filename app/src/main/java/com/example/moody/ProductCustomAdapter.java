package com.example.moody;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ProductCustomAdapter extends RecyclerView.Adapter<ProductCustomAdapter.ProductCustomViewHolder> {
    private ProductRecyclerViewInterface itemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int pos);
    }

    private OnItemClickListener onItemClickListener = null;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public interface OnLongItemClickListener {
        void onLongItemClick(int pos);
    }

    private ArrayList<ProductData> productList;
    private Context context;

    public ProductCustomAdapter(ArrayList<ProductData> productList, Context context, ProductRecyclerViewInterface itemClickListener) {
        this.productList = productList;
        this.context = context;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    public ProductCustomAdapter.ProductCustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.marketdetail_item, parent, false);
        ProductCustomViewHolder holder = new ProductCustomViewHolder(view, itemClickListener);

        return holder;
    }

    public void onBindViewHolder(@NonNull ProductCustomViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(productList.get(position).getProduct())
                .into(holder.iv_product);
        holder.tv_price.setText(productList.get(position).getPrice());
        holder.tv_name.setText(productList.get(position).getName());
    }

    public int getItemCount() {
        return (productList != null ? productList.size() : 0);
    }

    public class ProductCustomViewHolder extends RecyclerView.ViewHolder {
        ImageButton iv_product;
        TextView tv_price;
        TextView tv_name;

        public ProductCustomViewHolder(@NonNull View itemView, ProductRecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            this.iv_product = itemView.findViewById(R.id.iv_product);
            this.tv_price = itemView.findViewById(R.id.tv_price);
            this.tv_name = itemView.findViewById(R.id.tv_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterface != null) {
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}