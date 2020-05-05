/*package com.jcupzz.ccenotes;

import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.jcupzz.ccenotes.MainActivity;
import com.jcupzz.ccenotes.UploadActivity;

import java.util.HashMap;
import java.util.Map;

public class Rename extends AppCompatActivity {
    FirebaseFirestore db;
    String Renamed_Edit_text_name="Hello";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Map<String, Object> city = new HashMap<>();
        city.put("name",Renamed_Edit_text_name);
        city.put("link", UploadActivity.Subject_Module_Link);
        db = FirebaseFirestore.getInstance();
        db.collection(MainActivity.s4s6s8var).document(Renamed_Edit_text_name).set(city)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });


    }
}
*/