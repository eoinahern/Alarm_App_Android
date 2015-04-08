package com.example.eoin_a.alarm_app.entity_class;

import android.text.format.Time;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;


/**
 * Created by eoin_a on 01/03/2015.
 * alarm will control frequency/ time of alarms / sound played etc
 */
public class alarm_entity implements Serializable {


    private boolean state;
    private int hours;
    private int mins;
    private boolean mon;
    private boolean tue;
    private boolean wed;
    private boolean thur;
    private boolean fri;
    private boolean sat;
    private boolean sun;

    private ArrayList<Boolean> days;

    //need to call calendaer.set() method on alarm. these
    //take ints as arguement. therefore the ints returned from



    public alarm_entity(int hoursin, int minsin)
    {
        state = true;
        hours = hoursin;
        mins = minsin;
        mon = false;
        tue = false;
        wed = false;
        thur = false;
        fri = false;
        sat = false;
        sun = false;

    }

    public boolean isWed() {
        return wed;
    }

    public void setWed(boolean wed) {
        this.wed = wed;
    }

    public boolean isTue() {
        return tue;
    }

    public void setTue(boolean tue) {
        this.tue = tue;
    }

    public boolean isThur() {
        return thur;
    }

    public void setThur(boolean thur) {
        this.thur = thur;
    }

    public boolean isFri() {
        return fri;
    }

    public void setFri(boolean fri) {
        this.fri = fri;
    }

    public boolean isSat() {
        return sat;
    }

    public void setSat(boolean sat) {
        this.sat = sat;
    }

    public boolean isSun() {
        return sun;
    }

    public void setSun(boolean sun) {
        this.sun = sun;
    }

    public boolean isMon() {
        return mon;
    }

    public void setMon(boolean mon) {
        this.mon = mon;
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
