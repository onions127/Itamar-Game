package com.example.itamargame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Level_six extends AppCompatActivity implements View.OnClickListener {

    EditText txt_guess;
    String ans = "הדמיון";
    ImageView iv_lvlsix;
    Button btn_sub;
    TextView tv_points;
    Button ib_home;
    int tries = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_six);

        txt_guess = findViewById(R.id.txt_guess);
        btn_sub = findViewById(R.id.btn_sub);
        iv_lvlsix = findViewById(R.id.iv_lvlsix);
        tv_points = findViewById(R.id.tv_points);
        ib_home = findViewById(R.id.ib_home);
        btn_sub.setOnClickListener(this);
        ib_home.setOnClickListener(this);

        tv_points.setText("Level 6, Tries left: " + tries);

    }

    @Override
    public void onClick(View v) {
        String guess = txt_guess.getText().toString();
        if(v.getId() == R.id.ib_home){
            Intent main = new Intent(Level_six.this, MainActivity.class);
            startActivity(main);
        }
        if(guess.equals(ans))
        {
            MediaPlayer ring1= MediaPlayer.create(Level_six.this,R.raw.success);
            ring1.start();

            iv_lvlsix.setVisibility(View.INVISIBLE);
            SystemClock.sleep(1000);

            Intent Level_seven = new Intent(Level_six.this, Level_seven.class);
            startActivity(Level_seven);
        }
        else
        {
            MediaPlayer ring= MediaPlayer.create(Level_six.this,R.raw.buzzer);
            ring.start();

            if(tries == 1)
            {
                Intent main = new Intent(Level_six.this, MainActivity.class);
                startActivity(main);
            }
            if(!guess.equals(""))
            {
                tries -= 1;
            }
            tv_points.setText("Level 6, Tries left: " + tries);
        }
    }
}