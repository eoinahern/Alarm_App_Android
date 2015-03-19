package com.example.eoin_a.alarm_app.Alarm_views;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.eoin_a.alarm_app.Alarm_Controller.App_Created_Listener;
import com.example.eoin_a.alarm_app.Alarm_Controller.List_Controller;
import com.example.eoin_a.alarm_app.Alarm_Model.file_acces_int;
import com.example.eoin_a.alarm_app.Alarm_Model.file_access_model;
import com.example.eoin_a.alarm_app.R;
import com.example.eoin_a.alarm_app.entity_class.alarm_entity;

import java.util.ArrayList;


public class Alarm_List extends ActionBarActivity {




    public static final String filename = "alarms_file";
    public static final String timepickerfrag = "timepickerfrgment";
    private FragmentManager fmanager;
    private NoAlarmFragment noalarmfrag;
    private AlarmListFragment alstfrag;
    private FragmentTransaction ftrans;
    private file_acces_int fileAccess;  //inject ?? allow access to model??
    private ArrayList<alarm_entity> entitylist;
    private App_Created_Listener appcl;

    //too allow view access to the model that is the question?
    //i think in this case i wont allow it to seperate out the code as much as possible



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm__list);

        setOnCreateListener();
        fileAccess = new file_access_model(this);
        fmanager = getFragmentManager();
        ftrans = fmanager.beginTransaction();
        addFragments();

    }


    @Override
    protected void onStop()
    {
       //save all data  to relevant file
        super.onStop();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }

    private void setOnCreateListener()
    {
        //when created get list of alarms etc. from the controller
        appcl = new List_Controller();
     }

    private void addFragments() {

        //create alarm list if alarm list is empty then
        //add different fragments to the UI

        //alstfrag = new AlarmListFragment();
        //ftrans.add(R.id.containeractivity, lstfrag);
        //ftrans.commit();


        if(appcl.getSize() == 0)
        {
            noalarmfrag = new NoAlarmFragment();
            ftrans.add(R.id.containeractivity, noalarmfrag);
            ftrans.commit();
        }
        else
        {

            //add the alarmsfraglst;

        }







    }

    public void addAlarm(View v)
    {
       // Toast.makeText(this, "hello there toast!!!", Toast.LENGTH_LONG).show();
        //show timepicker dialog!!

        DialogFragment addalarmfrag = new TimePickerFragment();
        addalarmfrag.show(fmanager, timepickerfrag);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_alarm__list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
