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
import android.widget.LinearLayout;
import android.widget.TextView;

public class Level_two extends AppCompatActivity implements View.OnClickListener {

    EditText txt_guess;
    String ans = "הוא";
    ImageView iv_lvltwo;
    Button btn_sub;
    TextView tv_points;
    LinearLayout lo_two;
    Button ib_home;
    int tries = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_two);

        txt_guess = findViewById(R.id.txt_guess);
        btn_sub = findViewById(R.id.btn_sub);
        iv_lvltwo = findViewById(R.id.iv_lvlone);
        tv_points = findViewById(R.id.tv_points);
        lo_two = findViewById(R.id.lo_two);
        ib_home = findViewById(R.id.ib_home);
        btn_sub.setOnClickListener(this);
        ib_home.setOnClickListener(this);

        tv_points.setText("Level 2, Tries left: " + tries);

    }

    @Override
    public void onClick(View v) {
        String guess = txt_guess.getText().toString();
        if(v.getId() == R.id.ib_home){
            Intent main = new Intent(Level_two.this, MainActivity.class);
            startActivity(main);
        }
        if(guess.equals(ans))
        {
            MediaPlayer ring1= MediaPlayer.create(Level_two.this,R.raw.success);
            ring1.start();

            iv_lvltwo.setVisibility(View.INVISIBLE);
            SystemClock.sleep(1000);

            Intent Level_three = new Intent(Level_two.this, Level_three.class);
            startActivity(Level_three);
        }
        else
        {
            MediaPlayer ring= MediaPlayer.create(Level_two.this,R.raw.buzzer);
            ring.start();

            lo_two.setBackground(getDrawable(R.drawable.condomarmar));
            if(tries == 1)
            {
                Intent main = new Intent(Level_two.this, MainActivity.class);
                startActivity(main);
            }
            if(!guess.equals(""))
            {
                tries -= 1;
            }
            tv_points.setText("Level 2, Tries left: " + tries);
        }
    }
}