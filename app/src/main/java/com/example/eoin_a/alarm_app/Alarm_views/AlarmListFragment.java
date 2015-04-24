package com.example.eoin_a.alarm_app.Alarm_views;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.eoin_a.alarm_app.Adapters.Alarm_Adapter;
import com.example.eoin_a.alarm_app.Alarm_Controller.App_Created_Listener;
import com.example.eoin_a.alarm_app.Alarm_Controller.List_Controller;
import com.example.eoin_a.alarm_app.R;
/**
 * Created by eoin_a on 28/02/2015.
 */
public class AlarmListFragment extends ListFragment{


         //view can access model so can instatiate a version of the model
         //controller Listens to the view

        private Alarm_Adapter mAdapter;
        private App_Created_Listener appcl;  //inject when learn dagger. allows us to maitain a singleton


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
        {
            View view = inflater.inflate(R.layout.fragment_list, container, false);
            return view;
        }


        @Override
        public void onStop()
        {

            Log.d("alarm frag", "alarmlistfragment onStop called");
            super.onStop();
        }


















}
