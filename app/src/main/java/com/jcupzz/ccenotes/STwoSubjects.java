package com.jcupzz.ccenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import static com.jcupzz.ccenotes.SFourSubjects.j;
import android.widget.TextView;
import android.widget.Toast;

public class STwoSubjects extends AppCompatActivity implements View.OnClickListener{
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
        //logout
        SharedPreferences sharedpreferences = getSharedPreferences("loginSave",
                MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedpreferences.edit();
        String acc = sharedpreferences.getString("staff", "");;
        if(!(acc.equals("1")||acc.equals("0")))
        {
            startActivity(new Intent(getApplicationContext(),Register.class));
            finish();
        }


        //logout



    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(STwoSubjects.this,MainActivity.class);
        startActivity(intent);
        switch (v.getId()) {
            case R.id.s2_btn_physics:
                j=1;
                break;
            case R.id.s2_btn_chemistry:
                j=2;
                break;
            case R.id.s2_btn_graphics:
                j=3;
                break;
            case R.id.s2_btn_basics_of_mechanics:
                j=4;
                break;
            case R.id.s2_btn_basics_of_mechanical:
                j=5;
                break;
            case R.id.s2_btn_basics_of_civil:
                j=6;
                break;
            case R.id.s2_btn_cs:
                j=7;
                break;
            case R.id.s2_btn_mathematics:
                j=8;
                break;
            case R.id.s2_btn_basics_of_electrical:
                j=9;
                break;
            case R.id.s2_btn_basics_of_electronics:
                j=10;
                break;

        }

    }

}

