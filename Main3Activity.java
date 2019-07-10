package com.bhisham.server_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity {
EditText e7,e8,e9;
String ten,twe,grad;
    String e,c,add,rno,fn,ln;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        rno=getIntent().getStringExtra("first");
        fn=getIntent().getStringExtra("second");
        ln=getIntent().getStringExtra("third");
        e=getIntent().getStringExtra("fourth");
        c=getIntent().getStringExtra("fifth");
        add=getIntent().getStringExtra("sixth");
        e7=(EditText)findViewById(R.id.t7);
        e8=(EditText)findViewById(R.id.t8);
        e9=(EditText)findViewById(R.id.t9);
    }
    public void test2(View v){
        ten=e7.getText().toString();
        twe=e8.getText().toString();
        grad=e9.getText().toString();
        Intent i2=new Intent(this,Main4Activity.class);
        i2.putExtra("first",rno);
        i2.putExtra("second",fn);
        i2.putExtra("third",ln);
        i2.putExtra("fourth",e);
        i2.putExtra("fifth",c);
        i2.putExtra("sixth",add);
        i2.putExtra("seventh",ten);
        i2.putExtra("eighth",twe);
        i2.putExtra("ninth",grad);
        startActivity(i2);

    }
}
