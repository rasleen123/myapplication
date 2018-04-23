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

public class viewCaterersDetails extends AppCompatActivity {

    String caterername, catererloc, catererservice = "Not Available";
    int price = 0;
    TextView tv_caterername, tv_catererloc, tv_catererprice,tv_catererservice ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_designer_details);
        tv_caterername = findViewById(R.id.tv_caterername);
        tv_catererloc = findViewById(R.id.tv_catererloc);

        tv_catererprice = findViewById(R.id.tv_catererprice);

        tv_catererservice = findViewById(R.id.tv_catererservices);

        tv_caterername.setText(getIntent().getStringExtra("caterername"));
        tv_catererloc.setText(getIntent().getStringExtra("catererloc"));
        tv_catererservice.setText(getIntent().getStringExtra("catererservice"));
        tv_catererprice.setText(getIntent().getStringExtra("catererprice"));
    }


    public void book_caterer(View view) {
        user_home.caterer_name=getIntent().getStringExtra("caterername");
        user_home.caterer_loc=getIntent().getStringExtra("catererloc");
        startActivity( new Intent(viewCaterersDetails.this , viewDecor.class));

    }
}
