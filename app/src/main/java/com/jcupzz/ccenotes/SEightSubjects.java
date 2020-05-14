package com.jcupzz.ccenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.jcupzz.ccenotes.SFourSubjects.j;

public class SEightSubjects extends AppCompatActivity implements View.OnClickListener {

    Button s8_btn_dm;
    Button s8_btn_eia;
    Button s8_btn_es;
    Button s8_btn_pois;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seight_subjects);


        SharedPreferences sharedpreferences = getSharedPreferences("loginSave",
                MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedpreferences.edit();
        String acc = sharedpreferences.getString("staff", "");
        if(!(acc.equals("1")||acc.equals("0")))
        {
            startActivity(new Intent(getApplicationContext(),Register.class));
            finish();
        }


        s8_btn_dm = findViewById(R.id.s8_btn_DM_id);
        s8_btn_eia = findViewById(R.id.s8_btn_EIA_id);
        s8_btn_es = findViewById(R.id.s8_btn_ES_id);
        s8_btn_pois = findViewById(R.id.s8_btn_POIS_id);


        s8_btn_pois.setOnClickListener(this);
        s8_btn_es.setOnClickListener(this);
        s8_btn_dm.setOnClickListener(this);
s8_btn_eia.setOnClickListener(this);





    }




    @Override
    public void onClick(View v) {
        Intent s8_subject_intent = new Intent(SEightSubjects.this, MainActivity.class);
        startActivity(s8_subject_intent);
        //switch case
        switch (v.getId()) {
            case R.id.s8_btn_DM_id:
                j = 1;
                break;
            case R.id.s8_btn_EIA_id:
                j = 2;
                break;
            case R.id.s8_btn_ES_id:
                j = 3;
                break;
            case R.id.s8_btn_POIS_id:
                j = 4;
                break;

        }
    }

}
