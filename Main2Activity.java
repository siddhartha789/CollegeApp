package com.bhisham.server_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText e4,e5,e6;
    String e,c,add,rno,fn,ln;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        rno=getIntent().getStringExtra("first");
        fn=getIntent().getStringExtra("second");
        ln=getIntent().getStringExtra("third");
        e4=(EditText)findViewById(R.id.t4);
        e5=(EditText)findViewById(R.id.t5);
        e6=(EditText)findViewById(R.id.t6);

    }
    public void test1(View v){
        e=e4.getText().toString();
        c=e5.getText().toString();
        add=e6.getText().toString();
        Intent i1=new Intent(this,Main3Activity.class);
        i1.putExtra("first",rno);
        i1.putExtra("second",fn);
        i1.putExtra("third",ln);
        i1.putExtra("fourth",e);
        i1.putExtra("fifth",c);
        i1.putExtra("sixth",add);
        startActivity(i1);

    }
}
