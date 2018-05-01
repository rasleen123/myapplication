package com.example.user.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.myapplication.data_model.caterer_detail;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

public class catererDetails extends AppCompatActivity {

    String caterername, catererloc, catererservice = "Not Available";
    int price = 0;
    EditText et_caterername, et_catererloc, et_catererprice,et_catererservice ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caterer_details);
        et_caterername = findViewById(R.id.et_caterername);
        et_catererloc = findViewById(R.id.et_catererloc);

        et_catererprice = findViewById(R.id.et_catererprice);

        et_catererservice = findViewById(R.id.et_catererservices);


    }


    public void save_caterer(View view) {

        caterername = et_caterername.getText().toString();
        catererloc = et_catererloc.getText().toString();
        price = Integer.parseInt(et_catererprice.getText().toString());
        catererservice=et_catererservice.getText().toString();
        if (caterername.length() < 2 ||catererservice.length() < 2 || catererloc.length() < 2 || price == 0 ) {
            Toast.makeText(catererDetails.this, "Enter values", Toast.LENGTH_SHORT).show();

        } else {
            caterer_detail data = new caterer_detail(caterername, catererloc, catererservice, price);
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            database.getReference().child("caterer").child(caterername+catererloc).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {

                public void onComplete(@NonNull Task<Void> task) {

                    if(task.isSuccessful())
                    {

                        Toast.makeText(catererDetails.this , "Data added" , Toast.LENGTH_SHORT).show();
                        startActivity( new Intent(catererDetails.this , stp2admin.class));
                    }
                    else {

                        Toast.makeText(catererDetails.this , "Error" , Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }


}
