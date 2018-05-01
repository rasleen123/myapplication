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

import com.example.user.myapplication.data_model.salon_details;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class addSalon extends AppCompatActivity {
    ArrayList<salon_details> Salon_list;
    RecyclerView Salon_recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_salon);
        Salon_list = new ArrayList<>();

        Salon_recycler = findViewById(R.id.Salon_recycler);

        Salon_recycler.setLayoutManager(new LinearLayoutManager(addSalon.this , LinearLayoutManager.VERTICAL, false));
    }

    public void add_Salon_Details(View view) {

        startActivity( new Intent(addSalon.this , salonDetails.class));
    }
    public void get_Salon()
    {
        FirebaseAuth firebase = FirebaseAuth.getInstance();
      
        FirebaseDatabase data =FirebaseDatabase.getInstance();
        System.out.println("rrrr");
        data.getReference().child("salon").addListenerForSingleValueEvent(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Salon_list.clear();


                for (DataSnapshot data : dataSnapshot.getChildren())
                {
                    salon_details details = data.getValue(salon_details.class);
                    System.out.println("rrrrrr");
                    Salon_list.add(details);

                    Adapter adapter = new Adapter();

                    Salon_recycler.setAdapter(adapter);
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

        get_Salon();
    }

    public class view_holder extends RecyclerView.ViewHolder{

        TextView Salon_name,Salon_loc ;
LinearLayout salon_lay;
        public view_holder(View itemView) {
            super(itemView);

            Salon_name = itemView.findViewById(R.id.name);
            salon_lay = itemView.findViewById(R.id.salon_lay);
            Salon_loc = itemView.findViewById(R.id.loc);
        }
    }

    public class Adapter extends RecyclerView.Adapter<view_holder>
    {

        @Override
        public view_holder onCreateViewHolder(ViewGroup parent, int viewType) {

            view_holder v = new view_holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.salon_cell,parent , false ));

            return v ;
        }

        @Override
        public void onBindViewHolder(view_holder holder, int position) {


            final salon_details data=Salon_list.get(position);
            holder.Salon_name.setText(data.salonname);
            holder.Salon_loc.setText(data.salonloc);
            holder.salon_lay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String salonname=data.salonname;
                    String salonloc=data.salonloc;
                    String salonservice=data.salonservice;
                    int salonprice=data.salonprice;

                    Intent i=new Intent(addSalon.this,updatesalon.class);
                    i.putExtra("salonname",salonname);
                    i.putExtra("salonloc",salonloc);
                    i.putExtra("salonservices",salonservice);
                    i.putExtra("salonprice",salonprice);
                    startActivity(i);
                }
            });
        }

        @Override
        public int getItemCount() {
            return Salon_list.size();
        }
    }
}