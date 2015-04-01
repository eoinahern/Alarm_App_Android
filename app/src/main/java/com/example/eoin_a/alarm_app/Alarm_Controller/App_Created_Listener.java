package com.example.eoin_a.alarm_app.Alarm_Controller;

import com.example.eoin_a.alarm_app.entity_class.alarm_entity;

import java.util.ArrayList;

/**
 * Created by eoin_a on 28/02/2015.
 */
public interface App_Created_Listener {


     public  int getSize();
     public void addItems();
     public void addToList(int hours, int mins);
     public ArrayList<alarm_entity> getList();

}
