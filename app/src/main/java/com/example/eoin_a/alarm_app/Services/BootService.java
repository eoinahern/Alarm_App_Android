package com.example.eoin_a.alarm_app.Services;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.*;
import android.util.Log;
import com.example.eoin_a.alarm_app.Alarm_Model.file_acces_int;
import com.example.eoin_a.alarm_app.Alarm_Model.file_access_model;
import com.example.eoin_a.alarm_app.Alarm_views.Alarm_Ringing_Activity;
import com.example.eoin_a.alarm_app.entity_class.alarm_entity;
import java.util.ArrayList;
import java.util.Calendar;


/**
 * Created by eoin_a on 25/03/2015.
 */
public class BootService extends Service {

   private Thread setallarams;
   private file_acces_int  fileaccess;
   private ArrayList<alarm_entity> alarmlst;
   private Looper mlooper;
   private AlarmManager amanager;

    private Runnable setalarmsrunnable = new Runnable() {
       @Override
       public void run()
       {

           for(int i =0; i < alarmlst.size(); i++)
           {
               CheckAlarms(alarmlst.get(i), i);
           }
       }
   };

    @Override
    public void onCreate()
    {
        fileaccess = new file_access_model(getApplicationContext());
        alarmlst = fileaccess.readFromFile();
        setallarams = new Thread(setalarmsrunnable);
        amanager = (AlarmManager) getBaseContext().getSystemService(Context.ALARM_SERVICE);
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId)  //onPause. create alarms
    {

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

    private void CheckAlarms(alarm_entity alarm, int index)
    {

        ArrayList<Boolean> myalarmlist = alarm.getDays();

        for(int i = 0; i < myalarmlist.size();i++)
        {
            int piidentifier = (index * 10) + i;
            boolean alstate = myalarmlist.get(i);
            boolean alarmexists = alarmExists(piidentifier);


             if(alarmexists  && !alstate)
            {
                deleteAlarm(piidentifier,alarm, i);
            }
            else if(!alarmexists && alstate)
            {
                createAlarm(piidentifier,alarm , i);
            }
        }
    }

    private void createAlarm(int piidentifier, alarm_entity alarm, int index)
    {
        int hours = alarm.getHours();
        int mins = alarm.getMins();

        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.DAY_OF_WEEK, index + 1);
        cal.set(Calendar.HOUR, hours);
        cal.set(Calendar.MINUTE, mins);

        Long alarmtime = cal.getTimeInMillis();
        Intent intent = new Intent(getBaseContext(), Alarm_Ringing_Activity.class);
        PendingIntent pint = PendingIntent.getActivity(getBaseContext(),piidentifier, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        amanager.setRepeating(AlarmManager.RTC_WAKEUP, alarmtime, 7 * 24 * 60 * 60 * 1000, pint);
    }

    private boolean alarmExists(int piidentifier) //checks pending intent created
    {
        boolean exists;

        exists = (PendingIntent.getActivity(getBaseContext(),piidentifier,
                new Intent(getBaseContext(), Alarm_Ringing_Activity.class) , PendingIntent.FLAG_NO_CREATE) != null);

        return exists;
    }


    private void deleteAlarm(int piidentifier, alarm_entity alarm, int index)
    {

        



    }






}
