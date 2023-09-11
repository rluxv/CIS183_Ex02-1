package com.example.multipleintentslistviewadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Register extends AppCompatActivity
{
    Button btn_v_r_back;
    Intent int_j_welcomeIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btn_v_r_back = findViewById(R.id.btn_v_r_back);
        int_j_welcomeIntent = new Intent(Register.this, MainActivity.class);

        //code to get info pass from mainactivity.java
        //get the intent that called me
        Intent cameFrom = getIntent();
        //get the bundle that was to me from "cameFrom" intent
        Bundle infoPassedToMe = cameFrom.getExtras();
        //get the info in the bundle called "InfoPassed" set in MainActivity.java
        String info = infoPassedToMe.getString("InfoPassed");
        //display message passed from MainActivity.java
        Log.d("Info passed from main: ", info);


        backButtonEventHandler();
    }

    public void backButtonEventHandler()
    {
        btn_v_r_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(int_j_welcomeIntent);
            }
        });
    }
}