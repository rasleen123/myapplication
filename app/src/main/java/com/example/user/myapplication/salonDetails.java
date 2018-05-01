package com.example.user.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.myapplication.data_model.salon_details;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

public class salonDetails extends AppCompatActivity {

    String salonname, salonloc, salonservice = "Not Available";
    int price = 0;
    EditText et_salonname, et_salonloc, et_salonprice,et_salonservice ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon_details);
        et_salonname = findViewById(R.id.et_salonname);
        et_salonloc = findViewById(R.id.et_salonlocation);

        et_salonprice = findViewById(R.id.et_salonprice);

        et_salonservice = findViewById(R.id.et_salonservices);


    }


    public void save_salon(View view) {

        salonname = et_salonname.getText().toString();
        salonloc = et_salonloc.getText().toString();
        price = Integer.parseInt(et_salonprice.getText().toString());
        salonservice=et_salonservice.getText().toString();
        if (salonname.length() < 2 ||salonservice.length() < 2 || salonloc.length()  <2 || price == 0 ) {
            Toast.makeText(salonDetails.this, "Enter values", Toast.LENGTH_SHORT).show();

        } else {

            salon_details data = new salon_details(salonname, salonloc, salonservice, price);


            FirebaseDatabase database = FirebaseDatabase.getInstance();


            database.getReference().child("salon").child(salonname+salonloc).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {

                public void onComplete(@NonNull Task<Void> task) {

                    if(task.isSuccessful())
                    {

                        Toast.makeText(salonDetails.this , "Data added" , Toast.LENGTH_SHORT).show();
                        startActivity( new Intent(salonDetails.this , stp2admin.class));
                    }
                    else {

                        Toast.makeText(salonDetails.this , "Error" , Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
}
