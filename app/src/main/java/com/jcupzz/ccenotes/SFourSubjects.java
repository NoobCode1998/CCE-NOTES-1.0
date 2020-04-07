package com.jcupzz.ccenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.jcupzz.ccenotes.StudentDetailsCategory.i;

public class SFourSubjects extends AppCompatActivity implements View.OnClickListener {

Button s4_btn_maths;
    Button s4_btn_os;
    Button s4_btn_dsl;
    Button s4_btn_pdd;
    Button s4_btn_coaa;
    Button s4_btn_opdap;
    Button s4_btn_fasossl;
//String [] cse = {"Mathematics","Computer Organization and Architecture","Operating Systems","Object Oriented Design and Programming"
  //      ,"Principles of Database Design","Free and Open Source Software Lab","Digital Systems Lab"};
public static int j=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sfour_subjects);

s4_btn_maths = findViewById(R.id.s4_btn_maths_id);
s4_btn_os            = findViewById(R.id.s4_btn_OS_id);
         s4_btn_dsl   = findViewById(R.id.s4_btn_DSL_id);
            s4_btn_pdd= findViewById(R.id.s4_btn_PDD_id);
           s4_btn_coaa = findViewById(R.id.s4_btn_COAA_id);
         s4_btn_opdap   = findViewById(R.id.s4_btn_OPDAP_id);
         s4_btn_fasossl   = findViewById(R.id.s4_btn_FAOSSL_id);



         s4_btn_fasossl.setOnClickListener(this);
s4_btn_opdap.setOnClickListener(this);
s4_btn_coaa.setOnClickListener(this);
s4_btn_pdd.setOnClickListener(this);
s4_btn_dsl.setOnClickListener(this);
s4_btn_os.setOnClickListener(this);
s4_btn_maths.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent s4_subject_intent = new Intent(SFourSubjects.this, MainActivity.class);
        startActivity(s4_subject_intent);
        //switch case
        switch (v.getId())
        {
            case R.id.s4_btn_maths_id:
                j=1;
                break;
            case R.id.s4_btn_OS_id:
                j=2;
                break;
            case R.id.s4_btn_DSL_id:
                j=3;
                break;
            case R.id.s4_btn_PDD_id:
                j=4;
                break;
            case R.id.s4_btn_COAA_id:
                j=5;
                break;
            case R.id.s4_btn_OPDAP_id:
                j=6;
                break;
            case R.id.s4_btn_FAOSSL_id:
                j=7;
                break;

        }
    }
}
