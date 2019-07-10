package com.bhisham.vtop_lite;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bhisham.vtop_lite.Utils.LetterImageView;

public class DayDetail extends AppCompatActivity {
    private ListView listView;
    private android.support.v7.widget.Toolbar toolbar;
public static String[] Monday;
public static String[] Tuesday;
     public static String[] Wednesday;
    public static String[] Thursday;
    public static String[] Friday;
    public static String[] Saturday;
    public static String[] time1;
    public static String[] time2;
    public static String[] time3;
    public static String[] time4;
    public static String[] time5;
    public static String[] time6;
    public static String[] loc1;
    public static String[] loc2;
    public static String[] loc3;
    public static String[] loc4;
    public static String[] loc5;
    public static String[] loc6;

    private String[] PrefferedDay;
private String[] PrefferedTime;
private String[] PrefferedLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_detail);
        listView=(ListView)findViewById(R.id.lvDay);
        toolbar=(Toolbar)findViewById(R.id.ToolbarDay);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(WeekActivity.sharedPreferences.getString(WeekActivity.SEL_DAY,null));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupListView();
    }
    private void setupListView(){
        Monday=getResources().getStringArray(R.array.Monday);
        Tuesday=getResources().getStringArray(R.array.Tuesday);
        Wednesday=getResources().getStringArray(R.array.Wednesday);
        Thursday=getResources().getStringArray(R.array.Thursday);
        Friday=getResources().getStringArray(R.array.Friday);
        Saturday=getResources().getStringArray(R.array.Saturday);
        time1=getResources().getStringArray(R.array.time1);
        time2=getResources().getStringArray(R.array.time2);
        time3=getResources().getStringArray(R.array.time3);
        time4=getResources().getStringArray(R.array.time4);
        time5=getResources().getStringArray(R.array.time5);
        time6=getResources().getStringArray(R.array.time6);
        loc1=getResources().getStringArray(R.array.loc1);
        loc2=getResources().getStringArray(R.array.loc2);
        loc3=getResources().getStringArray(R.array.loc3);
        loc4=getResources().getStringArray(R.array.loc4);
        loc5=getResources().getStringArray(R.array.loc5);
        loc6=getResources().getStringArray(R.array.loc6);


        String selected_day=WeekActivity.sharedPreferences.getString(WeekActivity.SEL_DAY,null);

        if(selected_day.equalsIgnoreCase("Monday")){
         PrefferedDay=Monday;
         PrefferedTime=time1;
         PrefferedLocation=loc1;
        }
        else if(selected_day.equalsIgnoreCase("Tuesday")){
            PrefferedDay=Tuesday;
            PrefferedTime=time2;
            PrefferedLocation=loc2;

        }
        else if(selected_day.equalsIgnoreCase("Wednesday")){
            PrefferedDay=Wednesday;
            PrefferedTime=time3;
            PrefferedLocation=loc3;

        }
        else if(selected_day.equalsIgnoreCase("Thursday")){
            PrefferedDay=Thursday;
            PrefferedTime=time4;
            PrefferedLocation=loc4;

        }
        else if(selected_day.equalsIgnoreCase("Friday")){
            PrefferedDay=Friday;
            PrefferedTime=time5;
            PrefferedLocation=loc5;

        }
        else  {
            PrefferedDay=Saturday;
            PrefferedTime=time6;
            PrefferedLocation=loc6;

        }
        SimpleAdapter simpleAdapter=new SimpleAdapter(DayDetail.this,PrefferedDay,PrefferedTime,PrefferedLocation);
        listView.setAdapter(simpleAdapter);

    }
    public class SimpleAdapter extends BaseAdapter {
        private Context mcontext;
        private LayoutInflater layoutInflater;
        private TextView subject,time,location;
        private String[] subjectArray;
        private String[] timeArray;
        private String[] locationArray;
        private LetterImageView letterImageView;
        public SimpleAdapter(Context context,String[] subjectArray,String[] timeArray,String[] locationArray){
            mcontext=context;
            this.subjectArray=subjectArray;
            this.timeArray=timeArray;
            this.locationArray=locationArray;
            layoutInflater=LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return subjectArray.length;
        }

        @Override
        public Object getItem(int i) {
            return subjectArray[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view==null){
                view=layoutInflater.inflate(R.layout.day_detail_single_item,null);
            }
            subject=(TextView)view.findViewById(R.id.tvDayDetails);
            time=(TextView)view.findViewById(R.id.tvtime);
            location=(TextView)view.findViewById(R.id.tvLocation);
            letterImageView=(LetterImageView)view.findViewById(R.id.ivDayDetails);
            subject.setText(subjectArray[i]);
            time.setText(timeArray[i]);
            location.setText(locationArray[i]);

            letterImageView.setOval(true);
            letterImageView.setLetter(subjectArray[i].charAt(0));

            return view;
        }
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
