package com.example.eoin_a.alarm_app.entity_class;

import android.text.format.Time;

import java.io.File;
import java.io.Serializable;


/**
 * Created by eoin_a on 01/03/2015.
 * alarm will control frequency/ time of alarms / sound played etc
 */
public class alarm_entity implements Serializable {


    private Time time;
    private boolean state;


    public alarm_entity(Time timein, boolean statein)
    {
        state = statein;
        time = timein;
    }


    public Time getTime()
    {
        return time;
    }

    public void setTime(Time time)
    {
        time = time;
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
