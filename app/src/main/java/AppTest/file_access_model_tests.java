package AppTest;


import android.test.ActivityInstrumentationTestCase2;
import android.text.format.Time;
import android.util.Log;

import com.example.eoin_a.alarm_app.Alarm_Model.file_access_model;
import com.example.eoin_a.alarm_app.Alarm_views.Alarm_List;
import com.example.eoin_a.alarm_app.entity_class.alarm_entity;

import java.util.ArrayList;

/**
 * Created by eoin_a on 08/03/2015.
 */
public class file_access_model_tests extends ActivityInstrumentationTestCase2<Alarm_List>{



    private Alarm_List allist;
    private file_access_model famodel;
    private ArrayList<alarm_entity> alarmlst;


    public file_access_model_tests()
    {
        super(Alarm_List.class);
    }

    @Override
    public void setUp()
    {
        allist = getActivity();

        famodel = new file_access_model(allist);

        alarmlst = new ArrayList<alarm_entity>();

        Time t1 = new Time();
        Time t2 = new Time();
        t1.setToNow();
        t2.setToNow();

        alarm_entity ent1 = new alarm_entity(t1,false);
        alarm_entity ent2 = new alarm_entity(t2,true);

        alarmlst.add(ent1);
        alarmlst.add(ent2);


        Log.d("size of arraylst" ,String.valueOf(alarmlst.size()));



    }


    public void testWriteRead()
    {
        int init_size = famodel.readFromFile().size();
        famodel.writeToFile(alarmlst);
        int after_size = famodel.readFromFile().size();
        Log.d("size of arraylst" ,String.valueOf(alarmlst.size()));

        assertEquals(init_size + 2, after_size);
    }


    public void testStuff()
    {
        assertEquals(true, true);
    }


    @Override
    public void tearDown()
    {
        allist.finish();
    }

}
