package com.example.user.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.myapplication.data_model.createaccount;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class stp2User extends AppCompatActivity {
EditText name,number,email,password,cpass;
    String sname,snumber,semail,spassword,scpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login_step2);
     name=findViewById(R.id.name_et);
    number=findViewById(R.id.number_et);
    email=findViewById(R.id.email_et);
    password=findViewById(R.id.pass_et);
    cpass=findViewById(R.id.cpass_et);

    }

    public void register(View view) {
        sname=name.getText().toString();
        snumber=number.getText().toString();
        semail=email.getText().toString();
        spassword=password.getText().toString();
        scpass=cpass.getText().toString();

        if (Patterns.EMAIL_ADDRESS.matcher(semail).matches()) {

        } else {
            Toast.makeText(stp2User.this, "invalid email", Toast.LENGTH_SHORT).show();
            return;
        }


        if (spassword.length() >= 8 && spassword.length() < 33) {

        } else {
            Toast.makeText(stp2User.this, "password must be between 8-33 character", Toast.LENGTH_SHORT).show();
            return;
        }

        if (snumber.length() >=10 ){

        } else {
            Toast.makeText(stp2User.this, "Enter address", Toast.LENGTH_SHORT).show();
            return;
        }
        if (sname.length() >= 2) {

        } else {
            Toast.makeText(stp2User.this, "Enter name", Toast.LENGTH_SHORT).show();
            return;
        }


        if (scpass.equals(spassword)) {

        } else {
            Toast.makeText(stp2User.this, "confirm password", Toast.LENGTH_SHORT).show();
            return;
        }


        final ProgressDialog progress_bar = new ProgressDialog(stp2User.this);
        progress_bar.setTitle("please wait");
        progress_bar.setMessage("Create account");
        progress_bar.show();

        FirebaseAuth f_auth = FirebaseAuth.getInstance();

        OnCompleteListener<AuthResult> listener = new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progress_bar.hide();

                if (task.isSuccessful()) {
                    Toast.makeText(stp2User.this, "done", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(stp2User.this, user_home.class);
                    final createaccount data = new createaccount(sname, snumber);
                    final FirebaseDatabase database = FirebaseDatabase.getInstance();
                    database.getReference().child("user").child(semail.replace(".","")).setValue(data);
                    startActivity(i);
                } else {
                    Toast.makeText(stp2User.this, "error try again", Toast.LENGTH_SHORT).show();
                }
            }
        };

        f_auth.createUserWithEmailAndPassword(semail, spassword).addOnCompleteListener(listener);



    }
}
