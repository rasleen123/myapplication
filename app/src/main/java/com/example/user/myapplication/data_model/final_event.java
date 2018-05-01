package com.example.user.myapplication.data_model;

/**
 * Created by user on 12-04-2018.
 */

public class final_event{
    public String dj_name , venue_loc,venue_name , dj_loc,decorater_name,decorater_loc,designer_name,designer_loc,photographer_name,photographer_loc,
            salon_name,salon_loc,caterer_name,caterer_loc;
public Long time;
    public final_event ()
    {

    }


    public final_event (Long time,String dj_name ,String venue_loc,String venue_name ,String dj_loc,String decorater_name,String decorater_loc,String designer_name,String designer_loc,String photographer_name,String photographer_loc,
                 String salon_name,String salon_loc,String caterer_name,String caterer_loc)

    {
        this.time=time;
        this.dj_name=dj_name;
        this.dj_loc=dj_loc;
        this.caterer_name= caterer_name;
        this.caterer_loc  = caterer_loc ;
        this.venue_name= venue_name;
        this.venue_loc  = venue_loc ;
        this.designer_name= designer_name;
        this.designer_loc  = designer_loc ;
        this.decorater_name= decorater_name;
        this.decorater_loc  = decorater_loc ;
        this.salon_name= salon_name;
        this.salon_loc  = salon_loc ;
        this.photographer_name= photographer_name;
        this.photographer_loc  = photographer_loc ;

    }

}
