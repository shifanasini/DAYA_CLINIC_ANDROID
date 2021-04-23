package com.example.dayaclinic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
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

public class Registration extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    EditText name,email,hname,place,phone,state,password,cpassword,district,age,pincode;

    RadioButton rb1,rb2;
    Button b1;
    Spinner s1;
    String gender="";
    String[]dis={"Calicut","Kannur","Kasargod","Malappuram","Wayanad","Trivandrum","Kollam","Kottayam","Ernakulam","Idukki","Thrissur","Pattanamthitta","Palakad","Alappuzha"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        name=(EditText)findViewById(R.id.edt_name);
        email=(EditText)findViewById(R.id.edt_mail);
        hname=(EditText)findViewById(R.id.edt_hname);
        place=(EditText)findViewById(R.id.edt_place);
        pincode=(EditText)findViewById(R.id.edt_pin);
        phone=(EditText)findViewById(R.id.edt_phone);
        state=(EditText)findViewById(R.id.edt_state);
        password=(EditText)findViewById(R.id.edt_pass);
        cpassword=(EditText)findViewById(R.id.edt_con);

        age=(EditText)findViewById(R.id.edt_age);
        b1=(Button)findViewById(R.id.button5);
        rb1=(RadioButton)findViewById(R.id.radioButton2);
        rb1.setChecked(true);
        rb2=(RadioButton)findViewById(R.id.radioButton);
        b1=(Button)findViewById(R.id.button5);

        s1=(Spinner)findViewById(R.id.spinner) ;


        ArrayAdapter<String> ad=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,dis);
        s1.setAdapter(ad);
        b1.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {



            final String name1 = name.getText().toString();
            final String housename = hname.getText().toString();
            final String place1 = place.getText().toString();
            final String pincode1 =pincode.getText().toString();
            final String age1 = age.getText().toString();
            final String phone1 = phone.getText().toString();
            final String email1 = email.getText().toString();
            final String password1= password.getText().toString();
            final String state1= state.getText().toString();
            final String confrmpass = cpassword.getText().toString();
            final String district = s1.getSelectedItem().toString();
//


            if (rb1.isChecked()) {
                gender = "Male";
            } else if (rb2.isChecked()) {
                gender = "Female";
            }
//            if (!password.equals(confrmpass)) {
//                cpassword.setError("Password mismatch");
//            }
//
            {

                SharedPreferences sh = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                String hu = sh.getString("ip", "");
                String url = "http://" + hu + ":8000/myapp/pa_registration/";


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

                                        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                                        Toast.makeText(getApplicationContext(), "Registered Succussfuly", Toast.LENGTH_LONG).show();
                                        Intent i=new Intent(getApplicationContext(),Registration.class);
                                        startActivity(i);
                                    }


                                    // }
                                    else {
                                        Toast.makeText(getApplicationContext(), "Not found", Toast.LENGTH_LONG).show();
                                    }

                                } catch (Exception e) {
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


                        params.put("name", name1);
                        params.put("hname", housename);
                        params.put("place", place1);
                        params.put("pincode", pincode1);
                        params.put("age", age1);
                        params.put("phone", phone1);
                        params.put("email", email1);
                        params.put("password", password1);

                        params.put("district", district);
                        params.put("state", state1);

                        params.put("gender", gender);


                        return params;
                    }
                };

                int MY_SOCKET_TIMEOUT_MS = 100000;

                postRequest.setRetryPolicy(new DefaultRetryPolicy(
                        MY_SOCKET_TIMEOUT_MS,
                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                requestQueue.add(postRequest);

            }
        }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
