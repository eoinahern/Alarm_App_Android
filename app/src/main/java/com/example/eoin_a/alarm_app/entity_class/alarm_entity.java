package com.example.eoin_a.alarm_app.entity_class;

import android.content.Context;
import android.content.Intent;
import android.text.format.Time;
import android.util.Log;
import android.widget.Toast;

import com.example.eoin_a.alarm_app.Alarm_views.Alarm_Ringing_Activity;
import com.example.eoin_a.alarm_app.MyApp;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;


/**
 * Created by eoin_a on 01/03/2015.
 * alarm will control frequency/ time of alarms / sound played etc
 */
public class alarm_entity implements Serializable {


    private boolean state;
    private boolean repeating;
    private int hours;
    private int mins;
    private volatile boolean [] days;
    private final int numdays = 7;



     public alarm_entity(int hoursin, int minsin)
    {


        days = new boolean[numdays];
        state = true;
        repeating = false;
        hours = hoursin;
        mins = minsin;
        initDays();
    }


    private void initDays()
    {
        for(int i = 0 ; i < numdays; i++)
        {
            boolean temp = false;
            days[i] = temp;
        }
    }

    public void setDay(int pos, boolean state)
    {
        days[pos] = state;
    }

    public boolean[] getDays()
    {
       return days;
    }




    public int getMins()
    {
        return mins;
    }

    public void setMins(int minsin)
    {
        mins = minsin;
    }

    public boolean isState() {
        return state;
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
