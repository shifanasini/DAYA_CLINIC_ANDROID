package com.example.dayaclinic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class IPSET extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    EditText ed1;
    SharedPreferences sh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_p_s_e_t);
        ed1=(EditText)findViewById(R.id.editText);
        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(this);
        ed1.setText("192.168.43.149");
        sh= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

    }

    @Override
    public void onClick(View view) {
        String IP=ed1.getText().toString();
        SharedPreferences.Editor edt=sh.edit();
        edt.putString("ip",IP);
        edt.putString("url","http://"+IP+":5000/");
        edt.commit();

        Intent IN=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(IN);

    }
}