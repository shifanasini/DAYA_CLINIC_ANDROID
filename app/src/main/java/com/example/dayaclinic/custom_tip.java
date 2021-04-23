package com.example.dayaclinic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class custom_tip extends BaseAdapter {
    private android.content.Context Context;
    String[] id;
    String[] tips;






    public custom_tip(android.content.Context applicationContext, String[] id1, String[] tips1) {

        this.Context=applicationContext;
        this.id=id1;
        this.tips=tips1;



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
            gridView=inflator.inflate(R.layout.cust_tips, null);



        }
        else
        {
            gridView=(View)convertview;

        }





        TextView tv1=(TextView)gridView.findViewById(R.id.textView5);
        tv1.setTextColor(Color.BLACK);
        tv1.setText(tips[position]);

        TextView tv_more=(TextView)gridView.findViewById(R.id.textView8);
        tv_more.setTag(position);
        tv_more.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int pos=(int)view.getTag();
                final SharedPreferences sh= PreferenceManager.getDefaultSharedPreferences(Context);;
                SharedPreferences.Editor edt=sh.edit();
                edt.putString("tipid",id[pos]);
                edt.commit();


                Intent i=new Intent(Context,view_tips_more.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Context.startActivity(i);

            }
        });


        return gridView;
    }


}



