package com.example.eoin_a.alarm_app.Services;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.example.eoin_a.alarm_app.Alarm_Model.file_acces_int;
import com.example.eoin_a.alarm_app.Alarm_Model.file_access_model;
import com.example.eoin_a.alarm_app.entity_class.alarm_entity;

import java.util.ArrayList;

/**
 * Created by eoin_a on 25/03/2015.
 */
public class BootService extends Service {

   private Thread setallarams;
   private file_acces_int  fileaccess;
   private ArrayList<alarm_entity> alarmlst;


   private Runnable setalarmsrunnable = new Runnable() {
       @Override
       public void run() {

           for(alarm_entity alarm : alarmlst)
           {
               //set each alarm based on attributes of
               //each alarm entity



           }
       }
   };

    @Override
    public void onCreate()
    {
        //setup data for service

        fileaccess = new file_access_model(getApplicationContext());
        alarmlst = fileaccess.readFromFile();
        setallarams = new Thread(setalarmsrunnable);
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        //called on main thread be wide!!!

        Log.d("BootService", "Service started");

        setallarams.start();

        try {
            setallarams.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stopSelf();
        return START_STICKY;

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
