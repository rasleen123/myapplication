package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class viewVenueDetails extends AppCompatActivity {

    String venuename, venue_loc, service1 = "Not Available", service2 = "Not Available", service3 = "Not Available";
    CheckBox cb_service1, cb_Service3, cb_Service2;
    int price = 0, capacity = 0;
    TextView tv_venuename, tv_venue_loc, tv_price, tv_capacity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_venue_details);
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

    public void book_venue(View view) {

        user_home.venue_name=getIntent().getStringExtra("venuename");
        user_home.venue_loc=getIntent().getStringExtra("venueloc");
        startActivity( new Intent(viewVenueDetails.this , viewCaterer.class));
    }
}
