package com.example.user.myapplication.data_model;

/**
 * Created by user on 12-04-2018.
 */

public class decorator_detail{

    public String decoratorname , decoratorloc ,  decoratorservice;
    public int decoratorprice;

    public decorator_detail()
    {

    }


    public decorator_detail (String decoratorname , String decoratorloc , String decoratorservice ,int decoratorprice)

    {
        this.decoratorname = decoratorname ;

        this.decoratorloc  = decoratorloc ;

        this.decoratorservice  = decoratorservice ;

        this.decoratorprice = decoratorprice;

    }



}

