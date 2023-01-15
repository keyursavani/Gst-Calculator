package com.example.gstcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnnext;
    RadioButton including,excluding;
    boolean selectid;
    String inc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnnext = findViewById(R.id.btnnext);
        including = findViewById(R.id.including);
        excluding = findViewById(R.id.excluding);

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(including.isChecked()){
                    selectid = true;
                    inc = including.getText().toString();
                    Intent intent = new Intent(MainActivity.this, Calculate_GST.class);
                    intent.putExtra("selectid",selectid);
                    intent.putExtra("inc",inc);
                    startActivity(intent);
                }
                 else {
                     selectid = false;
                     inc = excluding.getText().toString();
                     Intent  i = new Intent(MainActivity.this, Calculate_GST.class);
                     i.putExtra("selectid",selectid);
                     i.putExtra("inc",inc);
                     startActivity(i);
                }
            }
        });
    }
}