package com.example.eoin_a.alarm_app.Alarm_views;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.eoin_a.alarm_app.Adapters.Alarm_Adapter;
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
    private App_Created_Listener appcl;
    private Alarm_Adapter mAdater;
    private   ArrayList<alarm_entity> alarmlst;

    //too allow view access to the model that is the question?
    //i think in this case i wont allow it to seperate out the code as much as possible
    //on device startup create alarms.
    //when app starts alarms are already created. so just create gui elements that can manipulate
    // alarm settings.
    //on app running. create alarm fully



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm__list);

        setOnCreateListener();
        fmanager = getFragmentManager();
        addFragments();

    }

    @Override
    public void onPause()
    {


        appcl.saveAllAlarms(alarmlst);
        Log.d("save alarms", "save alarms onPause");
        super.onPause();
    }


    @Override
    protected void onStop()
    {
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
        appcl =  List_Controller.getInstance();
        appcl.addItems();
        alarmlst = appcl.getList();

    }

    public void itemCreadtedListener(int hours, int mins)
    {
        //something being done on creation off alarm list
        //to reset day checkboxes  everytime a new alarm
        // is added

        if(appcl.getSize() == 0)
        {
            appcl.addToList(hours,mins);
            fmanager.popBackStack();
            Log.i("Item added", "item added itemcreatedlistener");
            addFragments();
            return;
        }

        appcl.addToList(hours,mins);
        alarmlst = appcl.getList();
        mAdater.notifyDataSetChanged();
    }


    private void addFragments() {

        //create alarm list if alarm list is empty then
        //add different fragments to the UI
        FragmentTransaction ftrans = fmanager.beginTransaction();

        if(appcl.getSize() == 0)
        {
            noalarmfrag = new NoAlarmFragment();
            ftrans.replace(R.id.containeractivity, noalarmfrag);
            ftrans.commit();
        }
        else
        {

            mAdater = new Alarm_Adapter(this,alarmlst);
            alstfrag = new AlarmListFragment();
            alstfrag.setListAdapter(mAdater);

            ftrans.replace(R.id.containeractivity, alstfrag);
            ftrans.commit();

        }
    }

    public void addAlarm(View v)
    {
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
