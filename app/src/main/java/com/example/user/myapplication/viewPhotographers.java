package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class viewPhotographers extends AppCompatActivity {
    ArrayList<photographer_details > photographer_list;
    RecyclerView photographer_recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_photographers);
        photographer_list = new ArrayList<>();

        photographer_recycler = findViewById(R.id.photo_recycler);

        photographer_recycler.setLayoutManager(new LinearLayoutManager(viewPhotographers.this , LinearLayoutManager.VERTICAL, false));
    }

    public void skip_photo(View view) {
        user_home.photographer_loc="Not Booked";
        user_home.photographer_name="Not Booked";
        startActivity( new Intent(viewPhotographers.this , viewSalons.class));
    }
    public void get_photographer()
    {
        FirebaseAuth firebase = FirebaseAuth.getInstance();

        FirebaseDatabase data =FirebaseDatabase.getInstance();
        System.out.println("rrrr");
        data.getReference().child("photographer").addListenerForSingleValueEvent(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                photographer_list.clear();


                for (DataSnapshot data : dataSnapshot.getChildren())
                {
                    photographer_details details = data.getValue(photographer_details.class);
                    System.out.println("rrrrrr");
                    photographer_list.add(details);

                    Adapter adapter = new Adapter();

                    photographer_recycler.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();

        get_photographer();
    }

    public class view_holder extends RecyclerView.ViewHolder{

        TextView photographer_name,photographer_loc ;
        LinearLayout photographer_lay;
        public view_holder(View itemView) {
            super(itemView);

            photographer_name = itemView.findViewById(R.id.name);

            photographer_loc = itemView.findViewById(R.id.loc);
            photographer_lay = itemView.findViewById(R.id.photographer_lay);

        }
    }

    public class Adapter extends RecyclerView.Adapter<view_holder>
    {

        @Override
        public view_holder onCreateViewHolder(ViewGroup parent, int viewType) {

            view_holder v = new view_holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.photographer_cell,parent , false ));

            return v ;
        }

        @Override
        public void onBindViewHolder(view_holder holder, int position) {


            final photographer_details data=photographer_list.get(position);
            holder.photographer_name.setText(data.photographername);
            holder.photographer_loc.setText(data.photographerloc);
            holder.photographer_lay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String photographername=data.photographername;
                    String photographerloc=data.photographerloc;
                    String photographerservice=data.photographerservice;
                    int photographerprice=data.photographerprice;

                    Intent i=new Intent(viewPhotographers.this,viewPhotographerDetails.class);
                    i.putExtra("photographername",photographername);
                    i.putExtra("photographerloc",photographerloc);
                    i.putExtra("photographerservices",photographerservice);
                    i.putExtra("photographerprice",photographerprice);
                    startActivity(i);
                }
            });
        }

        @Override
        public int getItemCount() {
            return photographer_list.size();
        }
    }
}