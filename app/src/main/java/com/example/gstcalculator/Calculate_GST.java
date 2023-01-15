package com.example.gstcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Calculate_GST extends AppCompatActivity {

    Spinner gstspinner;
    Button btninclud;
    String data;
    EditText etinclud;
    String[] rate = {"5%","12%","18%","28%"};
    String var;
    String includ;
    float gstrateprice,value;
    boolean selectid;
    TextView textview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_gst);

        gstspinner = findViewById(R.id.gstspinner);
        btninclud = findViewById(R.id.btninclud);
        etinclud = findViewById(R.id.etinclud);
        textview = findViewById(R.id.textview);

        Intent i = getIntent();
        //selectid =Boolean.parseBoolean(i.getStringExtra("selectid"));
        selectid = i.getBooleanExtra("selectid",false);
        String inc = i.getStringExtra("inc");
        textview.setText(inc);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.spinnerlist, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        gstspinner.setAdapter(adapter);

        gstspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                data = adapterView.getItemAtPosition(i).toString();

                if(rate[i]== "5%"){
                    var = "5";
                }
                else if(rate[i] == "12%"){
                    var = "12";
                }
                else if(rate[i] == "18%"){
                    var = "18";
                }
                 else{
                    var = "28";
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btninclud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calculate_GST.this, GST_Reasult.class);
                String inc = textview.getText().toString();
                includ = etinclud.getText().toString();
                if(etinclud.getText().toString().isEmpty()){
                    Toast.makeText(Calculate_GST.this, "Please enter amount", Toast.LENGTH_SHORT).show();
                }
                else{
                if (selectid){
                        float price = Float.parseFloat(includ);
                        float var1 = Float.parseFloat(var);
                        gstrateprice = (var1 * price) / 100;
                        value = price - gstrateprice;
                }
                  else {
                       float price = Float.parseFloat(includ);
                       float var1 = Float.parseFloat(var);
                       gstrateprice = (var1*price)/100;
                       value = price + gstrateprice;
                }
                }
                intent.putExtra("inc",inc);
                intent.putExtra("includ",includ);
                intent.putExtra("gstrateprice",""+gstrateprice);
                intent.putExtra("value",""+value);

                startActivity(intent);
            }
        });
    }
}