package com.example.eoin_a.alarm_app.Alarm_Model;

import com.example.eoin_a.alarm_app.Alarm_views.Alarm_List;
import com.example.eoin_a.alarm_app.entity_class.alarm_entity;

import java.util.ArrayList;

/**
 * Created by eoin_a on 01/03/2015.
 */
public class file_access_model implements file_acces_int {

    //this class is used to read/write alarm info to a file

    private ArrayList<alarm_entity> alarmlst;


    /*public file_access_model(ArrayList<alarm_entity> alarmlist)
    {
        alarmlst = alarmlst;
    }*/

    // may not need constructor. just perform opeation depending on existence of file


    @Override
    public void readToFile() {

        if(!checkFile(Alarm_List.filename))
            createFile();


    }

    @Override
    public void readFromFile() {

        if(!checkFile(Alarm_List.filename))
            createFile();


    }


    private boolean checkFile(String filename) {
        return false;
    }


    private void createFile()
    {
        //make the file

    }
}
