package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.myapplication.data_model.caterer_detail;
import com.example.user.myapplication.data_model.decorator_detail;
import com.example.user.myapplication.data_model.designer_detail;
import com.example.user.myapplication.data_model.dj_detail;
import com.example.user.myapplication.data_model.salon_details;
import com.example.user.myapplication.data_model.venue_details;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class admin_view_booked_event extends AppCompatActivity {
    String date, dj, venue, decorater, designer, photographer, salon, caterer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        date = getIntent().getStringExtra("date");
        dj = getIntent().getStringExtra("dj");
        venue = getIntent().getStringExtra("venue");
        decorater = getIntent().getStringExtra("decorater");
        designer = getIntent().getStringExtra("designer");
        photographer = getIntent().getStringExtra("photographer");
        salon = getIntent().getStringExtra("salon");
        caterer = getIntent().getStringExtra("caterer");
    }


    public void venue(View view) {


        FirebaseAuth firebase = FirebaseAuth.getInstance();
        String email = firebase.getCurrentUser().getEmail().replace(".", "");
        FirebaseDatabase data = FirebaseDatabase.getInstance();
        System.out.println("rrrr");
        data.getReference().child("venue").child(venue).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                venue_details details = dataSnapshot.getValue(venue_details.class);
                System.out.println("rrrrrr");
                String venuename = details.venuename;
                String venueloc = details.venue_loc;
                int venueprice = details.price;

                Intent i = new Intent(admin_view_booked_event.this, viewbookedvenueDetails.class);
                i.putExtra("venuename", venuename);
                i.putExtra("venueloc", venueloc);
                i.putExtra("venueprice", venueprice);
                startActivity(i);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


    public void decorator(View view) {
        if (decorater.equals("Not Booked")) {
            Button decorater = findViewById(R.id.decoraters_book);
            decorater.setVisibility(View.GONE);
        } else {
            FirebaseAuth firebase = FirebaseAuth.getInstance();
            String email = firebase.getCurrentUser().getEmail();
            FirebaseDatabase data = FirebaseDatabase.getInstance();
            System.out.println("rrrr");
            data.getReference().child("decorater").child(decorater).addListenerForSingleValueEvent(new ValueEventListener() {


                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    decorator_detail details = dataSnapshot.getValue(decorator_detail.class);
                    System.out.println("rrrrrr");
                    String decoratername = details.decoratorname;
                    String decoraterloc = details.decoratorloc;
                    String decoraterservice = details.decoratorservice;
                    int decoraterprice = details.decoratorprice;

                    Intent i = new Intent(admin_view_booked_event.this, viewbookedDecorDetails.class);
                    i.putExtra("decoratername", decoratername);
                    i.putExtra("decoraterloc", decoraterloc);
                    i.putExtra("decoraterservices", decoraterservice);
                    i.putExtra("decoraterprice", decoraterprice);
                    startActivity(i);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }

    public void caterers(View view) {
        if (caterer.equals("Not Booked")) {
            Button caterer = findViewById(R.id.caterers_book);
            caterer.setVisibility(View.GONE);
        } else {
            FirebaseAuth firebase = FirebaseAuth.getInstance();
            String email = firebase.getCurrentUser().getEmail();
            FirebaseDatabase data = FirebaseDatabase.getInstance();
            System.out.println("rrrr");
            data.getReference().child("caterer").child(caterer).addListenerForSingleValueEvent(new ValueEventListener() {


                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    caterer_detail details = dataSnapshot.getValue(caterer_detail.class);
                    System.out.println("rrrrrr");
                    String caterername = details.caterername;
                    String catererloc = details.catererloc;
                    String catererservice = details.catererservice;
                    int catererprice = details.catererprice;

                    Intent i = new Intent(admin_view_booked_event.this, viewbookedCaterersDetails.class);
                    i.putExtra("caterername", caterername);
                    i.putExtra("catererloc", catererloc);
                    i.putExtra("catererservices", catererservice);
                    i.putExtra("catererprice", catererprice);
                    startActivity(i);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }

    public void Dj(View view) {
        if (dj.equals("Not Booked")) {
            Button dj = findViewById(R.id.dj_book);
            dj.setVisibility(View.GONE);
        } else {
            FirebaseAuth firebase = FirebaseAuth.getInstance();
            String email = firebase.getCurrentUser().getEmail();
            FirebaseDatabase data = FirebaseDatabase.getInstance();
            System.out.println("rrrr");
            data.getReference().child("dj").child(dj).addListenerForSingleValueEvent(new ValueEventListener() {


                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    dj_detail details = dataSnapshot.getValue(dj_detail.class);
                    System.out.println("rrrrrr");
                    String djname = details.djname;
                    String djloc = details.djloc;
                    String djservice = details.djservice;
                    int djprice = details.djprice;

                    Intent i = new Intent(admin_view_booked_event.this, viewbookedDjDetails.class);
                    i.putExtra("djname", djname);
                    i.putExtra("djloc", djloc);
                    i.putExtra("djservices", djservice);
                    i.putExtra("djprice", djprice);
                    startActivity(i);
                }


                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }

    public void photographers(View view) {
        if (photographer.equals("Not Booked")) {
            Button photogragher = findViewById(R.id.photographer_book);
            photogragher.setVisibility(View.GONE);
        } else {
            FirebaseAuth firebase = FirebaseAuth.getInstance();
            String email = firebase.getCurrentUser().getEmail();
            FirebaseDatabase data = FirebaseDatabase.getInstance();
            System.out.println("rrrr");
            data.getReference().child("photographer").child(photographer).addListenerForSingleValueEvent(new ValueEventListener() {


                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    photographer_details details = dataSnapshot.getValue(photographer_details.class);
                    System.out.println("rrrrrr");
                    String photographername = details.photographername;
                    String photographerloc = details.photographerloc;
                    String photographerservice = details.photographerservice;
                    int photographerprice = details.photographerprice;

                    Intent i = new Intent(admin_view_booked_event.this, viewbookedPhotographerDetails.class);
                    i.putExtra("photographername", photographername);
                    i.putExtra("photographerloc", photographerloc);
                    i.putExtra("photographerservices", photographerservice);
                    i.putExtra("photographerprice", photographerprice);
                    startActivity(i);
                }


                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }

    public void designers(View view) {
        if (designer.equals("Not Booked")) {
            Button designer = findViewById(R.id.designers_book);
            designer.setVisibility(View.GONE);
        } else {
            FirebaseAuth firebase = FirebaseAuth.getInstance();
            String email = firebase.getCurrentUser().getEmail();
            FirebaseDatabase data = FirebaseDatabase.getInstance();
            System.out.println("rrrr");
            data.getReference().child("designer").child(designer).addListenerForSingleValueEvent(new ValueEventListener() {


                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    designer_detail details = dataSnapshot.getValue(designer_detail.class);
                    System.out.println("rrrrrr");
                    String designername = details.designername;
                    String designerloc = details.designerloc;
                    String designerservice = details.designerservice;
                    int designerprice = details.designerprice;

                    Intent i = new Intent(admin_view_booked_event.this, viewbookedDesignerDetails.class);
                    i.putExtra("designername", designername);
                    i.putExtra("designerloc", designerloc);
                    i.putExtra("designerservices", designerservice);
                    i.putExtra("designerprice", designerprice);
                    startActivity(i);
                }


                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }

    public void salon(View view) {
        if (salon.equals("Not Booked")) {
            Button salon = findViewById(R.id.saloon_book);
            salon.setVisibility(View.GONE);
        } else {
            FirebaseAuth firebase = FirebaseAuth.getInstance();
            String email = firebase.getCurrentUser().getEmail();
            FirebaseDatabase data = FirebaseDatabase.getInstance();
            System.out.println("rrrr");
            data.getReference().child("salon").child(salon).addListenerForSingleValueEvent(new ValueEventListener() {


                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    salon_details details = dataSnapshot.getValue(salon_details.class);
                    System.out.println("rrrrrr");
                    String salonname = details.salonname;
                    String salonloc = details.salonloc;
                    String salonservice = details.salonservice;
                    int salonprice = details.salonprice;

                    Intent i = new Intent(admin_view_booked_event.this, viewbookedSalonDetails.class);
                    i.putExtra("salonname", salonname);
                    i.putExtra("salonloc", salonloc);
                    i.putExtra("salonservices", salonservice);
                    i.putExtra("salonprice", salonprice);
                    startActivity(i);
                }


                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
}