package com.example.itamargame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.slider.Slider;

public class Settings extends AppCompatActivity implements Slider.OnSliderTouchListener, Slider.OnChangeListener, View.OnClickListener {

    ImageView iv_speaker;
    Slider sound_slider;
    Button btn_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        iv_speaker = findViewById(R.id.iv_speaker);
        sound_slider = findViewById(R.id.sound_slider);
        btn_home = findViewById(R.id.btn_home);

        sound_slider.addOnSliderTouchListener(this);
        sound_slider.addOnChangeListener(this);
        btn_home.setOnClickListener(this);

    }

    @Override
    public void onStartTrackingTouch(@NonNull Slider slider) {
    }

    @Override
    public void onStopTrackingTouch(@NonNull Slider slider) {

    }

    @Override
    public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
        CommonMethod.player.setVolume((int) slider.getValue(),(int) slider.getValue());

        if(slider.getValue() == 0)
        {
            iv_speaker.setImageResource(R.drawable.mute);
        }
        else if(slider.getValue() != 0)
        {
            iv_speaker.setImageResource(R.drawable.speaker);
        }

    }

    @Override
    public void onClick(View v) {
        Intent home = new Intent(Settings.this, MainActivity.class);
        startActivity(home);
    }
}