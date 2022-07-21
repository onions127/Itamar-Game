package com.example.itamargame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.slider.Slider;

public class Settings extends AppCompatActivity implements Slider.OnSliderTouchListener, Slider.OnChangeListener {

    ImageView iv_speaker;
    Slider sound_slider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        iv_speaker = findViewById(R.id.iv_speaker);
        sound_slider = findViewById(R.id.sound_slider);

        sound_slider.addOnSliderTouchListener(this);
        sound_slider.addOnChangeListener(this);

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
}