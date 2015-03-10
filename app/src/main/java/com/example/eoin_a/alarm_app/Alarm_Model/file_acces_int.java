package com.example.eoin_a.alarm_app.Alarm_Model;

import com.example.eoin_a.alarm_app.entity_class.alarm_entity;

import java.util.ArrayList;

/**
 * Created by eoin_a on 01/03/2015.
 */
public interface file_acces_int {

    public void writeToFile(ArrayList<alarm_entity> alarmlist);
    public ArrayList<alarm_entity> readFromFile();


}
