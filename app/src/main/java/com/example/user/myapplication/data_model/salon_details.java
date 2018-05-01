package com.example.user.myapplication.data_model;

/**
 * Created by user on 12-04-2018.
 */

public class salon_details {
    public String salonname ,salonloc , salonservice;
    public int salonprice;

    public    salon_details()
    {

    }


    public salon_details(String salonname , String salonloc , String salonservice ,int salonprice)

    {
        this.salonname =salonname ;

        this.salonloc  =salonloc ;

        this.salonservice  =salonservice ;

        this.salonprice =salonprice;

    }
}
