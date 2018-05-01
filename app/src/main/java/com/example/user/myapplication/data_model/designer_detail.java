package com.example.user.myapplication.data_model;

/**
 * Created by user on 12-04-2018.
 */

public class designer_detail {
    public String designername ,designerloc , designerservice;
    public int designerprice;

    public designer_detail()
    {

    }


    public designer_detail(String designername , String designerloc , String designerservice ,int designerprice)

    {
        this.designername =designername ;

        this.designerloc  =designerloc ;

        this.designerservice  =designerservice ;

        this.designerprice =designerprice;

    }
}
