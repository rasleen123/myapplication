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

import com.example.user.myapplication.data_model.final_event;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class admin_booked_list extends AppCompatActivity {

    ArrayList<final_event> book_list;
    RecyclerView book_recycle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_booked_list);
        book_list = new ArrayList<>();

        book_recycle = findViewById(R.id.book_recycle);

        book_recycle.setLayoutManager(new LinearLayoutManager(admin_booked_list.this , LinearLayoutManager.VERTICAL, false));
    }

    public void get_booked_list()
    {
        FirebaseAuth firebase = FirebaseAuth.getInstance();
        String email=firebase.getCurrentUser().getEmail().replace(".","");
        FirebaseDatabase data =FirebaseDatabase.getInstance();
        System.out.println("rrrr");
        data.getReference().child("Booked event").addListenerForSingleValueEvent(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                book_list.clear();


                for (DataSnapshot data : dataSnapshot.getChildren())
                {
                    for (DataSnapshot data2 : dataSnapshot.getChildren()) {
                        final_event details = data2.getValue(final_event.class);
                        System.out.println("rrrrrr");
                        book_list.add(details);

                        admin_booked_list.Adapter adapter = new admin_booked_list.Adapter();

                        book_recycle.setAdapter(adapter);
                    }
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

        get_booked_list();
    }

    public class view_holder extends RecyclerView.ViewHolder{

        TextView book_date;
        LinearLayout book_lay;
        public view_holder(View itemView) {
            super(itemView);

            book_lay = itemView.findViewById(R.id.book_lay);
            book_date=itemView.findViewById(R.id.book_date);

        }
    }

    public class Adapter extends RecyclerView.Adapter<admin_booked_list.view_holder>
    {

        @Override
        public admin_booked_list.view_holder onCreateViewHolder(ViewGroup parent, int viewType) {

            admin_booked_list.view_holder v = new admin_booked_list.view_holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.date_cell,parent , false ));

            return  v ;
        }



        @Override
        public void onBindViewHolder(admin_booked_list.view_holder holder, int position) {


            final final_event data=book_list.get(position);
            holder.book_date.setText(String.valueOf(data.time));
            holder.book_lay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String date =String.valueOf(data.time);
                    String dj_name =data.dj_name;
                    String venue_loc=data.venue_loc;
                    String venue_name=data.venue_name;
                    String dj_loc=data.dj_loc;
                    String decorater_name=data.decorater_name;
                    String decorater_loc=data.decorater_loc;
                    String designer_name=data.designer_name;
                    String designer_loc=data.designer_loc;
                    String photographer_name=data.photographer_name;
                    String photographer_loc=data.photographer_loc;
                    String salon_name=data.salon_name;
                    String salon_loc=data.salon_loc;
                    String caterer_name=data.caterer_name;
                    String caterer_loc=data.caterer_loc;
                    Intent i = new Intent(admin_booked_list.this,admin_view_book_event.class);
                    i.putExtra("venue",venue_name+venue_loc);
                    i.putExtra("date",date);
                    i.putExtra("dj",dj_name+dj_loc);
                    i.putExtra("designer",designer_name+designer_loc);
                    i.putExtra("decorater",decorater_name+decorater_loc);
                    i.putExtra("salon",salon_name+salon_loc);
                    i.putExtra("caterer",caterer_name+caterer_loc);
                    i.putExtra("photographer",photographer_name+photographer_loc);
                    startActivity(i);

                }
            });
        }

        @Override
        public int getItemCount() {
            return book_list.size();
        }
    }
}
