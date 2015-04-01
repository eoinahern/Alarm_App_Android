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


    private final String testfile = "test_alarm_file";
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
        famodel.createFile(testfile);

        alarmlst = new ArrayList<alarm_entity>();

        int hours1 = 8;
        int mins1 = 15;

        int hours2 = 9;
        int mins2 = 10;


        alarm_entity ent1 = new alarm_entity(hours1,mins1);
        alarm_entity ent2 = new alarm_entity(hours2, mins2);

        alarmlst.add(ent1);
        alarmlst.add(ent2);
    }


    public void testWriteRead()
    {
        int init_size = famodel.readFromFile().size();
        famodel.writeToFile(alarmlst);
        int after_size = famodel.readFromFile().size();
        Log.d("size of arraylst after" ,String.valueOf(alarmlst.size()));

        assertEquals(init_size + 2, after_size);

    }



    public void testobjvars()
    {
        famodel.createFile(testfile);
        famodel.writeToFile(alarmlst);
        alarmlst = famodel.readFromFile();

        alarm_entity e1 = alarmlst.get(0);
        alarm_entity e2 = alarmlst.get(1);


        assertEquals(e1.getHours(), 8);
        assertEquals(e1.getMins(), 15);
        assertEquals(e2.getHours(), 9);
        assertEquals(e2.getMins(), 10);
    }

    public void testFileCreated()
    {
        Log.d("testfile exists :", String.valueOf(famodel.checkFile(testfile)));
        assertTrue(famodel.checkFile(testfile));
    }


    public void testStuff()
    {
        assertEquals(true, true);
    }


    @Override
    public void tearDown()
    {
       allist.deleteFile(testfile) ;
       allist.finish();
    }

}
