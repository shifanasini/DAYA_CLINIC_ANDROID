package com.example.dayaclinic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton booking;
    ImageButton profile;
    ImageButton tip;
    ImageButton service;
    ImageButton about;
    ImageButton doctor;
    ImageButton contact;
    TextView booking1;
    TextView profile1;
    TextView tip1;
    TextView service1;
    TextView about1;
    TextView doctor1;
    TextView contact1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        booking=(ImageButton)findViewById(R.id.btn_booking);
        booking.setOnClickListener(this);
        profile=(ImageButton)findViewById(R.id.btn_profile);
        profile.setOnClickListener(this);
        tip=(ImageButton)findViewById(R.id.btn_tips);
        tip.setOnClickListener(this);
        service=(ImageButton)findViewById(R.id.btn_tratment);
        service.setOnClickListener(this);
        about=(ImageButton)findViewById(R.id.btn_about);
        about.setOnClickListener(this);
        doctor=(ImageButton)findViewById(R.id.btn_doctors);
        doctor.setOnClickListener(this);
        contact=(ImageButton)findViewById(R.id.btn_contact);
        contact.setOnClickListener(this);



        booking1=(TextView) findViewById(R.id.txt_booking);
        booking1.setOnClickListener(this);
        profile1=(TextView) findViewById(R.id.txt_profile);
        profile1.setOnClickListener(this);
        tip1=(TextView) findViewById(R.id.txt_tip);
        tip1.setOnClickListener(this);
        service1=(TextView) findViewById(R.id.txt_treatment);
        service1.setOnClickListener(this);
        about1=(TextView) findViewById(R.id.txt_about);
        about1.setOnClickListener(this);
        doctor1=(TextView) findViewById(R.id.txt_doctors);
        doctor1.setOnClickListener(this);
        contact1=(TextView) findViewById(R.id.txt_contact);




        contact1.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {
        if(view==contact1)
        {
            Intent i=new Intent(getApplicationContext(),Contact_us.class);
            startActivity(i);
        }
        else if(view==doctor1)
        {
            Intent i=new Intent(getApplicationContext(),Our_Doctors.class);
            startActivity(i);
        }
        else if(view==service1)
        {
            Intent i=new Intent(getApplicationContext(),Service.class);
            startActivity(i);
        }
        else if(view==tip1)
        {
            Intent i=new Intent(getApplicationContext(),tips.class);
            startActivity(i);
        }
        else if(view==booking1)
        {
            Intent i=new Intent(getApplicationContext(),Our_Doctors.class);
            startActivity(i);
        }
        else if(view==about1)
        {
            Intent i=new Intent(getApplicationContext(),About.class);
            startActivity(i);
        }
        if(view==contact)
        {
            Intent i=new Intent(getApplicationContext(),Contact_us.class);
            startActivity(i);
        }
        else if(view==doctor)
        {
            Intent i=new Intent(getApplicationContext(),Our_Doctors.class);
            startActivity(i);
        }
        else if(view==service)
        {
            Intent i=new Intent(getApplicationContext(),Service.class);
            startActivity(i);
        }
        else if(view==tip)
        {
            Intent i=new Intent(getApplicationContext(),tips.class);
            startActivity(i);
        }
        else if(view==booking)
        {
            Intent i=new Intent(getApplicationContext(),booking_first.class);
            startActivity(i);
        }
        else if(view==about)
        {
            Intent i=new Intent(getApplicationContext(),About.class);
            startActivity(i);
        }
        else if(view==profile)
        {
            Intent i=new Intent(getApplicationContext(),home_reg_login.class);
            startActivity(i);
        }
    }
}