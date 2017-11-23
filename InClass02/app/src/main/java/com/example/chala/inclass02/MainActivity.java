package com.example.chala.inclass02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.calculate_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                String w= getResources().getString(R.string.weight_edittext);
                String h= getResources().getString(R.string.height_edittext);
                String g= getResources().getString(R.string.inch_edittext);
                */
                EditText w=(EditText)findViewById(R.id.weight_editText);
                EditText h=(EditText)findViewById(R.id.height_editText);
                EditText g=(EditText)findViewById(R.id.inch_editText);

                double a=-1,b=-1,c=-1;
                double x=0,y=0;
                double d=0;
                try {
                    a = Double.parseDouble(w.getText().toString());
                    b = Double.parseDouble(h.getText().toString());
                    c = Double.parseDouble(g.getText().toString());
                }
                catch(Exception e){

                }

                if(a>=0 && b>=0 && c>=0) {

                    x = b * 12 + c;
                    y = x * x;

                    d = (a / y) * 703;

                    TextView tv = (TextView) findViewById(R.id.result1);
                    tv.setText("Your BMI: " + d);

                    TextView tv1 = (TextView) findViewById(R.id.result2);

                    if (d < 18.5) {
                        tv1.setText("You are Underweight");
                    } else if (d >= 18.5 && d <= 24.9) {
                        tv1.setText("You are Normal weight");
                    } else if (d >= 25 && d <= 29.9) {
                        tv1.setText("You are Overweight");
                    } else if (d >= 30) {
                        tv1.setText("You are obese");
                    }

                    Log.d("demo", " " + d);
                    Toast.makeText(MainActivity.this, "BMI Calculated", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_LONG).show();
                    TextView tv = (TextView) findViewById(R.id.result1);
                    tv.setText("Your BMI: ");
                    TextView tv1 = (TextView) findViewById(R.id.result2);
                    tv1.setText("You are ");
                }

            }
        });


    }
}
