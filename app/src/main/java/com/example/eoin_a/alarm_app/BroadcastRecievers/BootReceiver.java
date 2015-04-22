package com.example.eoin_a.alarm_app.BroadcastRecievers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.eoin_a.alarm_app.Services.BootService;

/**
 * Created by eoin_a on 25/03/2015.
 */
public class BootReceiver extends BroadcastReceiver {



    @Override
    public void onReceive(Context context, Intent intent)
    {
        //here we want to load in actual system alarms and get them to
        //play sound and open Alarm_Ringing_Activity at recorded time


        Intent i = new Intent(context, BootService.class);
        context.startService(i);
    }
}
