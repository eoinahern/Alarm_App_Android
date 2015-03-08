package com.example.eoin_a.alarm_app.Alarm_views;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.eoin_a.alarm_app.Alarm_Model.file_acces_int;
import com.example.eoin_a.alarm_app.Alarm_Model.file_access_model;
import com.example.eoin_a.alarm_app.R;


public class Alarm_List extends ActionBarActivity {




    public static final String filename = "alarms_file";
    private FragmentManager fmanager;
    private NoAlarmFragment noalarmfra;
    private AlarmListFragment alstfrag;
    private FragmentTransaction ftrans;
    //private file_acces_int fileAccess;   do you put this in the fragment or the activity??


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm__list);

        //create al the alarms and add them to the listview in the fragment
        //maybe check if any alarms created also


        setOnCreateListener();
        //fileAccess = new file_access_model();  //this will  be injectable at a later date. learn Dagger!




        fmanager = getFragmentManager();
        ftrans = fmanager.beginTransaction();
        addFragments();






    }

    private void setOnCreateListener() {

        //when created get list of alarms etc. from the controller

    }

    private void addFragments() {

        //create alarm list if alarm list is empty then
        //add different fragments to the UI

        //alstfrag = new AlarmListFragment();
        //ftrans.add(R.id.containeractivity, lstfrag);
        //ftrans.commit();








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
