package com.jcupzz.ccenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import static com.jcupzz.ccenotes.StudentDetailsCategory.i;
import static com.jcupzz.ccenotes.SFourSubjects.j;

public class SSixSubjects extends AppCompatActivity implements View.OnClickListener {
    Button s6_btn_cd;
    Button s6_btn_cn;
    Button s6_btn_wt;
    Button s6_btn_pom;
    Button s6_btn_daaoa;
    Button s6_btn_seapm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssix_subjects);

        s6_btn_cd = findViewById(R.id.s6_btn_CD_id);
        s6_btn_cn = findViewById(R.id.s6_btn_CN_id);
        s6_btn_wt = findViewById(R.id.s6_btn_WT_id);
        s6_btn_pom = findViewById(R.id.s6_btn_POM_id);
        s6_btn_daaoa = findViewById(R.id.s6_btn_DAAOA_id);
        s6_btn_seapm = findViewById(R.id.s6_btn_SEAPM_id);


        s6_btn_wt.setOnClickListener(this);
        s6_btn_seapm.setOnClickListener(this);
        s6_btn_pom.setOnClickListener(this);
        s6_btn_daaoa.setOnClickListener(this);
        s6_btn_cn.setOnClickListener(this);
        s6_btn_cd.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent s6_subject_intent = new Intent(SSixSubjects.this, MainActivity.class);
        startActivity(s6_subject_intent);
        //switch case
        switch (v.getId()) {
            case R.id.s6_btn_CD_id:
                j = 1;
                break;
            case R.id.s6_btn_CN_id:
                j = 2;
                break;
            case R.id.s6_btn_WT_id:
                j = 3;
                break;
            case R.id.s6_btn_POM_id:
                j = 4;
                break;
            case R.id.s6_btn_DAAOA_id:
                j = 5;
                break;
            case R.id.s6_btn_SEAPM_id:
                j = 6;
                break;


        }
    }
}






