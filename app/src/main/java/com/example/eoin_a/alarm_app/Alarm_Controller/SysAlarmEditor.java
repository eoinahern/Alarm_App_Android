package com.example.eoin_a.alarm_app.Alarm_Controller;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import com.example.eoin_a.alarm_app.Alarm_views.Alarm_List;
import com.example.eoin_a.alarm_app.Alarm_views.Alarm_Ringing_Activity;
import com.example.eoin_a.alarm_app.entity_class.alarm_entity;
import java.util.Calendar;

/**
 * Created by eoin_a on 27/04/2015.
 */
public class SysAlarmEditor implements SysAlarmEditorInt {

    private Context cont;
    private AlarmManager amanager;


    public SysAlarmEditor(Context contin)
    {
        cont = contin;
        amanager = (AlarmManager) cont.getSystemService(Context.ALARM_SERVICE);
    }


    @Override
    public void checkAlarms(alarm_entity alarm, int index) {

        Log.d("checkAlarms", "checkAlarms called");
        boolean[] myalarmlist = alarm.getDays();

        for(int i = 0; i < myalarmlist.length;i++)
        {
            int piidentifier = (index * 10) + i;
            boolean alstate = myalarmlist[i];
            boolean alarmexists = alarmExists(piidentifier);


            if(alarmexists  && !alstate)
            {
                deleteAlarm(piidentifier);
            }
            else if(!alarmexists && alstate)
            {
                createAlarm(piidentifier,alarm , i);
            }
        }

    }

    @Override
    public boolean alarmExists(int piidentifier) {

        boolean exists;
        exists = (PendingIntent.getActivity(cont, piidentifier,
                new Intent(cont, Alarm_Ringing_Activity.class), PendingIntent.FLAG_NO_CREATE) != null);

        return exists;

    }


    @Override
    public void createAlarm(int piidentifier, alarm_entity alarm, int index) {

        int hours = alarm.getHours();
        int mins = alarm.getMins();

        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.DAY_OF_WEEK, index + 1);
        cal.set(Calendar.HOUR_OF_DAY, hours);
        cal.set(Calendar.MINUTE, mins);

        Long alarmtime = cal.getTimeInMillis();
        Intent intent = new Intent(cont, Alarm_Ringing_Activity.class);
        PendingIntent pint = PendingIntent.getActivity(cont,piidentifier, intent, 0);



        if(checkApiLevel()) {
            amanager.setExact(AlarmManager.RTC_WAKEUP, alarmtime, pint);
        }
        else
        {
            amanager.setRepeating(AlarmManager.RTC_WAKEUP, alarmtime, 7 * 24 * 60 * 60 * 1000, pint);
        }

        Log.d("set on repeating : ", String.valueOf(piidentifier));


    }

    private boolean checkApiLevel()
    {
        //checks api level as seperate
        //comand required to create exact repeating alarm on
        //api levels lower than 19.


        if(Alarm_List.sdkversion >= Build.VERSION_CODES.KITKAT)
        {
            return true;
        }

        return false;
    }

    @Override
    public void deleteAlarm(int piidentifier) {

        Intent intent = new Intent(cont, Alarm_Ringing_Activity.class);
        PendingIntent pendint = PendingIntent.getActivity(cont,piidentifier, intent, 0);
        amanager.cancel(pendint);
        pendint.cancel();
        Log.d("cancelled : ", String.valueOf(piidentifier));

    }

    @Override
    public void deleteAllAlarms(alarm_entity entity, int index) {


        boolean [] days = entity.getDays();

        for(int i = 0; i < days.length; i++)
        {

           int piidentifier = index * 10 + i;
           if(alarmExists(piidentifier))
               deleteAlarm(piidentifier);
        }



    }
}