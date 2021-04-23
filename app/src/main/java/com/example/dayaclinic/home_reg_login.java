package com.example.dayaclinic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home_reg_login extends AppCompatActivity implements View.OnClickListener {
Button reg,log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_reg_login);
        reg=(Button) findViewById(R.id.re);
        reg.setOnClickListener(this);
        log=(Button) findViewById(R.id.button6);
        log.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view==reg)
        {
            Intent i=new Intent(getApplicationContext(),Registration.class);
            startActivity(i);
        }
        else if(view==log)
        {
            Intent i=new Intent(getApplicationContext(),login.class);
            startActivity(i);
        }
    }
}