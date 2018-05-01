package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class admin_home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
    }

    public void view(View view) {
        startActivity(new Intent(this,booked_list.class));
    }

    public void add(View view) {
        startActivity(new Intent(this,stp2admin.class));
    }
}
