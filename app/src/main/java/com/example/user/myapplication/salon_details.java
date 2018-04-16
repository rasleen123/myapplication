package com.example.user.myapplication;

/**
 * Created by user on 12-04-2018.
 */

public class salon_details {
    public String salonname ,salonloc , salonservice;
    public int salonprice;

    salon_details()
    {

    }


    salon_details(String salonname , String salonloc , String salonservice ,int salonprice)

    {
        this.salonname =salonname ;

        this.salonloc  =salonloc ;

        this.salonservice  =salonservice ;

        this.salonprice =salonprice;

    }
}
