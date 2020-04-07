package com.jcupzz.ccenotes;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.TextView;

import com.google.common.collect.Multimap;
import com.scwang.wave.MultiWaveHeader;

public class AboutUs extends AppCompatActivity {
    ConstraintLayout constraintLayout;
    MultiWaveHeader wave_header,wave_footer;
    ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

      //  actionBar = getSupportActionBar();
     //   actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_gradient));



       wave_footer = findViewById(R.id.wave_footer);
       // wave_header = findViewById(R.id.wave_header);

       /*constraintLayout = findViewById(R.id.aboutus_cl_id);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();*/

       /* wave_header.setVelocity(3);
        wave_header.setProgress(1);
        wave_header.isRunning();
        wave_header.setGradientAngle(45);
        wave_header.setWaveHeight(30);
        wave_header.setStartColor(getResources().getColor(R.color.wave_end));
        wave_header.setCloseColor(getResources().getColor(R.color.wave_start));*/


       wave_footer.setVelocity(3);
        wave_footer.setProgress(1);
        wave_footer.isRunning();
        wave_footer.setGradientAngle(45);
        wave_footer.setWaveHeight(40);
        wave_footer.setStartColor(getResources().getColor(R.color.wave_start));
        wave_footer.setCloseColor(getResources().getColor(R.color.wave_end));



    }
}
