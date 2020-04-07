package com.jcupzz.ccenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class STwoSubjects extends AppCompatActivity implements View.OnClickListener{
public static String var;
     Button s2_btn_physics;
     Button s2_btn_chemistry;
     Button s2_btn_graphics;
     Button s2_btn_basics_of_mechanics;
     Button s2_btn_basics_of_electrical;
     Button s2_btn_basics_of_electronics;
     Button s2_btn_mathematics;
     Button s2_btn_cs;
     Button s2_btn_basics_of_mechanical;
     Button s2_btn_basics_of_civil;
     public static int s2_u_n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stwo_subjects);



        //start variables
         s2_btn_physics = findViewById(R.id.s2_btn_physics);
        s2_btn_chemistry = findViewById(R.id.s2_btn_chemistry);
        s2_btn_graphics = findViewById(R.id.s2_btn_graphics);
        s2_btn_basics_of_mechanics = findViewById(R.id.s2_btn_basics_of_mechanics);
        s2_btn_basics_of_electrical = findViewById(R.id.s2_btn_basics_of_electrical);
        s2_btn_basics_of_electronics = findViewById(R.id.s2_btn_basics_of_electronics);
        s2_btn_mathematics = findViewById(R.id.s2_btn_mathematics);
        s2_btn_cs = findViewById(R.id.s2_btn_cs);
        s2_btn_basics_of_mechanical = findViewById(R.id.s2_btn_basics_of_mechanical);
        s2_btn_basics_of_civil = findViewById(R.id.s2_btn_basics_of_civil);
        //end variables
        //OnClickListenerFunction Starts:-
        s2_btn_cs.setOnClickListener(this);
        s2_btn_basics_of_civil.setOnClickListener(this);
        s2_btn_basics_of_mechanical.setOnClickListener(this);
        s2_btn_basics_of_mechanics.setOnClickListener(this);
        s2_btn_basics_of_electronics.setOnClickListener(this);
        s2_btn_basics_of_electrical.setOnClickListener(this);
        s2_btn_physics.setOnClickListener(this);
        s2_btn_chemistry.setOnClickListener(this);
        s2_btn_mathematics.setOnClickListener(this);
        s2_btn_graphics.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(STwoSubjects.this,MainActivity.class);
        startActivity(intent);
        switch (v.getId()) {
            case R.id.s2_btn_physics:
                var = "Physics";
                break;
            case R.id.s2_btn_chemistry:
                var = "Chemistry";
                break;
            case R.id.s2_btn_graphics:
                var = "Graphics";
                break;
            case R.id.s2_btn_basics_of_mechanics:
                var = "Mechanics";
                break;
            case R.id.s2_btn_basics_of_mechanical:
                var = "Mechanical";
                break;
            case R.id.s2_btn_basics_of_civil:
                var = "Civil";
                break;
            case R.id.s2_btn_cs:
                var = "Cs";
                break;
            case R.id.s2_btn_mathematics:
                var = "Mathematics";
                break;
            case R.id.s2_btn_basics_of_electrical:
                var = "Electrical";
                break;
            case R.id.s2_btn_basics_of_electronics:
                var = "Electronics";
                break;

        }

        }

    }

