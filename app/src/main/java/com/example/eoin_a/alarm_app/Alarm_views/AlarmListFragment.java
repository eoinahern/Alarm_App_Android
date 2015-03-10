package com.example.eoin_a.alarm_app.Alarm_views;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.eoin_a.alarm_app.R;
/**
 * Created by eoin_a on 28/02/2015.
 */
public class AlarmListFragment extends ListFragment {


         //view can access model so can instatiate a version of the model
         //controller Listens to the view

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
        {

            //create the alarm list in here from the model.
            //view could  also have direct access to the to avoid just "wrapping" the model class.

            return inflater.inflate(R.layout.fragment_list,container, false);
        }

        @Override
        public void onStop()
        {
            // save all alarmsfrom list to file



        }


















}
