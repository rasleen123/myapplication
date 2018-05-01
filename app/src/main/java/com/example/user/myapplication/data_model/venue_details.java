package com.example.user.myapplication.data_model;

/**
 * Created by user on 12-04-2018.
 */

public class venue_details {

        public String venuename , venue_loc ,  service1,service2,service3 ;
    public int price, capacity;

    public venue_details ()
        {

        }


    public venue_details (String venuename , String venue_loc , String service1 ,String service2, String service3, int price,int capacity)

        {
            this.venuename = venuename ;

            this.venue_loc  = venue_loc ;

            this.service1  = service1 ;
            this.service2  = service2 ;
            this.service3  = service3 ;
            this.price = price;
            this.capacity = capacity;
        }



    }

