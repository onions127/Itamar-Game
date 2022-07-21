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
import android.widget.TextView;

public class level_eleven extends AppCompatActivity implements View.OnClickListener {

    EditText txt_guess;
    String ans = "שאלה";
    Button btn_sub;
    TextView tv_points;
    ImageView iv_lvleleven;
    Button ib_home;
    int tries = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_eleven);

        txt_guess = findViewById(R.id.txt_guess);
        btn_sub = findViewById(R.id.btn_sub);
        tv_points = findViewById(R.id.tv_points);
        iv_lvleleven = findViewById(R.id.iv_lvlthirteen);
        ib_home = findViewById(R.id.ib_home);
        btn_sub.setOnClickListener(this);
        ib_home.setOnClickListener(this);

        tv_points.setText("Level 11, Tries left: " + tries);

    }

    @Override
    public void onClick(View v) {
        String guess = txt_guess.getText().toString();
        if(v.getId() == R.id.ib_home){
            Intent main = new Intent(level_eleven.this, MainActivity.class);
            startActivity(main);
        }
        if(guess.equals(ans))
        {
            MediaPlayer ring1= MediaPlayer.create(level_eleven.this,R.raw.success);
            ring1.start();

            iv_lvleleven.setVisibility(View.INVISIBLE);
            SystemClock.sleep(1000);

            Intent Level_eleven = new Intent(level_eleven.this, Level_twelve.class);
            startActivity(Level_eleven);
        }
        else
        {
            MediaPlayer ring= MediaPlayer.create(level_eleven.this,R.raw.buzzer);
            ring.start();

            if(tries == 1)
            {
                Intent main = new Intent(level_eleven.this, MainActivity.class);
                startActivity(main);
            }
            if(!guess.equals("")) {
                tries -= 1;
            }
            tv_points.setText("Level 11, Tries left: " + tries);
        }
    }
}