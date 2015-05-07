package com.example.eoin_a.alarm_app.Alarm_Controller;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

import com.example.eoin_a.alarm_app.R;

/**
 * Created by eoin_a on 06/05/2015.
 */
public class SoundPlayer {

    private Thread soundthread;
    private MediaPlayer mplayer;
    private Context cont;
    private Runnable runner = new Runnable() {
        @Override
        public void run() {
            mplayer.start();
        }
    };


    public SoundPlayer(Context contin)
    {
        cont = contin;
        mplayer = MediaPlayer.create(cont, R.raw.loundalarm);
        mplayer.setLooping(true);
        soundthread = new Thread(runner);
    }

    public synchronized void playSound()
    {
        soundthread.start();
        Log.d("alarm initiated", "alarm ringing");
    }

    public synchronized void stopSound()
    {
        mplayer.release();
    }





}
