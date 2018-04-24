package com.example.user.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class userlogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlogin);
    }

    public void do_login(View view) {

        EditText email_et = findViewById(R.id.user_email);

        EditText password_et = findViewById(R.id.user_pass);

        String email = email_et.getText().toString();
        String password = password_et.getText().toString();


        FirebaseAuth auth = FirebaseAuth.getInstance();

        auth.signInWithEmailAndPassword(email , password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {
                    startActivity( new Intent(userlogin.this , user_home.class));


                }
                else {

                    Toast.makeText(userlogin.this , "invalid credentials" , Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    public void user_sign_up(View view) {
        startActivity( new Intent(userlogin.this ,stp2User.class));

    }
}
