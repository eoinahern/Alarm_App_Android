package com.example.eoin_a.alarm_app;

import android.app.Application;

/**
 * Created by eoin_a on 26/03/2015.
 */
public class MyApp extends Application {

    private static MyApp instance;

    public MyApp()
    {
        instance = this;
    }



    public static MyApp getInstance()
    {
        return instance;
    }

}
