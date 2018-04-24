package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class user_home extends AppCompatActivity {
    public static  String dj_name , venue_loc,venue_name , dj_loc,decorater_name,decorater_loc,designer_name,designer_loc,photographer_name,photographer_loc,
            salon_name,salon_loc,caterer_name,caterer_loc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);
    }

    public void view(View view) {
        startActivity( new Intent(user_home.this , booked_list.class));
    }


    public void book(View view) {
        startActivity( new Intent(user_home.this , viewVenues.class));
    }
}
