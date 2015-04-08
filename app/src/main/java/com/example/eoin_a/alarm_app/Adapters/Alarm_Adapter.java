package com.example.eoin_a.alarm_app.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

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


    public Alarm_Adapter(Context contextin, ArrayList<alarm_entity> alarmlistin)
    {
        context = contextin;
        alarmlist = alarmlistin;
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

        /*Log.d("position", String.valueOf(position));
        Log.d("mon", String.valueOf(entity.isMon()));
        Log.d("tue", String.valueOf(entity.isTue()));
        Log.d("wed", String.valueOf(entity.isWed()));
        Log.d("thu", String.valueOf(entity.isThur()));
        Log.d("fri", String.valueOf(entity.isFri()));*/



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
            Log.d("using previous", "using previous container");
            setCheckBoxes(entity, viewholder);
        }


        String time = String.valueOf(entity.getHours() + " : " + entity.getMins());
        viewholder.timeview.setText(time);


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
                notifyDataSetChanged();
            }
        });


        return convertView;
}

    private void setCheckBoxes(alarm_entity entity, viewHolder viewholder) {

        viewholder.mon.setChecked(entity.isMon());
        viewholder.tue.setChecked(entity.isTue());
        viewholder.wed.setChecked(entity.isWed());
        viewholder.thur.setChecked(entity.isThur());
        viewholder.fri.setChecked(entity.isFri());
        viewholder.sat.setChecked(entity.isSat());
        viewholder.sun.setChecked(entity.isSun());
    }





    private CompoundButton.OnCheckedChangeListener list = new CompoundButton.OnCheckedChangeListener() {
         @Override
         public void onCheckedChanged(CompoundButton bv, boolean isChecked) {

            switch(bv.getId())
            {
                case R.id.rbmon :
                    entity.setMon(isChecked);

                    break;
                case R.id.rbtue :
                    entity.setTue(isChecked);

                    break;
                case R.id.rbwed:
                    entity.setWed(isChecked);

                    break;
                case R.id.rbthu :
                    entity.setThur(isChecked);

                    break;
                case R.id.rbfri :
                    entity.setFri(isChecked);

                    break;
                case R.id.rbsat:
                    entity.setSat(isChecked);

                    break;
                case R.id.rbsun:
                    entity.setSun(isChecked);

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
