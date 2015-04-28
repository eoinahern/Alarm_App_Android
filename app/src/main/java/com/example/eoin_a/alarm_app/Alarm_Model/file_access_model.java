package com.example.eoin_a.alarm_app.Alarm_Model;

import android.content.Context;
import android.util.Log;

import com.example.eoin_a.alarm_app.Alarm_views.Alarm_List;
import com.example.eoin_a.alarm_app.entity_class.alarm_entity;

import java.io.EOFException;
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

   private final String file_not_found = "file not found";
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
    public synchronized void writeToFile(final ArrayList<alarm_entity> alarmlist) {

        if(alarmfile == null) {

            createFile(Alarm_List.filename);
        }

        try
        {
            fostream = new FileOutputStream(alarmfile);
            oostream = new ObjectOutputStream(fostream);
            addAlarms(alarmlist);

            oostream.close();
            fostream.close();
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

        Log.d("alarms writing", "alarms saved");
    }

    @Override
    public synchronized ArrayList<alarm_entity> readFromFile() {

         final ArrayList<alarm_entity> alarmlist = new ArrayList<alarm_entity>();


        //on start up the file is not found leading
        //the app to return the empty alarm list. god damn!

        if(!checkFile(Alarm_List.filename))
        {
            Log.d(file_not_found, "not found on read");
            return alarmlist;
        }

        if(alarmfile == null)
            createFile(Alarm_List.filename);




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
                            Log.d("iam in", "iam in");
                        }

                        oistream.close();
                        fistream.close();
                    }
                    catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                    catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            });

            thr.start();
            thr.join();



        }

        catch(Exception ex)
        {
            ex.printStackTrace();
            Log.e("error", "read exception");
        }


        return alarmlist;

     }


    public boolean checkFile(String filename)
    {
       File file = cont.getFileStreamPath(filename);
       return file.exists();
    }

    public void createFile(String filename)
    {
        alarmfile = new File(cont.getFilesDir(), filename);
    }
}
