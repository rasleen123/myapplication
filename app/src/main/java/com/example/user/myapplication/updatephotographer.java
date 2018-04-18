package com.example.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

public class updatephotographer extends AppCompatActivity {

    String photographername, photographerloc, photographerservice = "Not Available";
    int price = 0;
    EditText et_photographername, et_photographerloc, et_photographerprice,et_photographerservice ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_photographer);
        et_photographername = findViewById(R.id.et_photographername);
        et_photographerloc = findViewById(R.id.et_photographerloc);

        et_photographerprice = findViewById(R.id.et_photographerprice);

        et_photographerservice = findViewById(R.id.et_photographerservices);

        et_photographername.setText(getIntent().getStringExtra("photographername"));
        et_photographerloc.setText(getIntent().getStringExtra("photographerloc"));
        et_photographerservice.setText(getIntent().getStringExtra("photographerservice"));
        et_photographerprice.setText(getIntent().getStringExtra("photographerprice"));
    }


    public void update_photographer(View view) {

        photographername = et_photographername.getText().toString();
        photographerloc = et_photographerloc.getText().toString();
        price = Integer.parseInt(et_photographerprice.getText().toString());
        photographerservice=et_photographerservice.getText().toString();
        if (photographername.length() < 2 ||photographerservice.length() < 2 || photographerloc.length() < 2 || price == 0 ) {
            Toast.makeText(updatephotographer.this, "Enter values", Toast.LENGTH_SHORT).show();

        } else {
            photographer_details data = new photographer_details(photographername, photographerloc, photographerservice, price);


            FirebaseDatabase database = FirebaseDatabase.getInstance();


            database.getReference().child("photographer").child(photographername+photographerloc).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {

                public void onComplete(@NonNull Task<Void> task) {

                    if(task.isSuccessful())
                    {

                        Toast.makeText(updatephotographer.this , "Data updated" , Toast.LENGTH_SHORT).show();
                        startActivity( new Intent(updatephotographer.this , stp2admin.class));
                    }
                    else {

                        Toast.makeText(updatephotographer.this , "Error" , Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

}
