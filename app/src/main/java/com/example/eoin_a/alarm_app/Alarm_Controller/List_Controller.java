package com.example.eoin_a.alarm_app.Alarm_Controller;

import android.content.Context;
import android.util.Log;

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

    //alarms being created in here arent edited. therefore.
    //these alarms being saved are just saving with booleans
    //all set to false!!! gotcha bitch!!


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
        Log.d("alarm list", "file read!!!");
        Log.d("list size is ", String.valueOf(alarmlst.size()) + " hooray?");

        if(alarmlst.size() > 0) {
            alarm_entity ent = alarmlst.get(0);
            ArrayList<Boolean> lst = ent.getDays();
            for (int i = 0; i < 7; i++) {
                Boolean val = lst.get(i);
                Log.d("alarm " + String.valueOf(i) + "is :", String.valueOf(val));
            }
        }
        //Log.d("alarmlist item mon boolean is set to : " + String.valueOf( alarmlst.get(0).isMon()),"hooray");
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

    public void saveAllAlarms(ArrayList<alarm_entity>  alarmlistin)
    {

        if(alarmlistin.size() > 0) {
            alarm_entity ent = alarmlistin.get(0);
            ArrayList<Boolean> lst = ent.getDays();
            for (int i = 0; i < 7; i++) {
                Boolean val = lst.get(i);
                Log.d("alarm saved " + String.valueOf(i) + "is :", String.valueOf(val));
            }
        }
       fileaccess.writeToFile(alarmlistin);
    }

}
