package com.bhisham.vtop_lite;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    EditText t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
public void testing(View view){
    t1=(EditText)findViewById(R.id.t1);
    t2=(EditText)findViewById(R.id.t2);
    boolean st=true;
    if(t1.getText().toString().length()==0 )
    {
        t1.setError("Enter Username");
        st=false;
    }
    if(t2.getText().toString().length()==0){
        t2.setError("Enter Password");

        st=false;
    }
    if(st==true){
        if(CheckConnection.isNetworkAvailable(LoginActivity.this)){

        }
    }

}
class StudentLogin extends AsyncTask<String,Void,String>{
        public StudentLogin(){

        }

    @Override
    protected String doInBackground(String... params) {
            String user,p;
            user=params[0];
            p=params[1];
        String serverUrl="https://bhishambajaj1999.000webhostapp.com/newfetch.php";
        InputStream is=null;
        List<NameValuePair> nameValuePairs=new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("t1",user));
        nameValuePairs.add(new BasicNameValuePair("t2",p));
String result=null;
try{
    HttpClient httpClient=new DefaultHttpClient();
    HttpPost httpPost=new HttpPost(serverUrl);
    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

    HttpResponse response=httpClient.execute(httpPost);
    HttpEntity entity=response.getEntity();
    is=entity.getContent();
    BufferedReader reader=new BufferedReader(new InputStreamReader(is,"UTF-8"));
    StringBuilder sb=new StringBuilder();
    String line=null;
    while ((line=reader.readLine())!=null){
        sb.append(line+"\n");
    }
    result=sb.toString();
}
catch (Exception e){
e.printStackTrace();
}
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        //super.onPostExecute(s);
String s= result.trim();
        if (s.equalsIgnoreCase("welcome")){
            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
            intent.putExtra("username", t1.getText().toString());
            startActivity(intent);
        }
        else {

            Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_SHORT).show();
        }

    }
}
}
