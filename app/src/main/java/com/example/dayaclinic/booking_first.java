package com.example.dayaclinic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class booking_first extends AppCompatActivity implements View.OnClickListener {
    Button book;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_first);
        book=(Button)findViewById(R.id.login);
        book.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i=new Intent(getApplicationContext(),select_doctor.class);
        startActivity(i);
    }
}