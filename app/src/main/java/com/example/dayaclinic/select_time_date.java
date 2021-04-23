package com.example.dayaclinic;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class select_time_date extends AppCompatActivity {
    GridView li;
    String[] id,from_time,to_time,day;
    EditText ed_date;

    String sel_day="",sel_date="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_time_date);
        li=(GridView) findViewById(R.id.lst);
        ed_date=(EditText)findViewById(R.id.edt_state);

        final Calendar myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "yyyy-MM-dd"; //In which you need put here


                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                ed_date.setText(sdf.format(myCalendar.getTime()));
                sel_date=sdf.format(myCalendar.getTime());
                int dd=myCalendar.get(Calendar.DAY_OF_WEEK);
                switch (dd){
                    case 1: sel_day="SUNDAY";
                    break;
                    case 2: sel_day="MONDAY";
                    break;
                    case 3: sel_day="TUESDAY";
                        break;
                    case 4: sel_day="WEDNESDAY";
                        break;
                    case 5: sel_day="THURSDAY";
                        break;
                    case 6: sel_day="FRIDAY";
                        break;
                    case 7: sel_day="SATURDAY";
                        break;
                }
                schedule_load();
                SharedPreferences sh=PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor ed=sh.edit();
                ed.putString("date",ed_date.getText().toString());
                ed.commit();
            }

        };

        ed_date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(select_time_date.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

    public void schedule_load(){
        SharedPreferences sh = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String ip = sh.getString("ip", "");
        String url = "http://" + ip + ":8000/myapp/view_schedule/";



        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        //    Toast.makeText(getApplicationContext(),"hai",Toast.LENGTH_SHORT).show();
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        //  Toast.makeText(getApplicationContext(),response,Toast.LENGTH_SHORT).show();


                        // response
                        try {
                            JSONObject jsonObj = new JSONObject(response);
                            String sucs = jsonObj.getString("status");
                            if (sucs.equalsIgnoreCase("ok")) {
                                //about,date,photo,id


                                JSONArray jsa = jsonObj.getJSONArray("data");
                                id = new String[jsa.length()];
                                from_time=new String[jsa.length()];
                                to_time=new String[jsa.length()];
                                day=new String[jsa.length()];

                                for (int i = 0; i < jsa.length(); i++) {
                                    JSONObject jsob = jsa.getJSONObject(i);
                                    id[i] = jsob.getString("id");
                                    from_time[i] = jsob.getString("from_time");


                                    to_time[i] = jsob.getString("to_time");


                                    day[i] = jsob.getString("day");


                                }
//                                ArrayAdapter<String> ad=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,doc_name);
//                                li.setAdapter(ad);
                                li.setAdapter(new custom_select_time_date(getApplicationContext(),id,from_time,to_time,day));


                                //lv1.setAdapter(new Custom5(getApplicationContext(),id,plc,time));
                            }
                        } catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "eeeee" + e.toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Toast.makeText(getApplicationContext(), "eeeee" + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                SharedPreferences sh = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                Map<String, String> params = new HashMap<String, String>();
                params.put("did",sh.getString("sel_docid",""));
                params.put("day",sel_day);




                return params;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(60000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));


        requestQueue.add(postRequest);

    }
}