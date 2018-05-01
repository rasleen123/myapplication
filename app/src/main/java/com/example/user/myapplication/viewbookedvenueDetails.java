package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class viewbookedvenueDetails extends AppCompatActivity {


    CheckBox cb_service1, cb_Service3, cb_Service2;
    TextView tv_venuename, tv_venue_loc, tv_price, tv_capacity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booked_view_venue_details);
        tv_venuename = findViewById(R.id.tv_venuename);
        tv_venue_loc = findViewById(R.id.tv_venue_loc);
        tv_venue_loc = findViewById(R.id.tv_venue_loc);
        tv_price = findViewById(R.id.tv_price);
        tv_capacity = findViewById(R.id.tv_capacity);
        cb_service1 = findViewById(R.id.rb_service1);
        cb_Service2 = findViewById(R.id.rb_service2);
        cb_Service3 = findViewById(R.id.rb_service3);
        tv_venuename.setText(getIntent().getStringExtra("venuename"));
        tv_venue_loc.setText(getIntent().getStringExtra("venueloc"));
        tv_price.setText(getIntent().getStringExtra("venueprice"));

    }


}
