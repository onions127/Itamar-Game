package com.example.itamargame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Level_one extends AppCompatActivity implements View.OnClickListener {

    EditText txt_guess;
    TextView tv_points;
    String ans = "מפגש";
    ImageView iv_lvlone;
    Button btn_sub;
    Button btn_home;
    int tries = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one);

        txt_guess = findViewById(R.id.txt_guess);
        btn_sub = findViewById(R.id.btn_sub);
        iv_lvlone = findViewById(R.id.iv_lvltwo);
        tv_points = findViewById(R.id.tv_points);
        btn_home = findViewById(R.id.ib_home);
        btn_sub.setOnClickListener(this);
        btn_home.setOnClickListener(this);

        tv_points.setText("Level 1, Tries left: " + tries);


    }

    @Override
    public void onClick(View v) {
        String guess = txt_guess.getText().toString();
        if(v.getId() == R.id.ib_home)
        {
            Intent main = new Intent(Level_one.this, MainActivity.class);
            startActivity(main);
        }
        if(guess.equals(ans))
        {
            MediaPlayer ring1= MediaPlayer.create(Level_one.this,R.raw.success);
            ring1.start();

            iv_lvlone.setVisibility(View.INVISIBLE);
            SystemClock.sleep(1000);

            Intent lvlTwo = new Intent(Level_one.this, Level_two.class);
            startActivity(lvlTwo);
        }
        else
        {
            MediaPlayer ring= MediaPlayer.create(Level_one.this,R.raw.buzzer);
            ring.start();

            if(tries == 1)
            {
                Intent main = new Intent(Level_one.this, MainActivity.class);
                startActivity(main);
            }
            if(!guess.equals(""))
            {
                tries -= 1;
            }
            tv_points.setText("Level 1, Tries left: " + tries);
        }
    }
}