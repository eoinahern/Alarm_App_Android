package com.example.eoin_a.alarm_app.Alarm_Controller;

import android.content.Context;

import com.example.eoin_a.alarm_app.Alarm_Model.file_acces_int;
import com.example.eoin_a.alarm_app.Alarm_Model.file_access_model;
import com.example.eoin_a.alarm_app.MyApp;
import com.example.eoin_a.alarm_app.entity_class.alarm_entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eoin_a on 19/03/2015.
 */
public class List_Controller implements App_Created_Listener {


    private ArrayList<alarm_entity> alarmlst;
    private file_acces_int fileaccess;
    private Context cont;
    private  static List_Controller instance;


    public static List_Controller getInstance() {

        if(instance == null)
        {
            instance = new List_Controller();
            return instance;
        }

        return instance;
    }

    private List_Controller()
    {
        cont = MyApp.getInstance();
        fileaccess = new file_access_model(cont);
    }

    public void addItems()
    {
        alarmlst = fileaccess.readFromFile();
    }

    public int getSize()
    {
        return alarmlst.size();
    }

    public ArrayList<alarm_entity> getList()
    {
        return alarmlst;
    }

    public void addToList(int hours, int mins)
    {
        alarm_entity ent = new alarm_entity(hours, mins);
        alarmlst.add(ent);
    }





    public void createSysAlarm(alarm_entity alarm)
    {

        //make a SYSTEM  alarm rather from alarm entity




    }



}
