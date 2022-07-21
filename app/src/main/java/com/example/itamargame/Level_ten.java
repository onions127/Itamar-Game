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

public class Level_ten extends AppCompatActivity implements View.OnClickListener {

    EditText txt_guess;
    String ans = "בגודל";
    Button btn_sub;
    TextView tv_points;
    ImageView iv_lvlten;
    Button ib_home;
    int tries = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_ten);

        txt_guess = findViewById(R.id.txt_guess);
        btn_sub = findViewById(R.id.btn_sub);
        tv_points = findViewById(R.id.tv_points);
        iv_lvlten = findViewById(R.id.iv_lvlthirteen);
        ib_home = findViewById(R.id.ib_home);
        btn_sub.setOnClickListener(this);
        ib_home.setOnClickListener(this);

        tv_points.setText("Level 10, Tries left: " + tries);

    }

    @Override
    public void onClick(View v) {
        String guess = txt_guess.getText().toString();
        if(v.getId() == R.id.ib_home){
            Intent main = new Intent(Level_ten.this, MainActivity.class);
            startActivity(main);
        }
        if(guess.equals(ans))
        {
            MediaPlayer ring1= MediaPlayer.create(Level_ten.this,R.raw.success);
            ring1.start();

            iv_lvlten.setVisibility(View.INVISIBLE);
            SystemClock.sleep(1000);

            Intent Level_eleven = new Intent(Level_ten.this, level_eleven.class);
            startActivity(Level_eleven);
        }
        else
        {
            MediaPlayer ring= MediaPlayer.create(Level_ten.this,R.raw.buzzer);
            ring.start();

            if(tries == 1)
            {
                Intent main = new Intent(Level_ten.this, MainActivity.class);
                startActivity(main);
            }
            if(!guess.equals("")) {
                tries -= 1;
            }
            tv_points.setText("Level 10, Tries left: " + tries);
        }
    }
}