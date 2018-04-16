package com.example.user.myapplication;

/**
 * Created by user on 12-04-2018.
 */

public class photographer_details {
    public String photographername ,photographerloc , photographerservice;
    public int photographerprice;

    photographer_details()
    {

    }


    photographer_details(String photographername , String photographerloc , String photographerservice ,int photographerprice)

    {
        this.photographername =photographername ;

        this.photographerloc  =photographerloc ;

        this.photographerservice  =photographerservice ;

        this.photographerprice =photographerprice;

    }
}
