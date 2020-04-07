package com.jcupzz.ccenotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import com.google.firebase.storage.StorageReference;

import static com.jcupzz.ccenotes.MyViewHolder.he;
import static com.jcupzz.ccenotes.MyViewHolder.l;
import static com.jcupzz.ccenotes.SFourSubjects.j;
import static com.jcupzz.ccenotes.StudentDetailsCategory.i;


import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FirebaseFirestore db;
    RecyclerView mRecyclerView;
    ArrayList<DownModel> downModelArrayList = new ArrayList<>();
    MyAdapter myAdapter;
    StorageReference storageReference;
    public static String s4s6s8var;
    public static String path;

    Button upload_btn;
    String dif;
    SharedPreferences sharedpreferences;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(isNetworkConnected()==false)
        {
            Toast.makeText(getApplicationContext(),"You need internet to function",Toast.LENGTH_LONG).show();
        }


        upload_btn = findViewById(R.id.upload_btn_id);


        //sharedpreferences=getSharedPreferences();
        //StudentTeacherCategory.stc_integer=0;

        sharedpreferences=getSharedPreferences("loginSave",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedpreferences.edit();
        String priv=sharedpreferences.getString("staff","");
        StudentTeacherCategory.stc_integer=priv.equals("1")?1:0;

        if(StudentTeacherCategory.stc_integer==0)
        {
            upload_btn.setVisibility(View.GONE);
        }
        else if(StudentTeacherCategory.stc_integer==1)
        {
            upload_btn.setVisibility(View.VISIBLE);
        }
        else{
            //do nothing
        }

        upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,UploadActivity.class);
                startActivity(intent);
            }
        });

        //s4
        if(i==4&&j==1){
            s4s6s8var = "S4_CSE_MATHS";
        }
        if(i==4&&j==2){
            s4s6s8var = "S4_CSE_OS";
        }
        if(i==4&&j==3){
            s4s6s8var = "S4_CSE_DSL";
        }
        if(i==4&&j==4){
            s4s6s8var = "S4_CSE_PDD";
        }
        if(i==4&&j==5){
            s4s6s8var = "S4_CSE_COAA";
        }
        if(i==4&&j==6){
            s4s6s8var = "S4_CSE_OPDAP";
        }
        if(i==4&&j==7){
            s4s6s8var = "S4_CSE_FAOSSL";
        }


        //s6
        if(i==6&&j==1){
            s4s6s8var = "S6_CSE_CD";
        }
        if(i==6&&j==2){
            s4s6s8var = "S6_CSE_CN";
        }
        if(i==6&&j==3){
            s4s6s8var = "S6_CSE_WT";
        }
        if(i==6&&j==4){
            s4s6s8var = "S6_CSE_POM";
        }
        if(i==6&&j==5){
            s4s6s8var = "S6_CSE_DAAOA";
        }
        if(i==6&&j==6){
            s4s6s8var = "S6_CSE_SEAPM";
        }


        //s8
        if(i==8&&j==1){
            s4s6s8var = "S8_CSE_DM";
        }
        if(i==8&&j==2){
            s4s6s8var = "S8_CSE_FST";
        }
        if(i==8&&j==3){
            s4s6s8var = "S8_CSE_CC";
        }
        if(i==8&&j==4){
            s4s6s8var = "S8_CSE_ES";
        }
        if(i==8&&j==5){
            s4s6s8var = "S8_CSE_AI";
        }
        if(i==8&&j==6){
            s4s6s8var = "S8_CSE_POIS";
        }






        setUpFB();
        setUpRV();
        if(i==2) {
            dataFromFirebase();
        }
        else if(i==4||i==6||i==8)
            {
            dataFromFirebases6s4s8();
        }



    }

    public void opens() {

    }


    private void dataFromFirebase() {
        if(downModelArrayList.size()>0)
            downModelArrayList.clear();

        //db=FirebaseFirestore.getInstance();


db.collection(STwoSubjects.var)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for(DocumentSnapshot documentSnapshot: task.getResult()) {

                            DownModel downModel= new DownModel(documentSnapshot.getString("name"),
                                    documentSnapshot.getString("link"));
                            downModelArrayList.add(downModel);

                        }

                        myAdapter= new MyAdapter(MainActivity.this,downModelArrayList);
                        mRecyclerView.setAdapter(myAdapter);
                    }
                })

                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Error ;-.-;", Toast.LENGTH_SHORT).show();
                    }
                });



    }


    private void setUpFB(){
        db=FirebaseFirestore.getInstance();
    }

    private void setUpRV(){
        mRecyclerView= findViewById(R.id.recycle);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void dataFromFirebases6s4s8() {
      if(downModelArrayList.size()>0)
            downModelArrayList.clear();

        //db=FirebaseFirestore.getInstance();


        db.collection(s4s6s8var)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        for(DocumentSnapshot documentSnapshot: task.getResult()) {

                            DownModel downModel= new DownModel(documentSnapshot.getString("name"),
                                    documentSnapshot.getString("link"));
                            downModelArrayList.add(downModel);

                        }
                        myAdapter= new MyAdapter(MainActivity.this,downModelArrayList);
                        mRecyclerView.setAdapter(myAdapter);
                    }
                })

                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Error ;-.-;", Toast.LENGTH_SHORT).show();
                    }
                })
        ;


    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case 121:

               deletefirebasefirestore();
                return true;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.aboutus_id) {

            Intent myIntent = new Intent(MainActivity.this,  AboutUs.class);

            MainActivity.this.startActivity(myIntent);


            return true;
        }

        if(id==R.id.open_downloads_id){
            Intent i = new Intent();
            i.setAction(DownloadManager.ACTION_VIEW_DOWNLOADS);
            startActivity(i);
        }

        if (id == R.id.signOut_id) {
            //warning



            //warning






            FirebaseAuth.getInstance().signOut();
            sharedpreferences = getSharedPreferences("loginSave",
                    MODE_PRIVATE);

            SharedPreferences.Editor myEdit = sharedpreferences.edit();

            myEdit.putString("name", "");
            myEdit.putString("pass", "");
            myEdit.putString("staff", "");
            myEdit.commit();
            finish();

            Intent myIntent = new Intent(MainActivity.this,  Register.class);

            MainActivity.this.startActivity(myIntent);


            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void deletefirebasefirestore() {
        if(i==2) {
            dif=STwoSubjects.var;
        }
        else if(i==4||i==6||i==8)
        {
            dif=s4s6s8var;
        }


        db.collection(dif).document(MyViewHolder.ve)
                .delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this,"Successfully deleted "+MyViewHolder.ve,Toast.LENGTH_SHORT).show();
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //Log.w(TAG, "Error deleting document", e);
                    }
                });



    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }


}
