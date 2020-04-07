package com.jcupzz.ccenotes;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.scwang.wave.MultiWaveHeader;

import java.util.ArrayList;
import java.util.List;

public class StudentDetailsCategory extends MainActivity  {
    public static Button btn_s2,btn_s4,btn_s6,btn_s8;
    public static int i;
    MultiWaveHeader wave_head_stc,wave_foot_stc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details_category);

        wave_head_stc = findViewById(R.id.wave_head_id);
        wave_foot_stc = findViewById(R.id.wave_fot_id);

        btn_s2 = findViewById(R.id.img_id_s2);
        btn_s4 = findViewById(R.id.img_id_s4);
        btn_s6 = findViewById(R.id.img_id_s6);
        btn_s8 = findViewById(R.id.img_id_s8);

        wave_foot_stc.setVelocity(3);
        wave_foot_stc.setProgress(1);
        wave_foot_stc.isRunning();
        wave_foot_stc.setGradientAngle(45);
        wave_foot_stc.setWaveHeight(40);
        wave_foot_stc.setStartColor(getResources().getColor(R.color.wave_start));
        wave_foot_stc.setCloseColor(getResources().getColor(R.color.wave_end));

        wave_head_stc.setVelocity(3);
        wave_head_stc.setProgress(1);
        wave_head_stc.isRunning();
        wave_head_stc.setGradientAngle(45);
        wave_head_stc.setWaveHeight(40);
        wave_head_stc.setStartColor(getResources().getColor(R.color.wave_start));
        wave_head_stc.setCloseColor(getResources().getColor(R.color.wave_end));







        SharedPreferences sharedpreferences = getSharedPreferences("loginSave",
                MODE_PRIVATE);

        SharedPreferences.Editor myEdit = sharedpreferences.edit();
        String priv = sharedpreferences.getString("staff", "");
        if(!((priv.equals("0"))||(priv.equals("1")))) {
            startActivity(new Intent(getApplicationContext(), Register.class));
            finish();
        }




btn_s2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent s2 = new Intent(StudentDetailsCategory.this,STwoSubjects.class);
        startActivity(s2);
        i=2;
    }
});
        btn_s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
i=4;
                Intent s4 = new Intent(StudentDetailsCategory.this,SFourSubjects.class);
                startActivity(s4);
            }
        });
        btn_s6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
    i=6;
                Intent s6 = new Intent(StudentDetailsCategory.this,SSixSubjects.class);
                startActivity(s6);
            }
        });
        btn_s8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        i=8;
                Intent s8 = new Intent(StudentDetailsCategory.this,SEightSubjects.class);
                startActivity(s8);
            }
        });






    }


}

