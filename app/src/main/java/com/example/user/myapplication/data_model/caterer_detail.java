package com.example.user.myapplication.data_model;

/**
 * Created by user on 12-04-2018.
 */

public class caterer_detail {
    public String caterername , catererloc ,  catererservice;
    public int catererprice;

     public caterer_detail ()
    {

    }


    public caterer_detail (String caterername , String catererloc , String catererservice ,int catererprice)

    {
        this.caterername = caterername ;

        this.catererloc  = catererloc ;

        this.catererservice  = catererservice ;

        this.catererprice = catererprice;

    }

}
