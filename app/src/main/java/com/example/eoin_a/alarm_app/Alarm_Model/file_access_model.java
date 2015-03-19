package com.example.eoin_a.alarm_app.Alarm_Model;

import android.content.Context;
import android.util.Log;

import com.example.eoin_a.alarm_app.Alarm_views.Alarm_List;
import com.example.eoin_a.alarm_app.entity_class.alarm_entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by eoin_a on 01/03/2015.
 *  //this class is used to read/write alarm info to a file
 */
public class file_access_model implements file_acces_int {

   private Context cont;
   private File alarmfile;
   private FileOutputStream fostream;
   private FileInputStream fistream;
   private ObjectOutputStream oostream;
   private ObjectInputStream oistream;


    public file_access_model(Context context)
   {
       cont = context;
   }

    // may not need constructor. just perform operation depending on existence of file
    //should possibly create this as a service!


    @Override
    public void writeToFile(final ArrayList<alarm_entity> alarmlist) {

        if(alarmfile == null)
            createFile();

        try
        {
            fostream = new FileOutputStream(alarmfile);
            oostream = new ObjectOutputStream(fostream);
            addAlarms(alarmlist);
            oostream.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            Log.e("error", "write exception");
        }


    }

    private void addAlarms(final ArrayList<alarm_entity> alarmlist) {

        Thread mythrd = new Thread(new Runnable() {

            @Override
            public void run() {

                for(alarm_entity alarm : alarmlist)
                {
                    try {
                        oostream.writeObject(alarm);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        mythrd.start();



        try {
            mythrd.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<alarm_entity> readFromFile() {

        final ArrayList<alarm_entity> alarmlist = new ArrayList<alarm_entity>();


        if(!checkFile(Alarm_List.filename) || alarmfile == null)
            return alarmlist;


        try {
            fistream = new FileInputStream(alarmfile);
            oistream = new ObjectInputStream(fistream);


            Thread thr = new Thread(new Runnable() {
                @Override
                public void run() {

                    alarm_entity alarm;

                    try {
                        while ((alarm = (alarm_entity) oistream.readObject()) != null) {
                            alarmlist.add(alarm);
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            });

            thr.start();
            thr.join();


            oistream.close();


        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            Log.e("error", "read exception");
        }


        return alarmlist;

     }


    private boolean checkFile(String filename)
    {
       File file = cont.getFileStreamPath(Alarm_List.filename);
       return file.exists();
    }


    private void createFile()
    {
        alarmfile = new File(cont.getFilesDir(), Alarm_List.filename);
    }
}
