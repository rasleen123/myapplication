package com.example.user.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.myapplication.data_model.venue_details;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

public class VenueDetails extends AppCompatActivity {
    String venuename, venue_loc, service1 = "Not Available", service2 = "Not Available", service3 = "Not Available";
    CheckBox cb_service1, cb_Service3, cb_Service2;
    int price = 0, capacity = 0;
    EditText et_venuename, et_venue_loc, et_price, et_capacity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue_details);
        et_venuename = findViewById(R.id.et_venuename);

        et_venue_loc = findViewById(R.id.et_venue_loc);
        et_venue_loc = findViewById(R.id.et_venue_loc);
        et_price = findViewById(R.id.et_price);
        et_capacity = findViewById(R.id.et_capacity);
        cb_service1 = findViewById(R.id.rb_service1);
        cb_Service2 = findViewById(R.id.rb_service2);
        cb_Service3 = findViewById(R.id.rb_service3);

    }


    public void save_data(View view) {

        venuename = et_venuename.getText().toString();
        venue_loc = et_venue_loc.getText().toString();
        if (cb_service1.isChecked())

        {
            service1 = cb_service1.getText().toString();
        }
        if (cb_Service2.isChecked())

        {
            service2 = cb_Service2.getText().toString();
        }
        if (cb_Service3.isChecked())

        {
            service3 = cb_Service3.getText().toString();
        }
        price = Integer.parseInt(et_price.getText().toString());
        capacity = Integer.parseInt(et_capacity.getText().toString());

        if (venuename.length()< 2 || venue_loc.length() < 2 || price == 0 || capacity == 0) {
            Toast.makeText(VenueDetails.this, "Enter values", Toast.LENGTH_SHORT).show();

        } else {
            venue_details data = new venue_details(venuename, venue_loc, service1, service2, service3, price, capacity);


            FirebaseDatabase database = FirebaseDatabase.getInstance();


            database.getReference().child("venue").child(venuename + venue_loc).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {

                public void onComplete(@NonNull Task<Void> task) {

                    if(task.isSuccessful())
                    {
                        startActivity( new Intent(VenueDetails.this , stp2admin.class));

                        Toast.makeText(VenueDetails.this , "Data added" , Toast.LENGTH_SHORT).show();
                    }
                    else {

                        Toast.makeText(VenueDetails.this , "Error" , Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }

    }
}