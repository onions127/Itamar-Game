package com.example.itamargame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Level_three extends AppCompatActivity implements View.OnClickListener {

    EditText txt_guess;
    String ans = "צריך";
    ImageView iv_lvlthree;
    Button btn_sub;
    TextView tv_points;
    LinearLayout lo_three;
    Button ib_home;
    int tries = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_three);

        txt_guess = findViewById(R.id.txt_guess);
        btn_sub = findViewById(R.id.btn_sub);
        iv_lvlthree = findViewById(R.id.iv_lvlthree);
        tv_points = findViewById(R.id.tv_points);
        lo_three = findViewById(R.id.lo_three);
        ib_home = findViewById(R.id.ib_home);
        btn_sub.setOnClickListener(this);
        ib_home.setOnClickListener(this);

        tv_points.setText("Level 3, Tries left: " + tries);

    }

    @Override
    public void onClick(View v) {
        String guess = txt_guess.getText().toString();
        if(v.getId() == R.id.ib_home){
            Intent main = new Intent(Level_three.this, MainActivity.class);
            startActivity(main);
        }
        if(guess.equals(ans))
        {
            MediaPlayer ring1= MediaPlayer.create(Level_three.this,R.raw.success);
            ring1.start();

            iv_lvlthree.setVisibility(View.INVISIBLE);
            SystemClock.sleep(1000);

            Intent Level_four = new Intent(Level_three.this, Level_four.class);
            startActivity(Level_four);
        }
        else
        {
            MediaPlayer ring= MediaPlayer.create(Level_three.this,R.raw.buzzer);
            ring.start();

            if(tries == 1)
            {
                Intent main = new Intent(Level_three.this, MainActivity.class);
                startActivity(main);
            }
            if(!guess.equals(""))
            {
                tries -= 1;
            }
            tv_points.setText("Level 3, Tries left: " + tries);
        }
    }
}