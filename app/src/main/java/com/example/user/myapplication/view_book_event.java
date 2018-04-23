package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class view_book_event extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_book_event);
    }


    public void venue(View view) {
        FirebaseAuth firebase = FirebaseAuth.getInstance();
        String email = firebase.getCurrentUser().getEmail();
        FirebaseDatabase data = FirebaseDatabase.getInstance();
        System.out.println("rrrr");
        data.getReference().child(email).child("venue").addListenerForSingleValueEvent(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    venue_details details = data.getValue(venue_details.class);
                    System.out.println("rrrrrr");
                    String venuename = details.venuename;
                    String venueloc = details.venue_loc;
                    int venueprice = details.price;

                    Intent i = new Intent(view_book_event.this, viewbookedDecorDetails.class);
                    i.putExtra("venuename", venuename);
                    i.putExtra("venueloc", venueloc);
                    i.putExtra("venueprice", venueprice);
                    startActivity(i);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    public void decorator(View view) {
        FirebaseAuth firebase = FirebaseAuth.getInstance();
        String email = firebase.getCurrentUser().getEmail();
        FirebaseDatabase data = FirebaseDatabase.getInstance();
        System.out.println("rrrr");
        data.getReference().child(email).child("decorater").addListenerForSingleValueEvent(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    decorator_detail details = data.getValue(decorator_detail.class);
                    System.out.println("rrrrrr");
                    String decoratername = details.decoratorname;
                    String decoraterloc = details.decoratorloc;
                    String decoraterservice = details.decoratorservice;
                    int decoraterprice = details.decoratorprice;

                    Intent i = new Intent(view_book_event.this, viewbookedDecorDetails.class);
                    i.putExtra("decoratername", decoratername);
                    i.putExtra("decoraterloc", decoraterloc);
                    i.putExtra("decoraterservices", decoraterservice);
                    i.putExtra("decoraterprice", decoraterprice);
                    startActivity(i);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void caterers(View view) {
        FirebaseAuth firebase = FirebaseAuth.getInstance();
        String email = firebase.getCurrentUser().getEmail();
        FirebaseDatabase data = FirebaseDatabase.getInstance();
        System.out.println("rrrr");
        data.getReference().child(email).child("caterers").addListenerForSingleValueEvent(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    caterer_detail details = data.getValue(caterer_detail.class);
                    System.out.println("rrrrrr");
                    String caterername = details.caterername;
                    String catererloc = details.catererloc;
                    String catererservice = details.catererservice;
                    int catererprice = details.catererprice;

                    Intent i = new Intent(view_book_event.this, viewbookedCaterersDetails.class);
                    i.putExtra("caterername", caterername);
                    i.putExtra("catererloc", catererloc);
                    i.putExtra("catererservices", catererservice);
                    i.putExtra("catererprice", catererprice);
                    startActivity(i);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void Dj(View view) {
        FirebaseAuth firebase = FirebaseAuth.getInstance();
        String email = firebase.getCurrentUser().getEmail();
        FirebaseDatabase data = FirebaseDatabase.getInstance();
        System.out.println("rrrr");
        data.getReference().child(email).child("dj").addListenerForSingleValueEvent(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    caterer_detail details = data.getValue(caterer_detail.class);
                    System.out.println("rrrrrr");
                    String caterername = details.caterername;
                    String catererloc = details.catererloc;
                    String catererservice = details.catererservice;
                    int catererprice = details.catererprice;

                    Intent i = new Intent(view_book_event.this, viewbookedCaterersDetails.class);
                    i.putExtra("caterername", caterername);
                    i.putExtra("catererloc", catererloc);
                    i.putExtra("catererservices", catererservice);
                    i.putExtra("catererprice", catererprice);
                    startActivity(i);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void photographers(View view) {
    }

    public void designers(View view) {
    }

    public void salon(View view) {
    }
}
