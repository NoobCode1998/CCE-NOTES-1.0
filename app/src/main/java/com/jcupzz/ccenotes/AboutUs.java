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

    MultiWaveHeader wave_footer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);


       wave_footer = findViewById(R.id.wave_footer);



       wave_footer.setVelocity(3);
        wave_footer.setProgress(1);
        wave_footer.isRunning();
        wave_footer.setGradientAngle(45);
        wave_footer.setWaveHeight(40);
        wave_footer.setStartColor(getResources().getColor(R.color.wave_start));
        wave_footer.setCloseColor(getResources().getColor(R.color.wave_end));



    }
}
