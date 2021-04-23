package com.example.dayaclinic;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class custom_our_doctors extends BaseAdapter {
    private android.content.Context Context;
    String[] id;
    String[] doc_name;
    String[] qua;
    String[] photo;





    public custom_our_doctors (android.content.Context applicationContext, String[] id, String[]doc_name,String[]photo,String[] qua) {

        this.Context=applicationContext;
        this.id=id;
        this.doc_name=doc_name;
        this.qua=qua;
        this.photo=photo;


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
            gridView=inflator.inflate(R.layout.cust_our_doctors, null);



        }
        else
        {
            gridView=(View)convertview;

        }





        TextView tv1=(TextView)gridView.findViewById(R.id.textView15);
        TextView tv2=(TextView)gridView.findViewById(R.id.textView10);



        ImageView im=(ImageView)gridView.findViewById(R.id.imageView3);





        //


        /////////////////////





        tv1.setTextColor(Color.BLACK);
        tv2.setTextColor(Color.BLACK);

        //tv6.setTextColor(Color.BLACK);
        //tv1.setText(c[position]);
        //tv2.setText(d[position]);

        tv1.setText(doc_name[position]);
        tv2.setText(qua[position]);


        SharedPreferences sh= PreferenceManager.getDefaultSharedPreferences(Context);
        String ss=sh.getString("ip", "");
        String url = "http://" + ss+ ":8000"+photo[position];


        Picasso.with(Context).load(url).into(im);
//        Picasso.with(Context).load(url).networkPolicy(NetworkPolicy.NO_CACHE).memoryPolicy(MemoryPolicy.NO_CACHE).transform(new CircleTransform()).into(im);


        return gridView;
    }

}
