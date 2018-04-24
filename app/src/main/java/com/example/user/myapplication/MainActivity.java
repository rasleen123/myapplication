package com.example.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by user on 09-04-2018.
 */

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    public void admin_login(View view) {

        startActivity(new Intent(MainActivity.this , adminlogin.class));
    }

    public void user_login(View view) {
        startActivity(new Intent(MainActivity.this , userlogin.class));
    }
}
