package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.user.myapplication.data_model.caterer_detail;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class addCaterers extends AppCompatActivity {
    ArrayList<caterer_detail> caterer_list;
    RecyclerView caterer_recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_caterers);
        caterer_list = new ArrayList<>();

        caterer_recycler = findViewById(R.id.caterers_recycler);

        caterer_recycler.setLayoutManager(new LinearLayoutManager(addCaterers.this , LinearLayoutManager.VERTICAL, false));
    }

    public void add_caterer_Details(View view) {

        startActivity( new Intent(addCaterers.this , catererDetails.class));
    }
    public void get_caterer()
    {
        FirebaseAuth firebase = FirebaseAuth.getInstance();
        FirebaseDatabase data =FirebaseDatabase.getInstance();
        System.out.println("rrrr");
        data.getReference().child("caterer").addListenerForSingleValueEvent(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                caterer_list.clear();


                for (DataSnapshot data : dataSnapshot.getChildren())
                {
                    caterer_detail details = data.getValue(caterer_detail.class);
                    System.out.println("rrrrrr");
                    caterer_list.add(details);
                    int listSize = caterer_list.size();

                    for (int i = 0; i<listSize; i++){
                        Log.i("Member name: ", String.valueOf(caterer_list.get(i)));
                    }
                    Adapter adapter = new Adapter();

                    caterer_recycler.setAdapter(adapter);
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

        get_caterer();
    }

    public class view_holder extends RecyclerView.ViewHolder{

        TextView caterer_name,caterer_loc ;
        LinearLayout caterer_lay;
        public view_holder(View itemView) {
            super(itemView);

            caterer_name = itemView.findViewById(R.id.name);
            caterer_lay=itemView.findViewById(R.id.caterer_lay);
            caterer_loc = itemView.findViewById(R.id.loc);
        }
    }

    public class Adapter extends RecyclerView.Adapter<view_holder>
    {

        @Override
        public view_holder onCreateViewHolder(ViewGroup parent, int viewType) {

            view_holder v = new view_holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.caterer_cell,parent , false ));

            return v ;
        }

        @Override
        public void onBindViewHolder(view_holder holder, int position) {


            final caterer_detail data=caterer_list.get(position);
            holder.caterer_name.setText(data.caterername);
            holder.caterer_loc.setText(data.catererloc);
            holder.caterer_lay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String caterername=data.caterername;
                    String catererloc=data.catererloc;
                    String catererservice=data.catererservice;
                    int catererprice=data.catererprice;
                    Intent i=new Intent(addCaterers.this,updatecaterer.class);
                    i.putExtra("caterername",caterername);
                    i.putExtra("catererloc",catererloc);
                    i.putExtra("catererservices",catererservice);
                    i.putExtra("catererprice",catererprice);
                    startActivity(i);
                }
            });
        }

        @Override
        public int getItemCount() {
            return caterer_list.size();
        }
    }
}