package com.example.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.myapplication.data_model.decorator_detail;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

public class updatecaterer extends AppCompatActivity {

    String caterername, catererloc, catererservice = "Not Available";
    int price = 0;
    EditText et_caterername, et_catererloc, et_catererprice,et_catererservice ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_caterer);
        et_caterername = findViewById(R.id.et_caterername);
        et_catererloc = findViewById(R.id.et_catererloc);

        et_catererprice = findViewById(R.id.et_catererprice);

        et_catererservice = findViewById(R.id.et_catererservices);

        et_caterername.setText(getIntent().getStringExtra("caterername"));
        et_catererloc.setText(getIntent().getStringExtra("catererloc"));
        et_catererservice.setText(getIntent().getStringExtra("catererservice"));
        et_catererprice.setText(getIntent().getStringExtra("catererprice"));
    }


    public void update_caterer(View view) {

        caterername = et_caterername.getText().toString();
        catererloc = et_catererloc.getText().toString();
        price = Integer.parseInt(et_catererprice.getText().toString());
        catererservice=et_catererservice.getText().toString();
        if (caterername.length() < 2 ||catererservice.length() < 2 || catererloc.length() < 2 || price == 0 ) {
            Toast.makeText(updatecaterer.this, "Enter values", Toast.LENGTH_SHORT).show();

        } else {
            decorator_detail data = new decorator_detail(caterername, catererloc, catererservice, price);


            FirebaseDatabase database = FirebaseDatabase.getInstance();


            database.getReference().child("caterer").child(caterername+catererloc).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {

                public void onComplete(@NonNull Task<Void> task) {

                    if(task.isSuccessful())
                    {

                        Toast.makeText(updatecaterer.this , "Data updated" , Toast.LENGTH_SHORT).show();
                        startActivity( new Intent(updatecaterer.this , stp2admin.class));
                    }
                    else {

                        Toast.makeText(updatecaterer.this , "Error" , Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

}
