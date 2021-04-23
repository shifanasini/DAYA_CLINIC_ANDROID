package com.example.dayaclinic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class custom_select_time_date extends BaseAdapter {
    private android.content.Context Context;
    String[] id;
    String[] from_time;
    String[] to_time;
    String[] day;







    public custom_select_time_date(android.content.Context applicationContext, String[] id1, String[] from_time,String[] to_time,String[] day) {

        this.Context=applicationContext;
        this.id=id1;
        this.from_time=from_time;
        this.to_time=to_time;
        this.day=day;



    }

    @Override
    public int getCount() {

        return id.length;
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {


        LayoutInflater inflator=(LayoutInflater)Context.getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE);

        View gridView;
        if(convertview==null)
        {
            gridView=new View(Context);
            gridView=inflator.inflate(R.layout.cust_select_time_date, null);



        }
        else
        {
            gridView=(View)convertview;

        }





        Button bt=(Button) gridView.findViewById(R.id.button3);
        String dat=from_time[position]+" - "+to_time[position];
        bt.setText(dat);
        bt.setTag(position);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos=(int)view.getTag();
                SharedPreferences sh= PreferenceManager.getDefaultSharedPreferences(Context);
                SharedPreferences.Editor ed=sh.edit();
                ed.putString("sch_id",id[pos]);
                ed.putString("from_tym",from_time[pos]);
                ed.putString("to_tym",to_time[pos]);
                ed.commit();
                Intent ij=new Intent(Context,view_timeslots.class);
                ij.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Context.startActivity(ij);
            }
        });



        return gridView;
    }


}



