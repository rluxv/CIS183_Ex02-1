package com.example.multipleintentslistviewadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    Button btn_j_gotoRegister;
    TextView tv_j_welcome;
    ListView lv_j_users;
    Intent int_j_registerIntent;
    //Looking at class variables and what happens when we return to this class from register.java
    static int x = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("x",x + "");
        btn_j_gotoRegister = findViewById(R.id.btn_v_gotoRegister);
        tv_j_welcome = findViewById(R.id.tv_v_welcome);
        lv_j_users = findViewById(R.id.lv_v_listOfNames);
        //The intent you came from and the intent you want to load.
        int_j_registerIntent = new Intent(MainActivity.this, Register.class);

        registerButtonEventHandler();
    }

    public void registerButtonEventHandler()
    {
        btn_j_gotoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                x++;
                Log.d("x button press: ",x + "");
                //Log.d("Button Press ---","Register Button Press");
                int_j_registerIntent.putExtra("InfoPassed","Hello from Main");
                //Go to the registration intent.
                startActivity(int_j_registerIntent);
            }
        });
    }
}