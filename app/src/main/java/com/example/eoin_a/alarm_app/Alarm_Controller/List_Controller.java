package com.example.eoin_a.alarm_app.Alarm_Controller;

import com.example.eoin_a.alarm_app.entity_class.alarm_entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eoin_a on 19/03/2015.
 */
public class List_Controller implements App_Created_Listener {

    //this has access to the model classes

    private ArrayList<alarm_entity> alarmlst;


    public List_Controller()
    {
        //make the list

        alarmlst = new ArrayList<alarm_entity>();

    }

    public void addItems()
    {

    }

    public int getSize()
    {
        return alarmlst.size();
    }

    public ArrayList<alarm_entity> getList()
    {
        return alarmlst;
    }



    public void createSysAlarm(alarm_entity alarm)
    {

        //make a SYSTEM  alarm rather from alarm entity

    }



}
