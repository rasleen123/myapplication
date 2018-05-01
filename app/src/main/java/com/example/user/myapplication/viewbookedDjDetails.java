package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class viewbookedDjDetails extends AppCompatActivity {


    TextView tv_djname, tv_djloc, tv_djprice, tv_djservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booked_view_dj_details);
        tv_djname = findViewById(R.id.tv_djname);
        tv_djloc = findViewById(R.id.tv_djloc);

        tv_djprice = findViewById(R.id.tv_djprice);

        tv_djservice = findViewById(R.id.tv_djservices);

        tv_djname.setText(getIntent().getStringExtra("djname"));
        tv_djloc.setText(getIntent().getStringExtra("djloc"));
        tv_djservice.setText(getIntent().getStringExtra("djservice"));
        tv_djprice.setText(getIntent().getStringExtra("djprice"));
    }


}