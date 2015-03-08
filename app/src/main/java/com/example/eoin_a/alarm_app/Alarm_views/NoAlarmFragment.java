package com.example.eoin_a.alarm_app.Alarm_views;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.eoin_a.alarm_app.R;

/**
 * Created by eoin_a on 08/03/2015.
 */
public class NoAlarmFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
    {

        //create the alarm list in here from the model.
        //view could  also have direct access to the to avoid just "wrapping" the model class.

        return inflater.inflate(R.layout.fragment_list,container, false);
    }









}
