package com.example.dayaclinic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Contact_us extends AppCompatActivity implements View.OnClickListener {
TextView loc;
    TextView email;
    TextView phno;
ImageView im;

String lati="", logi="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        loc=(TextView) findViewById(R.id.edt_loc);
        email=(TextView) findViewById(R.id.edt_email);
        phno=(TextView) findViewById(R.id.edt_phno);
        im=(ImageView) findViewById(R.id.imageButton);

        im.setOnClickListener(this);

        SharedPreferences sh= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String hu = sh.getString("ip", "");
        String url = "http://" + hu + ":8000/myapp/view_contact_info/";



        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //  Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();

                        // response
                        try {
                            JSONObject jsonObj = new JSONObject(response);
                            if (jsonObj.getString("status").equalsIgnoreCase("ok")) {
                                    String ph=jsonObj.getString("phone_number");
                                    phno.setText(ph);
                                    phno.setEnabled(false);
                                    String email1=jsonObj.getString("email");
                                    email.setText(email1);
                                    email.setEnabled(false);
                                    String loc_h=jsonObj.getString("loc_hint");
                                    loc.setText(loc_h);
                                    loc.setEnabled(false);

                                    logi=jsonObj.getString("longitude");
                                    lati=jsonObj.getString("latitude");






                            }


                            // }
                            else {
                                Toast.makeText(getApplicationContext(), "Not found", Toast.LENGTH_LONG).show();
                            }

                        }    catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "Error" + e.getMessage().toString(), Toast.LENGTH_SHORT).show();
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

                return params;
            }
        };

        int MY_SOCKET_TIMEOUT_MS=100000;

        postRequest.setRetryPolicy(new DefaultRetryPolicy(
                MY_SOCKET_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(postRequest);


    }

    @Override
    public void onClick(View view) {
        SharedPreferences sh= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        SharedPreferences.Editor edt=sh.edit();
        edt.putString("lati",lati);
        edt.putString("logi",logi);
        edt.commit();
        Intent mapIntent = new Intent(getApplicationContext(), MapsActivity.class);
        startActivity(mapIntent);

    }
}