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

import com.example.user.myapplication.data_model.decorator_detail;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class addDecoraters extends AppCompatActivity {
    ArrayList<decorator_detail> decorater_list;
    RecyclerView decorater_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_decoraters);
        decorater_list = new ArrayList<>();

        decorater_recycler = findViewById(R.id.decoraters_recycler);

        decorater_recycler.setLayoutManager(new LinearLayoutManager(addDecoraters.this, LinearLayoutManager.VERTICAL, false));
    }

    public void add_decorator(View view) {

        startActivity(new Intent(addDecoraters.this, decoraterDetails.class));
    }

    public void get_decorater() {
        FirebaseAuth firebase = FirebaseAuth.getInstance();
        String email = firebase.getCurrentUser().getEmail();
        FirebaseDatabase data = FirebaseDatabase.getInstance();
        System.out.println("rrrr");
        data.getReference().child("decorater").addListenerForSingleValueEvent(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                decorater_list.clear();


                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    decorator_detail details = data.getValue(decorator_detail.class);
                    System.out.println("rrrrrr");
                    decorater_list.add(details);

                    Adapter adapter = new Adapter();

                    decorater_recycler.setAdapter(adapter);
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

        get_decorater();
    }

    public class view_holder extends RecyclerView.ViewHolder {

        TextView decorater_name, decorater_loc;
        LinearLayout decorater_lay;

        public view_holder(View itemView) {
            super(itemView);

            decorater_name = itemView.findViewById(R.id.name);
            decorater_loc = itemView.findViewById(R.id.loc);
            decorater_lay = itemView.findViewById(R.id.decorater_lay);
        }
    }

    public class Adapter extends RecyclerView.Adapter<view_holder> {

        @Override
        public view_holder onCreateViewHolder(ViewGroup parent, int viewType) {

            view_holder v = new view_holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.decoraters_cell, parent, false));

            return v;
        }

        @Override
        public void onBindViewHolder(view_holder holder, int position) {

            final decorator_detail data = decorater_list.get(position);
            holder.decorater_name.setText(data.decoratorname);
            holder.decorater_loc.setText(data.decoratorloc);
            holder.decorater_lay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String decoratername = data.decoratorname;
                    String decoraterloc = data.decoratorloc;
                    String decoraterservice = data.decoratorservice;
                    int decoraterprice = data.decoratorprice;

                    Intent i = new Intent(addDecoraters.this, updatedecorater.class);
                    i.putExtra("decoratername", decoratername);
                    i.putExtra("decoraterloc", decoraterloc);
                    i.putExtra("decoraterservices", decoraterservice);
                    i.putExtra("decoraterprice", decoraterprice);
                    startActivity(i);
                }
            });
        }
                @Override
                public int getItemCount() {
                    return decorater_list.size();
                }


        }
    }

