package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class viewbookedSalonDetails extends AppCompatActivity {


    TextView tv_salonname, tv_salonloc, tv_salonprice,tv_salonservice ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booked_view_salon_details);
        tv_salonname = findViewById(R.id.tv_salonname);
        tv_salonloc = findViewById(R.id.tv_salonlocation);

        tv_salonprice = findViewById(R.id.tv_salonprice);

        tv_salonservice = findViewById(R.id.tv_salonservices);

        tv_salonname.setText(getIntent().getStringExtra("salonname"));
        tv_salonloc.setText(getIntent().getStringExtra("salonloc"));
        tv_salonservice.setText(getIntent().getStringExtra("salonservice"));
        tv_salonprice.setText(getIntent().getStringExtra("salonprice"));
    }


}
