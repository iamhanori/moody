package com.example.moody;

import android.content.Context;
import android.widget.Toast;

import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;

public class Utility {

    // 다른 액티비티 만들어서 옮기기
    static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
    static CollectionReference getCollectionReferenceForNotes() {
        FirebaseUser cUser = FirebaseAuth.getInstance().getCurrentUser();
        return FirebaseFirestore.getInstance().collection("reviews")
                .document(cUser.getUid()).collection("myreviews");
    }

    static String timestampToString(Timestamp timestamp) {
        return new SimpleDateFormat("yyyy/MM/dd").format(timestamp.toDate());
    }
}
