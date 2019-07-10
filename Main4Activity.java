package com.bhisham.server_android;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main4Activity extends AppCompatActivity {
    EditText e10,e11,e12;
    AsyncTask<Void,Void,Void> mytask;
    String rno,fname,lname,e,c,add,ten,twe,grad,tech,fat,pass;
    String fn,ln;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        rno=getIntent().getStringExtra("first");
        fn=getIntent().getStringExtra("second");
        ln=getIntent().getStringExtra("third");
        e=getIntent().getStringExtra("fourth");
        c=getIntent().getStringExtra("fifth");
        add=getIntent().getStringExtra("sixth");
        ten=getIntent().getStringExtra("seventh");
        twe=getIntent().getStringExtra("eighth");
        grad=getIntent().getStringExtra("ninth");
        e10=(EditText)findViewById(R.id.t10);
        e11=(EditText)findViewById(R.id.t11);
        e12=(EditText)findViewById(R.id.t12);
    }
    public void test3(View v){
        Toast.makeText(this,"Data Transferred",Toast.LENGTH_LONG).show();
        tech=e10.getText().toString();
        fat=e11.getText().toString();
        pass=e12.getText().toString();
        mytask=new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                Contact(Main4Activity.this,rno,fn,ln,e,c,add,ten,twe,grad,tech,fat,pass);
                return null;
            }

        };
        mytask.execute(null,null,null);
    }

    static void Contact(Context c1, String rno, String fn, String ln,String e,String c,String add,String ten,String twe,String grad,String tech,String fat,String pass)
    {
        String serverURL = "https://bhishambajaj1999.000webhostapp.com/server_try.php";
        Map<String, String> params = new HashMap<String, String>();
        params.put("t1", rno);
        params.put("t2", fn);
        params.put("t3",ln );
        params.put("t4",e );
        params.put("t5",c );
        params.put("t6",add );
        params.put("t7",ten );
        params.put("t8",twe );
        params.put("t9",grad );
        params.put("t10",tech );
        params.put("t11",fat );
        params.put("t12",pass );
        post(serverURL, params);
    }

    public static void post(String serverurl, Map<String, String> params) {
        URL u = null;
        try {
            u = new URL(serverurl);
        } catch (MalformedURLException e) {
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, String>> it = params.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> p = it.next();
            sb.append(p.getKey()).append("=").append(p.getValue());
            if (it.hasNext()) {
                sb.append('&');
            }
        }
        String body = sb.toString();
        byte[] bytes = body.getBytes();
        HttpURLConnection uc = null;
        try {
            uc = (HttpURLConnection) u.openConnection();
            uc.setDoOutput(true);
            uc.setUseCaches(false);
            uc.setFixedLengthStreamingMode(bytes.length);
            uc.setRequestMethod("POST");
            uc.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded;charset=UTF-8");
            OutputStream out = uc.getOutputStream();
            out.write(bytes);
            out.close();
            int status = uc.getResponseCode();
            if (status != 200) {
                Log.d("invalid request code ", "status s " + status);
            }
        }
        catch (Exception e) {
            Log.d("error",""+ e.getMessage());
        }

    }
}
