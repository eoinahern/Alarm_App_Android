package com.example.eoin_a.alarm_app.Alarm_views;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by eoin_a on 19/03/2015.
 *
 *
 */
public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedinstancestate)
    {
        final Calendar cld = Calendar.getInstance();
        int hour = cld.get(Calendar.HOUR_OF_DAY);
        int min = cld.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), this, hour, min,
                DateFormat.is24HourFormat(getActivity()));

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {


          Alarm_List lst = (Alarm_List) getActivity();
          Log.d("time", "hours : " + String.valueOf(hourOfDay) +  " mins : " + String.valueOf(minute) );
          lst.itemCreadtedListener(hourOfDay, minute);
    }
}
