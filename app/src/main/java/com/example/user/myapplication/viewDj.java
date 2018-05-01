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

import com.example.user.myapplication.data_model.dj_detail;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class viewDj extends AppCompatActivity {
    ArrayList<dj_detail> dj_list;
    RecyclerView dj_recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_dj);
        dj_list = new ArrayList<>();

        dj_recycler = findViewById(R.id.dj_recycler);

        dj_recycler.setLayoutManager(new LinearLayoutManager(viewDj.this , LinearLayoutManager.VERTICAL, false));
    }

    public void skip_dj(View view) {
        user_home.dj_loc="Not Booked";
        user_home.dj_name="Not Booked";
        startActivity( new Intent(viewDj.this , viewPhotographers.class));
    }
    public void get_dj()
    {
        FirebaseAuth firebase = FirebaseAuth.getInstance();

        FirebaseDatabase data =FirebaseDatabase.getInstance();
        System.out.println("rrrr");
        data.getReference().child("dj").addListenerForSingleValueEvent(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dj_list.clear();


                for (DataSnapshot data : dataSnapshot.getChildren())
                {
                    dj_detail details = data.getValue(dj_detail.class);
                    System.out.println("rrrrrr");
                    dj_list.add(details);

                    Adapter adapter = new Adapter();

                    dj_recycler.setAdapter(adapter);
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

        get_dj();
    }

    public class view_holder extends RecyclerView.ViewHolder{

        TextView dj_name,dj_loc ;
        LinearLayout dj_lay;
        public view_holder(View itemView) {
            super(itemView);

            dj_name = itemView.findViewById(R.id.name);
            dj_lay=itemView.findViewById(R.id.dj_lay);
            dj_loc = itemView.findViewById(R.id.loc);
        }
    }

    public class Adapter extends RecyclerView.Adapter<view_holder>
    {

        @Override
        public view_holder onCreateViewHolder(ViewGroup parent, int viewType) {

            view_holder v = new view_holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.dj_cell,parent , false ));

            return v ;
        }

        @Override
        public void onBindViewHolder(view_holder holder, int position) {


            final dj_detail data=dj_list.get(position);
            holder.dj_name.setText(data.djname);
            holder.dj_loc.setText(data.djloc);
            holder.dj_lay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String djname=data.djname;
                    String djloc=data.djloc;
                    String djservice=data.djservice;
                    int djprice=data.djprice;

                    Intent i=new Intent(viewDj.this,viewDjDetails.class);
                    i.putExtra("djname",djname);
                    i.putExtra("djloc",djloc);
                    i.putExtra("djservices",djservice);
                    i.putExtra("djprice",djprice);
                    startActivity(i);
                }
            });
        }

        @Override
        public int getItemCount() {
            return dj_list.size();
        }
    }
}