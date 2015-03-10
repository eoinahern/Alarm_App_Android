package com.example.eoin_a.alarm_app.Unit_Tests;


import android.content.Context;
import android.test.AndroidTestCase;
import android.test.InstrumentationTestCase;
import android.test.IsolatedContext;
import android.text.format.Time;

import com.example.eoin_a.alarm_app.Alarm_Model.file_access_model;
import com.example.eoin_a.alarm_app.Alarm_views.Alarm_List;
import com.example.eoin_a.alarm_app.entity_class.alarm_entity;

import java.util.ArrayList;

/**
 * Created by eoin_a on 08/03/2015.
 */
public class file_access_model_tests extends AndroidTestCase{



    private Alarm_List allist;
    private file_access_model famodel;
    private ArrayList<alarm_entity> alarmlst;

    public void setUp()
    {
        allist = new Alarm_List();
        famodel = new file_access_model(allist);

        alarmlst = new ArrayList<alarm_entity>();
        //alarm_entity ent1 = new alarm_entity(,false);
        //alarm_entity ent2 = new alarm_entity(,true);


    }


    public void testWriteRead()
    {
        //test if data created in our setup method is equal when we
        //write in then read back 2 asserts should do the trick?

        assertTrue(true);
        assertTrue(true);


    }

}
