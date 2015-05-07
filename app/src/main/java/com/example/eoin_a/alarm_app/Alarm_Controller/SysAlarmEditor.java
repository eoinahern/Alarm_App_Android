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
    public static String extrahour = "extrahour";
    public static String extraminutes = "extraminutes";
    public static String extrapiident = "extrapiident";
    public static String extraindex = "extraindex";


    //may pass a sound ffom alarm entity in future. if
    //we allow user select from a number of alarm sounds

    public SysAlarmEditor(Context contin)
    {
        cont = contin;
        amanager = (AlarmManager) cont.getSystemService(Context.ALARM_SERVICE);
    }


    @Override
    public void checkAlarms(boolean [] myalarmlist,int hours,int days, int index) {

        Log.d("checkAlarms", "checkAlarms called");


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
                createAlarm(piidentifier, hours,days , i);
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
    public void createAlarm(int piidentifier, int hours, int mins, int index) {

        //int hours = alarm.getHours();
        //int mins = alarm.getMins();

        Long alarmtime = createTime(hours,mins,index);
        Intent intent = new Intent(cont, Alarm_Ringing_Activity.class);
        PendingIntent pint = PendingIntent.getActivity(cont,piidentifier, intent, 0);

        if(checkApiLevel()) {

            intent.putExtra(extrahour, hours);
            intent.putExtra(extraminutes, mins);
            intent.putExtra(extrapiident, piidentifier);
            intent.putExtra(extraindex, index);
            amanager.setExact(AlarmManager.RTC_WAKEUP, alarmtime, pint);
        }
        else
        {
            amanager.setRepeating(AlarmManager.RTC_WAKEUP, alarmtime, 7 * 24 * 60 * 60 * 1000, pint);
        }

        Log.d("set on repeating : ", String.valueOf(piidentifier));
    }


    private Long createTime(int hours, int mins, int index)
    {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, index + 1);
        cal.set(Calendar.HOUR_OF_DAY, hours);
        cal.set(Calendar.MINUTE, mins);

        return cal.getTimeInMillis();
    }

    private boolean checkApiLevel()
    {
        //checks api level as seperate
        //comand required to create exact repeating alarm on
        //api levels lower than 19.


        if(Alarm_List.sdkversion >= Build.VERSION_CODES.KITKAT)
        {
            Log.d("api level", "build version kitkat and above");
            return true;
        }
        Log.d("api level", "build version  < kitkat ");
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
    public void deleteAllAlarms(boolean [] days, int index) {

        //boolean [] days = entity.getDays();

        for(int i = 0; i < days.length; i++)
        {
           int piidentifier = index * 10 + i;
           if(alarmExists(piidentifier))
               deleteAlarm(piidentifier);
        }
     }
}
