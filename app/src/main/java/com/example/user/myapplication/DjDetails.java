package com.example.user.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.myapplication.data_model.dj_detail;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

public class DjDetails extends AppCompatActivity {

    String djname, djloc, djservice = "Not Available";
    int price = 0;
    EditText et_djname, et_djloc, et_djprice,et_djservice ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dj_details);
        et_djname = findViewById(R.id.et_djname);
        et_djloc = findViewById(R.id.et_djloc);

        et_djprice = findViewById(R.id.et_djprice);

        et_djservice = findViewById(R.id.et_djservices);


    }


    public void save_dj(View view) {

        djname = et_djname.getText().toString();
        djloc = et_djloc.getText().toString();
        price = Integer.parseInt(et_djprice.getText().toString());
        djservice=et_djservice.getText().toString();
        if (djname.length() < 2 ||djservice.length() < 2 || djloc.length() < 2 || price == 0 ) {
            Toast.makeText(DjDetails.this, "Enter values", Toast.LENGTH_SHORT).show();

        } else {
            dj_detail data = new dj_detail(djname, djloc, djservice, price);


            FirebaseDatabase database = FirebaseDatabase.getInstance();


            database.getReference().child("dj").child(djname+djloc).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {

                public void onComplete(@NonNull Task<Void> task) {

                    if(task.isSuccessful())
                    {

                        Toast.makeText(DjDetails.this , "Data added" , Toast.LENGTH_SHORT).show();
                        startActivity( new Intent(DjDetails.this , stp2admin.class));
                    }
                    else {

                        Toast.makeText(DjDetails.this , "Error" , Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

}
