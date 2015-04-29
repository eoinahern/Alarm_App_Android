package com.example.eoin_a.alarm_app.Alarm_Controller;

import com.example.eoin_a.alarm_app.entity_class.alarm_entity;

/**
 * Created by eoin_a on 27/04/2015.
 */
public interface SysAlarmEditorInt {

    public void checkAlarms(boolean [] myarraylist, int hours, int mins, int index);
    public boolean alarmExists(int piidentifier);
    public void createAlarm(int piidentifier, int hours, int mins, int index);
    public void deleteAlarm(int piidentifier);
    public void deleteAllAlarms(boolean [] days, int index);

}
