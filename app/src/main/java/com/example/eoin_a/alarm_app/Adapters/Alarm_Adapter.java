package com.example.eoin_a.alarm_app.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.eoin_a.alarm_app.Alarm_Controller.SysAlarmEditorInt;
import com.example.eoin_a.alarm_app.R;
import com.example.eoin_a.alarm_app.entity_class.alarm_entity;

import java.util.ArrayList;

/**
 * Created by eoin_a on 01/03/2015.
 */
public class Alarm_Adapter  extends BaseAdapter  {


    private Context context;
    private ArrayList<alarm_entity> alarmlist;
    private alarm_entity entity;
    private SysAlarmEditorInt sysalarmedt;


    public Alarm_Adapter(Context contextin, ArrayList<alarm_entity> alarmlistin, SysAlarmEditorInt sysalarmedtin)
    {
        context = contextin;
        alarmlist = alarmlistin;
        sysalarmedt = sysalarmedtin;
    }



    @Override
    public int getCount()
    {
        return alarmlist.size();
    }

    @Override
    public Object getItem(int position) {

        return alarmlist.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

            viewHolder viewholder;
            entity  = alarmlist.get(position);


        if(convertView == null)
        {
            LayoutInflater layoutinflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutinflater.inflate(R.layout.alarm_view, null, false);

            viewholder = new viewHolder();
            viewholder.timeview = (TextView) convertView.findViewById(R.id.timeview);
            viewholder.buttondel = (Button) convertView.findViewById(R.id.Button);
            viewholder.buttononoff = (ToggleButton) convertView.findViewById(R.id.toggleButton);
            viewholder.mon = (CheckBox) convertView.findViewById(R.id.rbmon);
            viewholder.tue = (CheckBox) convertView.findViewById(R.id.rbtue);
            viewholder.wed = (CheckBox) convertView.findViewById(R.id.rbwed);
            viewholder.thur = (CheckBox) convertView.findViewById(R.id.rbthu);
            viewholder.fri = (CheckBox) convertView.findViewById(R.id.rbfri);
            viewholder.sat = (CheckBox) convertView.findViewById(R.id.rbsat);
            viewholder.sun = (CheckBox) convertView.findViewById(R.id.rbsun);

            convertView.setTag(viewholder);

        }
        else
        {
            viewholder = (viewHolder)  convertView.getTag();

        }


        String time = String.valueOf(entity.getHours() + " : " + entity.getMins());
        viewholder.timeview.setText(time);

        setCheckBoxes(entity,viewholder);


        viewholder.mon.setOnCheckedChangeListener(list);
        viewholder.tue.setOnCheckedChangeListener(list);
        viewholder.wed.setOnCheckedChangeListener(list);
        viewholder.thur.setOnCheckedChangeListener(list);
        viewholder.fri.setOnCheckedChangeListener(list);
        viewholder.sat.setOnCheckedChangeListener(list);
        viewholder.sun.setOnCheckedChangeListener(list);

        viewholder.buttondel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               alarmlist.remove(position);
               sysalarmedt.deleteAllAlarms(entity.getDays(),position);

                notifyDataSetChanged();
            }
        });

        return convertView;
}


    private void setCheckBoxes(alarm_entity entity, viewHolder viewholder) {

        boolean[] daystate = entity.getDays();

        Log.d("calling set checkboxes", "set checkboxes");

        viewholder.mon.setChecked(daystate[1]);
        viewholder.tue.setChecked(daystate[2]);
        viewholder.wed.setChecked(daystate[3]);
        viewholder.thur.setChecked(daystate[4]);
        viewholder.fri.setChecked(daystate[5]);
        viewholder.sat.setChecked(daystate[6]);
        viewholder.sun.setChecked(daystate[0]);
    }





    private CompoundButton.OnCheckedChangeListener list = new CompoundButton.OnCheckedChangeListener() {
         @Override
         public void onCheckedChanged(CompoundButton bv, boolean isChecked) {

             Log.d("Checed changed", "changed"   +  "is checked  :"  + String.valueOf(isChecked));

            switch(bv.getId())
            {
                case R.id.rbmon :
                    Log.d("mon set","mon");
                    entity.setDay(1,isChecked);

                    break;
                case R.id.rbtue :
                    Log.d("tue set","tue");
                    entity.setDay(2,isChecked);


                    break;
                case R.id.rbwed:
                    entity.setDay(3,isChecked);
                    Log.d("wed set","wed");

                    break;
                case R.id.rbthu :
                    entity.setDay(4,isChecked);
                    Log.d("thur set","thur");

                    break;
                case R.id.rbfri :
                    entity.setDay(5,isChecked);
                    Log.d("fri set","fri");

                    break;
                case R.id.rbsat:
                    entity.setDay(6,isChecked);
                    Log.d("sat set","sat");
                    break;
                case R.id.rbsun:
                    entity.setDay(0,isChecked);
                    Log.d("sunday set","sunday");

                    break;


            }
         }
     };


    private static class viewHolder
    {
        private TextView timeview;
        private Button buttondel;
        private ToggleButton buttononoff;
        private CheckBox mon;
        private CheckBox tue;
        private CheckBox wed;
        private CheckBox thur;
        private CheckBox fri;
        private CheckBox sat;
        private CheckBox sun;
    }
}
