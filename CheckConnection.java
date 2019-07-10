package com.bhisham.vtop_lite;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class CheckConnection {
    public static boolean isNetworkAvailable(Context context){
boolean haveConnectedWifi=false;
boolean haveConnectedMobile=false;
try{
    ConnectivityManager cm=(ConnectivityManager) ((Activity)context).getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo netInfo[]=cm.getAllNetworkInfo();
    for(NetworkInfo ni: netInfo){
        if(ni.getTypeName().equalsIgnoreCase("WIFI"))
            if(ni.isConnected())
                haveConnectedWifi=true;
        if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
            if (ni.isConnected())
                haveConnectedMobile = true;
    }

}
catch (Exception e){

}
return haveConnectedMobile || haveConnectedWifi;
    }
}
