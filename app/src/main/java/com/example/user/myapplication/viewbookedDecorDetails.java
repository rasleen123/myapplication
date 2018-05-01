package com.example.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

public class viewbookedDecorDetails extends AppCompatActivity {


    TextView tv_decoratername, tv_decoraterloc, tv_decoraterprice,tv_decoraterservice ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booked_view_decor_details);
        tv_decoratername = findViewById(R.id.tv_decoratername);
        tv_decoraterloc = findViewById(R.id.tv_decoraterloc);

        tv_decoraterprice = findViewById(R.id.tv_decoraterprice);

        tv_decoraterservice = findViewById(R.id.tv_decoraterservices);

        tv_decoratername.setText(getIntent().getStringExtra("decoratername"));
        tv_decoraterloc.setText(getIntent().getStringExtra("decoraterloc"));
        tv_decoraterservice.setText(getIntent().getStringExtra("decoraterservice"));
        tv_decoraterprice.setText(getIntent().getStringExtra("decoraterprice"));
    }


    }
