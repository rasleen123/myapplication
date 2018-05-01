package com.example.user.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.user.myapplication.data_model.final_event;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.user.myapplication.user_home.caterer_loc;
import static com.example.user.myapplication.user_home.caterer_name;
import static com.example.user.myapplication.user_home.decorater_loc;
import static com.example.user.myapplication.user_home.decorater_name;
import static com.example.user.myapplication.user_home.designer_loc;
import static com.example.user.myapplication.user_home.designer_name;
import static com.example.user.myapplication.user_home.dj_loc;
import static com.example.user.myapplication.user_home.dj_name;
import static com.example.user.myapplication.user_home.photographer_loc;
import static com.example.user.myapplication.user_home.photographer_name;
import static com.example.user.myapplication.user_home.salon_loc;
import static com.example.user.myapplication.user_home.salon_name;
import static com.example.user.myapplication.user_home.venue_loc;
import static com.example.user.myapplication.user_home.venue_name;

public class bookEvent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_event);

    }


    public void finalize(View view) {
        long date=System.currentTimeMillis();
        final_event data=new final_event(date,dj_name , venue_loc,venue_name , dj_loc,decorater_name,decorater_loc,designer_name,designer_loc,photographer_name,photographer_loc,
                salon_name,salon_loc,caterer_name,caterer_loc);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        FirebaseAuth  fauth=FirebaseAuth.getInstance();
        String email =fauth.getCurrentUser().getEmail().replace(".","");
        database.getReference().child("Booked event").child(email).child(String.valueOf(date)).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {

            public void onComplete(@NonNull Task<Void> task) {

                if(task.isSuccessful())
                {
                    Toast.makeText(bookEvent.this , "Event Booked" , Toast.LENGTH_SHORT).show();
                    startActivity( new Intent(bookEvent.this , user_home.class));
                    finish();
                }
                else {

                    Toast.makeText(bookEvent.this , "Error" , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
