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
String date,dj,venue,decorater,designer,photographer,salon,caterer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_book_event);
        date=getIntent().getStringExtra("date");
                dj=getIntent().getStringExtra("dj");
                venue=getIntent().getStringExtra("venue");
                decorater=getIntent().getStringExtra("decorater");
                designer=getIntent().getStringExtra("designer");
                photographer=getIntent().getStringExtra("photographer");
        salon=getIntent().getStringExtra("salon");
                caterer=getIntent().getStringExtra("caterer");
    }


    public void venue(View view) {
        FirebaseAuth firebase = FirebaseAuth.getInstance();
        String email = firebase.getCurrentUser().getEmail().replace(".","");
        FirebaseDatabase data = FirebaseDatabase.getInstance();
        System.out.println("rrrr");
        data.getReference().child(venue).addListenerForSingleValueEvent(new ValueEventListener() {


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
        data.getReference().child(decorater).addListenerForSingleValueEvent(new ValueEventListener() {


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
        data.getReference().child(caterer).addListenerForSingleValueEvent(new ValueEventListener() {


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
        data.getReference().child(dj).addListenerForSingleValueEvent(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    dj_detail details = data.getValue(dj_detail.class);
                    System.out.println("rrrrrr");
                    String djname = details.djname;
                    String djloc = details.djloc;
                    String djservice = details.djservice;
                    int djprice = details.djprice;

                    Intent i = new Intent(view_book_event.this, viewbookedDjDetails.class);
                    i.putExtra("djname", djname);
                    i.putExtra("djloc", djloc);
                    i.putExtra("djservices", djservice);
                    i.putExtra("djprice", djprice);
                    startActivity(i);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void photographers(View view) {
        FirebaseAuth firebase = FirebaseAuth.getInstance();
        String email = firebase.getCurrentUser().getEmail();
        FirebaseDatabase data = FirebaseDatabase.getInstance();
        System.out.println("rrrr");
        data.getReference().child(photographer).addListenerForSingleValueEvent(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    photographer_details details = data.getValue(photographer_details.class);
                    System.out.println("rrrrrr");
                    String photographername = details.photographername;
                    String photographerloc = details.photographerloc;
                    String photographerservice = details.photographerservice;
                    int photographerprice = details.photographerprice;

                    Intent i = new Intent(view_book_event.this, viewbookedPhotographerDetails.class);
                    i.putExtra("photographername", photographername);
                    i.putExtra("photographerloc", photographerloc);
                    i.putExtra("photographerservices", photographerservice);
                    i.putExtra("photographerprice", photographerprice);
                    startActivity(i);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void designers(View view) {
        FirebaseAuth firebase = FirebaseAuth.getInstance();
        String email = firebase.getCurrentUser().getEmail();
        FirebaseDatabase data = FirebaseDatabase.getInstance();
        System.out.println("rrrr");
        data.getReference().child(designer).addListenerForSingleValueEvent(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    designer_detail details = data.getValue(designer_detail.class);
                    System.out.println("rrrrrr");
                    String designername = details.designername;
                    String designerloc = details.designerloc;
                    String designerservice = details.designerservice;
                    int designerprice = details.designerprice;

                    Intent i = new Intent(view_book_event.this, viewbookedDesignerDetails.class);
                    i.putExtra("designername", designername);
                    i.putExtra("designerloc", designerloc);
                    i.putExtra("designerservices", designerservice);
                    i.putExtra("designerprice", designerprice);
                    startActivity(i);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void salon(View view) {

        FirebaseAuth firebase = FirebaseAuth.getInstance();
        String email = firebase.getCurrentUser().getEmail();
        FirebaseDatabase data = FirebaseDatabase.getInstance();
        System.out.println("rrrr");
        data.getReference().child(salon).addListenerForSingleValueEvent(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    salon_details details = data.getValue(salon_details.class);
                    System.out.println("rrrrrr");
                    String salonname = details.salonname;
                    String salonloc = details.salonloc;
                    String salonservice = details.salonservice;
                    int salonprice = details.salonprice;

                    Intent i = new Intent(view_book_event.this, viewbookedSalonDetails.class);
                    i.putExtra("salonname", salonname);
                    i.putExtra("salonloc", salonloc);
                    i.putExtra("salonservices", salonservice);
                    i.putExtra("salonprice", salonprice);
                    startActivity(i);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
