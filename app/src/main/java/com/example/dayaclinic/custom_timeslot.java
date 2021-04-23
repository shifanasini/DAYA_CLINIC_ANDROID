package com.example.dayaclinic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

public class custom_timeslot extends BaseAdapter {
    private android.content.Context Context;

    String[] time;


    public custom_timeslot(android.content.Context applicationContext, String[] time) {

        this.Context=applicationContext;
        this.time=time;
    }

    @Override
    public int getCount() {

        return time.length;
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
        bt.setText(time[position]);
        bt.setTag(position);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



        return gridView;
    }


}



