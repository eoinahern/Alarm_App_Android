package com.example.eoin_a.alarm_app.Alarm_views;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.eoin_a.alarm_app.Alarm_Controller.SysAlarmEditor;
import com.example.eoin_a.alarm_app.Alarm_Controller.SysAlarmEditorInt;
import com.example.eoin_a.alarm_app.MyApp;
import com.example.eoin_a.alarm_app.R;


public class Alarm_Ringing_Activity extends ActionBarActivity {


    private Button stop;
    private SysAlarmEditorInt sysalarm;
    private Window window;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //get intent. pull pidentifier from it. if required.


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm__ringing_);

        stop = (Button) findViewById(R.id.stopbutton);
        sysalarm = new SysAlarmEditor(MyApp.getInstance());



        window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        window.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
        window.addFlags(WindowManager.LayoutParams.FLAG_ALLOW_LOCK_WHILE_SCREEN_ON);
    }


    public void KillScreen(View v)
    {
        finish();
    }


    public void reCreateAlarm()
    {

        //sysalarm.createAlarm();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_alarm__ringing_, menu);
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
