package com.example.multipleintentslistviewadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
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
    static String[] registeredUsers = new String[3];
    static int cnt = 2;

    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("x", x + "");
        btn_j_gotoRegister = findViewById(R.id.btn_v_gotoRegister);
        tv_j_welcome = findViewById(R.id.tv_v_welcome);
        lv_j_users = findViewById(R.id.lv_v_listOfNames);
        //The intent you came from and the intent you want to load.
        int_j_registerIntent = new Intent(MainActivity.this, Register.class);

        //For testing purposes
        registeredUsers[0] = "Bob Smith";
        registeredUsers[1] = "Beth William";

        //Try to see if there is a bundle being passed to MainActivity.java
        //If there is, parse the data
        //If there is not, skip this code
        Intent cameFrom = getIntent();
        //Get the bundle
        Bundle infoPassedToMe = cameFrom.getExtras();

        //Make sure we only do this if the activity is loading from Register.java
        if (infoPassedToMe != null)
        {
            String fullName = infoPassedToMe.getString("Name");
            Log.d("Registered Name", fullName);
            registeredUsers[cnt] = fullName;
            cnt++;
            displayRegisteredUsers();
            fillListView();
        }


        registerButtonEventHandler();
    }

    public void displayRegisteredUsers()
    {
        for(int i = 0; i < cnt; i++)
        {
            Log.d("RegisteredUser", registeredUsers[i]);
        }
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

    public void fillListView()
    {
        //Built in list views and adapters only work with string arrays
        //If you want to customize you need a custom adapter and a custom cell
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,registeredUsers);
        //set the listviews adapter
        lv_j_users.setAdapter(adapter);

    }
}