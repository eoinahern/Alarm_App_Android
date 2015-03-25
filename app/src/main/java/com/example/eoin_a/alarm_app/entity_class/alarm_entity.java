package com.example.eoin_a.alarm_app.entity_class;

import android.text.format.Time;

import java.io.File;
import java.io.Serializable;


/**
 * Created by eoin_a on 01/03/2015.
 * alarm will control frequency/ time of alarms / sound played etc
 */
public class alarm_entity implements Serializable {


    private boolean state;
    private int hours;
    private int mins;



    //need to call calendaer.set() method on alarm. these
    //take ints as arguement. therefore the ints returned from



    public alarm_entity(int hoursin, int minsin)
    {
        state = true;
        hours = hoursin;
        mins = minsin;

    }


    public int getMins()
    {
        return mins;
    }

    public void setMins(int minsin)
    {
        mins = minsin;
    }

    public int getHours()
    {
       return hours;
    }

    public void setHours(int hoursin)
    {
        hours = hoursin;
    }

    public void setState(boolean statein)
    {
        state = statein;
    }

    public boolean getState()
    {
        return state;
    }




}
