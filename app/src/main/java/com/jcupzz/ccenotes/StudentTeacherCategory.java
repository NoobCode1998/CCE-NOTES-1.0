package com.jcupzz.ccenotes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.StorageReference;

public class StudentTeacherCategory extends MainActivity {
    ImageButton stu_btn, teachers_btn;
    static Button log_btn;
    public static int stc_integer=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_student_teacher_category);


        stu_btn = findViewById(R.id.student_btn);
        log_btn = findViewById(R.id.logout_btn);

        if(FirebaseAuth.getInstance().getCurrentUser() == null)
        log_btn.setVisibility(View.GONE);
//
//        if (StudentTeacherCategory.stc_integer == 2) {
//            log_btn.setVisibility(View.VISIBLE);
//        } else {
//            log_btn.setVisibility(View.GONE);
//        }


        teachers_btn = findViewById(R.id.teacher_category_btn);

        stu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //stc_integer = 1;
                Register.prevChoice = 2;
                Login.prevChoice = 2;
                //in case of user present already

              //  StorageReference storageReference;
                sharedpreferences = getSharedPreferences("loginSave", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedpreferences.edit();
                String priv = sharedpreferences.getString("staff", "");



                if (!(priv.equals("0"))) {
                    FirebaseAuth.getInstance().signOut();
                    if(priv.equals("1"))
                    Toast.makeText(getApplicationContext(), "logging out to switch user", Toast.LENGTH_SHORT).show();
                    myEdit.putString("staff","");
                    myEdit.commit();

                    Intent intent = new Intent(StudentTeacherCategory.this, Register.class);
                    //finish();//new
                    startActivity(intent);
                }
                //StudentTeacherCategory.stc_integer=priv.equals("1")?1:0;


                //end of user choice here


                else if(priv.equals("0")) {

                  //  FirebaseAuth.getInstance().signOut();
                //    stc_integer = 1;
                  //  log_btn.setVisibility(View.GONE);

                Intent intent = new Intent(StudentTeacherCategory.this, StudentDetailsCategory.class);
                startActivity(intent);
            }
                else{

                }

               // stc_integer = 1;
                //Register.prevChoice=2;
            }
        });

        teachers_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Register.prevChoice = 1;
                Login.prevChoice = 1;


               // StorageReference storageReference;
                sharedpreferences = getSharedPreferences("loginSave", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedpreferences.edit();
                String priv = sharedpreferences.getString("staff", "");


                if (!(priv.equals("1"))) {

                    //divverent choice of user  ...logging out

                    sharedpreferences = getSharedPreferences("loginSave",
                            MODE_PRIVATE);
                    myEdit.putString("staff","");
                    if(priv.equals("0"))
                    Toast.makeText(getApplicationContext(), "logging out to switch user", Toast.LENGTH_SHORT).show();
                    FirebaseAuth.getInstance().signOut();
                    myEdit.putString("staff","");
                    myEdit.commit();
                    log_btn.setVisibility(View.GONE);
                   // finish();//new
                    Intent intent = new Intent(StudentTeacherCategory.this, Register.class);
                    startActivity(intent);
                }
                //StudentTeacherCategory.stc_integer=priv.equals("1")?1:0;


                //end of user choice here


                else if(priv.equals("1")){

                    //FirebaseAuth.getInstance().signOut();
                    //stc_integer = 1;
                    //log_btn.setVisibility(View.GONE);

                    Intent intent = new Intent(StudentTeacherCategory.this, StudentDetailsCategory.class);
                    startActivity(intent);
                }
                else{

                }
            }
        });

        log_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                stc_integer = 1;
                StorageReference storageReference;
                sharedpreferences = getSharedPreferences("loginSave",
                        MODE_PRIVATE);

                SharedPreferences.Editor myEdit = sharedpreferences.edit();

                myEdit.putString("staff","");
                Toast.makeText(getApplicationContext(), "logging out you messed up", Toast.LENGTH_SHORT).show();


                myEdit.commit();

                log_btn.setVisibility(View.GONE);
                finish();

            }
        });


    }


}