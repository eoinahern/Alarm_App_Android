package com.example.eoin_a.alarm_app.entity_class;

import android.text.format.Time;

import java.io.File;


/**
 * Created by eoin_a on 01/03/2015.
 * alarm will control frequency/ time of alarms / sound played etc
 */
public class alarm_entity {


    private Time time;
    private boolean state;
    private File sound;


    public alarm_entity()
    {

    }


    public Time getTime()
    {
        return time;
    }



    public void setTime(Time time)
    {
        time = time;
    }




}
