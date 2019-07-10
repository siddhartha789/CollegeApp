package com.bhisham.server_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3;
    String fn,ln;
    String rno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.t1);
        e2=(EditText)findViewById(R.id.t2);
        e3=(EditText)findViewById(R.id.t3);
    }
    public void test(View v){
        rno=e1.getText().toString();
        fn=e2.getText().toString();
        ln=e3.getText().toString();
        Intent i=new Intent(this,Main2Activity.class);
        i.putExtra("first",rno);
        i.putExtra("second",fn);
        i.putExtra("third",ln);
        startActivity(i);
    }
}
