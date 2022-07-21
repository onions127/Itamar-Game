package com.example.itamargame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu_one extends AppCompatActivity implements View.OnClickListener {

    Button btn_one, btn_two, btn_three, btn_four, btn_five, btn_six, btn_seven, btn_eight, btn_nine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_one);

        btn_one = findViewById(R.id.btn_one);
        btn_two = findViewById(R.id.btn_two);
        btn_three = findViewById(R.id.btn_three);
        btn_four = findViewById(R.id.btn_four);
        btn_five = findViewById(R.id.btn_five);
        btn_six = findViewById(R.id.btn_six);
        btn_seven = findViewById(R.id.btn_seven);
        btn_eight = findViewById(R.id.btn_eight);
        btn_nine = findViewById(R.id.btn_nine);

        btn_one.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_three.setOnClickListener(this);
        btn_four.setOnClickListener(this);
        btn_five.setOnClickListener(this);
        btn_six.setOnClickListener(this);
        btn_seven.setOnClickListener(this);
        btn_eight.setOnClickListener(this);
        btn_nine.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_one)
        {
            Intent Level_one = new Intent(Menu_one.this, Level_one.class);
            startActivity(Level_one);
        }
        else if(v.getId() == R.id.btn_two)
        {
            Intent Level_two = new Intent(Menu_one.this, Level_two.class);
            startActivity(Level_two);
        }
        else if(v.getId() == R.id.btn_three)
        {
            Intent Level_three = new Intent(Menu_one.this, Level_three.class);
            startActivity(Level_three);
        }
        else if(v.getId() == R.id.btn_four)
        {
            Intent Level_four = new Intent(Menu_one.this, Level_four.class);
            startActivity(Level_four);
        }
        else if(v.getId() == R.id.btn_five)
        {
            Intent Level_five = new Intent(Menu_one.this, Level_five.class);
            startActivity(Level_five);
        }
        else if(v.getId() == R.id.btn_six)
        {
            Intent Level_six = new Intent(Menu_one.this, Level_six.class);
            startActivity(Level_six);
        }
        else if(v.getId() == R.id.btn_seven)
        {
            Intent Level_seven = new Intent(Menu_one.this, Level_seven.class);
            startActivity(Level_seven);
        }
        else if(v.getId() == R.id.btn_eight)
        {
            Intent Level_eight = new Intent(Menu_one.this, Level_eight.class);
            startActivity(Level_eight);
        }
        else if(v.getId() == R.id.btn_nine)
        {
            Intent Level_nine = new Intent(Menu_one.this, Level_nine.class);
            startActivity(Level_nine);
        }
    }
}