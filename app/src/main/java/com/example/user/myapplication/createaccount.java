package com.example.user.myapplication;

import android.icu.text.StringPrepParseException;

/**
 * Created by user on 24-04-2018.
 */
public class createaccount {
    public String name,number,email,password;

    createaccount()
    {

    }

    public createaccount(String name, String number, String email,String password)

    {
        this.name = name;
        this.password=password;
        this.number=number;
        this.email=email;

    }
}