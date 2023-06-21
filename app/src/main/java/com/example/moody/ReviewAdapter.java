//package com.example.moody;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.constraintlayout.widget.ConstraintLayout;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
//import com.firebase.ui.firestore.FirestoreRecyclerOptions;
//
//public class ReviewAdapter extends FirestoreRecyclerAdapter<ReviewData, ReviewAdapter, ReviewAdapter.ReviewHolder> {
//    Context context;
//
//    public ReviewAdapter(@NonNull FirestoreRecyclerOptions<ReviewData> options, Context context) {
//        super(options);
//        this.context = context;
//    }
//
//    @Override
//    protected void onBindViewHolder(@NonNull ReviewHolder holder, int position, @NonNull ReviewData rv) {
//        holder.titleTextView.setText(rv.title);
//        holder.contentTextView.setText(rv.content);
//        holder.timeTextView.setText(Review.timestampToString(rv.timestamp));
//    }
//
//    @NonNull
//    @Override
//    public ReviewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reviewlist_item, parent, false);
//        return new ReviewHolder(view);
//    }
//
//    class ReviewHolder extends RecyclerView.ViewHolder {
//        TextView titleTextView, contentTextView, timeTextView;
//
//        public ReviewHolder(@NonNull View itemView) {
//            super(itemView);
//            titleTextView = itemView.findViewById(R.id.tv_rvTitle);
//            contentTextView = itemView.findViewById(R.id.tv_rvContent);
//            timeTextView = itemView.findViewById(R.id.tv_rvTime);
//        }
//    }
//
//}
