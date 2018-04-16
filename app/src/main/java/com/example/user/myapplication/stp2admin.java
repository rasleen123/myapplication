package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class stp2admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stp2admin);
    }

    public void open_veneue(View view) {

        startActivity(new Intent(stp2admin.this , addVenue.class));
    }

    public void open_decorator(View view) {

        startActivity(new Intent(stp2admin.this , addDecoraters.class));


    }

    public void add_caterers(View view) {

        startActivity(new Intent(stp2admin.this , addCaterers.class));

    }


    public void add_Dj(View view) {

        startActivity(new Intent(stp2admin.this , addDj.class));


    }

    public void add_photographers(View view) {

        startActivity(new Intent(stp2admin.this , addPhotographer.class));

    }

    public void add_designers(View view) {


        startActivity(new Intent(stp2admin.this , addDesigners.class));
    }

    public void add_salon(View view) {

        startActivity(new Intent(stp2admin.this , addSalon.class));

    }
}
