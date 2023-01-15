package com.example.gstcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GST_Reasult extends AppCompatActivity {

    TextView textview1,textview2,textview3,textview4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gst_reasult);

        textview1 = findViewById(R.id.textview1);
        textview2 = findViewById(R.id.textview2);
        textview3 = findViewById(R.id.textview3);
        textview4 = findViewById(R.id.textview4);

        Intent i = getIntent();
        String includ = i.getStringExtra("includ");
        String gstrateprice = i.getStringExtra("gstrateprice");
        String value =i.getStringExtra("value");
        String inc =i.getStringExtra("inc");

        textview1.setText(includ);
        textview2.setText(gstrateprice);
        textview3.setText(value);
        textview4.setText(inc);



    }
}