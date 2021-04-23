package com.example.dayaclinic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class custom_service extends BaseAdapter {
    private android.content.Context Context;
    String[] id;
    String[] service;






    public custom_service(android.content.Context applicationContext, String[] id1, String[] service1) {

        this.Context=applicationContext;
        this.id=id1;
        this.service=service1;



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
            gridView=inflator.inflate(R.layout.cust_service, null);



        }
        else
        {
            gridView=(View)convertview;

        }





        TextView tv1=(TextView)gridView.findViewById(R.id.textView5);
        tv1.setTextColor(Color.BLACK);
        tv1.setText(service[position]);



        return gridView;
    }


}



