package com.example.itamargame;

import static com.example.itamargame.CommonMethod.SoundPlayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_start, btn_htp, btn_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start = findViewById(R.id.btn_start);
        btn_htp = findViewById(R.id.btn_how_to_play);
        btn_menu = findViewById(R.id.btn_menu);
        btn_start.setOnClickListener(this);
        btn_htp.setOnClickListener(this);
        btn_menu.setOnClickListener(this);

        SoundPlayer(this);
        CommonMethod.player.start();
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btn_start)
        {
            Intent lvlOne = new Intent(MainActivity.this, Level_one.class);
            startActivity(lvlOne);
        }
        else if(v.getId() == R.id.btn_how_to_play)
        {
            Uri uri = Uri.parse("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
            Intent rickRoll = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(rickRoll);
        }
        else if(v.getId() == R.id.btn_menu)
        {
            Intent menu = new Intent(MainActivity.this, Menu_one.class);
            startActivity(menu);
        }

    }
}