package com.bhisham.vtop_lite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CGPA_Activity extends AppCompatActivity {
EditText t1,t2,t3,t4;
TextView textView;
Button button;
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpa_);
        t1=(EditText)findViewById(R.id.t1);
        t2=(EditText)findViewById(R.id.t2);
        t3=(EditText)findViewById(R.id.t3);
        t4=(EditText)findViewById(R.id.t4);
        toolbar=(Toolbar)findViewById(R.id.ToolbarCGPA);
setSupportActionBar(toolbar);
getSupportActionBar().setTitle("Predict your CGPA");
getSupportActionBar().setDisplayHomeAsUpEnabled(true);
button=(Button)findViewById(R.id.buttoncgpa);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cbs,cts;
                double cgb,cgt,total;
                cbs= Integer.parseInt(t1.getText().toString());
                cgb=Double.parseDouble(t2.getText().toString());
                cts=Integer.parseInt(t3.getText().toString());
                cgt=Double.parseDouble(t4.getText().toString());
                total = ((cbs * cgb) + (cts * cgt)) / (cbs + cts);

                if(cgb>10){
                    t2.setError("Invalid CGPA");
                }

                else if(cts<16){
                    t3.setError("Credits must be >=16");
                }
                else if(cts>27){
                    t3.setError("Maximum limit is 27");
                }
                else if(cgt>10){
                    t4.setError("Invalid GPA");
                }
                else {
                    Toast.makeText(getApplicationContext(), "Overall Cgpa is " + total, Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
