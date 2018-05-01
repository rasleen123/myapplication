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

import com.example.user.myapplication.data_model.designer_detail;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class viewDesigners extends AppCompatActivity {
    ArrayList<designer_detail> designers_list;
    RecyclerView designer_recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_designers);
        designers_list = new ArrayList<>();

        designer_recycler = findViewById(R.id.designer_recycler);

        designer_recycler.setLayoutManager(new LinearLayoutManager(viewDesigners.this , LinearLayoutManager.VERTICAL, false));
    }

    public void skip_designer(View view) {
        user_home.designer_loc="Not Booked";
        user_home.designer_name="Not Booked";
        startActivity( new Intent(viewDesigners.this , viewDj.class));
    }
    public void get_designers()
    {
        FirebaseAuth firebase = FirebaseAuth.getInstance();
        String email=firebase.getCurrentUser().getEmail();
        FirebaseDatabase data =FirebaseDatabase.getInstance();
        System.out.println("rrrr");
        data.getReference().child("designer").addListenerForSingleValueEvent(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                designers_list.clear();


                for (DataSnapshot data : dataSnapshot.getChildren())
                {
                    designer_detail details = data.getValue(designer_detail.class);
                    System.out.println("rrrrrr");
                    designers_list.add(details);

                    Adapter adapter = new Adapter();

                    designer_recycler.setAdapter(adapter);
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

        get_designers();
    }

    public class view_holder extends RecyclerView.ViewHolder{

        TextView designers_name,designers_loc ;
        LinearLayout designer_lay;
        public view_holder(View itemView) {
            super(itemView);

            designers_name = itemView.findViewById(R.id.name);
            designers_loc = itemView.findViewById(R.id.loc);
            designer_lay =itemView.findViewById(R.id.designer_lay);
        }
    }

    public class Adapter extends RecyclerView.Adapter<view_holder>
    {

        @Override
        public view_holder onCreateViewHolder(ViewGroup parent, int viewType) {

            view_holder v = new view_holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.designer_cell,parent , false ));

            return v ;
        }

        @Override
        public void onBindViewHolder(view_holder holder, int position) {


            final designer_detail data=designers_list.get(position);
            holder.designers_name.setText(data.designername);
            holder.designers_loc.setText(data.designerloc);
            holder.designer_lay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String designername = data.designername;
                    String designerloc = data.designerloc;
                    String designerservice = data.designerservice;
                    int designerprice = data.designerprice;

                    Intent i = new Intent(viewDesigners.this, viewDesignerDetails.class);
                    i.putExtra("designername", designername);
                    i.putExtra("designerloc", designerloc);
                    i.putExtra("designerservices", designerservice);
                    i.putExtra("designerprice", designerprice);
                    startActivity(i);
                }
            });
        }

        @Override
        public int getItemCount() {
            return designers_list.size();
        }
    }
}