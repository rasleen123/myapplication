package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class viewbookedPhotographerDetails extends AppCompatActivity {


    TextView tv_photographername, tv_photographerloc, tv_photographerprice,tv_photographerservice ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booked_view_photographer_details);
        tv_photographername = findViewById(R.id.tv_photographername);
        tv_photographerloc = findViewById(R.id.tv_photographerloc);

        tv_photographerprice = findViewById(R.id.tv_photographerprice);

        tv_photographerservice = findViewById(R.id.tv_photographerservices);

        tv_photographername.setText(getIntent().getStringExtra("photographername"));
        tv_photographerloc.setText(getIntent().getStringExtra("photographerloc"));
        tv_photographerservice.setText(getIntent().getStringExtra("photographerservice"));
        tv_photographerprice.setText(getIntent().getStringExtra("photographerprice"));
    }


}
