package com.bhisham.vtop_lite;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bhisham.vtop_lite.Utils.LetterImageView;

public class WeekActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listView;
    public static SharedPreferences sharedPreferences;
    public static String SEL_DAY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week);
        listView=(ListView)findViewById(R.id.lvWeek);
        toolbar=(android.support.v7.widget.Toolbar)findViewById(R.id.ToolbarWeek);
        sharedPreferences=getSharedPreferences("MY_DAY",MODE_PRIVATE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Working Days");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupListView();
    }
    private void setupListView(){
        String [] week=getResources().getStringArray(R.array.Week);
        WeekAdapter adapter=new WeekAdapter(this,R.layout.activity_week_single_item,week);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 switch (i){
                     case 0: {
                         startActivity(new Intent(WeekActivity.this,DayDetail.class));

                         sharedPreferences.edit().putString(SEL_DAY, "Monday").apply();
                         break;
                     }
                     case 1: {
                         startActivity(new Intent(WeekActivity.this,DayDetail.class));
                         sharedPreferences.edit().putString(SEL_DAY, "Tuesday").apply();
                         break;
                     }
                     case 2: {
                         startActivity(new Intent(WeekActivity.this,DayDetail.class));
                         sharedPreferences.edit().putString(SEL_DAY, "Wednesday").apply();
                         break;
                     }
                     case 3: {
                         startActivity(new Intent(WeekActivity.this,DayDetail.class));
                         sharedPreferences.edit().putString(SEL_DAY, "Thurday").apply();
                         break;
                     }
                     case 4: {
                         startActivity(new Intent(WeekActivity.this,DayDetail.class));
                         sharedPreferences.edit().putString(SEL_DAY, "Friday").apply();
                         break;
                     }
                     case 5: {
                         startActivity(new Intent(WeekActivity.this,DayDetail.class));
                         sharedPreferences.edit().putString(SEL_DAY, "Saturday").apply();
                         break;
                     }
                         default:break;
                 }
            }
        });


    } 

    public class WeekAdapter extends ArrayAdapter{
private int resource;
private LayoutInflater layoutInflater;
private String[] week;
        public WeekAdapter(Context context, int resource,String[] objects) {
            super(context, resource,objects);
            this.resource=resource;
            this.week=objects;
            layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
ViewHolder  holder;
try {
    if (convertView == null) {
        holder = new ViewHolder();
        convertView = layoutInflater.inflate(resource, null);
        holder.ivlogo =  (LetterImageView)convertView.findViewById(R.id.ivLetter);
        holder.tvweek =  (TextView)convertView.findViewById(R.id.tvWeek);
        convertView.setTag(holder);

    } else {
        holder = (ViewHolder) convertView.getTag();
    }
    holder.ivlogo.setOval(true);
    holder.ivlogo.setLetter(week[position].charAt(0));
    holder.tvweek.setText(week[position]);
}
catch (Exception e){
    e.printStackTrace();
}
            return convertView;

        }
        class ViewHolder{
            private LetterImageView ivlogo;
            private TextView tvweek;
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
