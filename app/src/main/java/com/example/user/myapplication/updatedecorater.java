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

public class updatedecorater extends AppCompatActivity {

    String decoratername, decoraterloc, decoraterservice = "Not Available";
    int price = 0;
    EditText et_decoratername, et_decoraterloc, et_decoraterprice,et_decoraterservice ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_decorater);
        et_decoratername = findViewById(R.id.et_decoratername);
        et_decoraterloc = findViewById(R.id.et_decoraterloc);

        et_decoraterprice = findViewById(R.id.et_decoraterprice);

        et_decoraterservice = findViewById(R.id.et_decoraterservices);

        et_decoratername.setText(getIntent().getStringExtra("decoratername"));
        et_decoraterloc.setText(getIntent().getStringExtra("decoraterloc"));
        et_decoraterservice.setText(getIntent().getStringExtra("decoraterservices"));
        et_decoraterprice.setText(getIntent().getStringExtra("decoraterprice"));
    }





    public void update_decorater(View view) {

        decoratername = et_decoratername.getText().toString();
        decoraterloc = et_decoraterloc.getText().toString();
        price = Integer.parseInt(et_decoraterprice.getText().toString());
        decoraterservice=et_decoraterservice.getText().toString();
        if (decoratername.length() < 2 ||decoraterservice.length() < 2 || decoraterloc.length() < 2 || price == 0 ) {
            Toast.makeText(updatedecorater.this, "Enter values", Toast.LENGTH_SHORT).show();

        } else {
            decorator_detail data = new decorator_detail(decoratername, decoraterloc, decoraterservice, price);


            FirebaseDatabase database = FirebaseDatabase.getInstance();


            database.getReference().child("decorater").child(decoratername+decoraterloc).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {

                public void onComplete(@NonNull Task<Void> task) {

                    if(task.isSuccessful())
                    {

                        Toast.makeText(updatedecorater.this , "Data updated" , Toast.LENGTH_SHORT).show();
                        startActivity( new Intent(updatedecorater.this , stp2admin.class));
                    }
                    else {

                        Toast.makeText(updatedecorater.this , "Error" , Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

}
