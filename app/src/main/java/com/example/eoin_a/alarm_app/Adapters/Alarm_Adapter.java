package com.example.eoin_a.alarm_app.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.eoin_a.alarm_app.R;
import com.example.eoin_a.alarm_app.entity_class.alarm_entity;

import java.util.ArrayList;

/**
 * Created by eoin_a on 01/03/2015.
 */
public class Alarm_Adapter  extends BaseAdapter{


    private Context context;
    private ArrayList<alarm_entity> alarmlist;



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
            alarm_entity alarmitem = alarmlist.get(position);


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


        String time = String.valueOf(alarmitem.getHours() + " : " + alarmitem.getMins());
        viewholder.timeview.setText(time);

        viewholder.mon.setChecked(alarmitem.isMon());
        viewholder.tue.setChecked(alarmitem.isTue());
        viewholder.wed.setChecked(alarmitem.isWed());
        viewholder.thur.setChecked(alarmitem.isThur());
        viewholder.fri.setChecked(alarmitem.isFri());
        viewholder.sat.setChecked(alarmitem.isSat());
        viewholder.sun.setChecked(alarmitem.isSun());

        viewholder.sun.setChecked(alarmitem.isSun());

        viewholder.buttondel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmlist.remove(position);
                notifyDataSetChanged();
            }
        });


        return convertView;
}

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
