package com.example.user.myapplication;

/**
 * Created by user on 12-04-2018.
 */

public class designer_detail {
    public String designername ,designerloc , designerservice;
    public int designerprice;

    designer_detail()
    {

    }


    designer_detail(String designername , String designerloc , String designerservice ,int designerprice)

    {
        this.designername =designername ;

        this.designerloc  =designerloc ;

        this.designerservice  =designerservice ;

        this.designerprice =designerprice;

    }
}
