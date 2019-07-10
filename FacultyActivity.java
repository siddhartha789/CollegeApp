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

public class FacultyActivity extends AppCompatActivity {
    private ListView listView;
    private Toolbar toolbar;
    private String[] faculty;
    private String[] staff;
    private String[] designation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);
        toolbar = (Toolbar) findViewById(R.id.ToolbarFaculty);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Faculties of CSE Department");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listView=(ListView)findViewById(R.id.lvFaculty);
        setUpListView();
    }
    private void setUpListView(){
       String[] faculty=getResources().getStringArray(R.array.Faculty);
       String[] staff=getResources().getStringArray(R.array.Staff);
       String[] designation=getResources().getStringArray(R.array.Designation);
       FacultyAdapter adapter=new FacultyAdapter(this,faculty,staff,designation);
       listView.setAdapter(adapter);



    }
    public class FacultyAdapter extends BaseAdapter{
        private Context mcontext;
        private LayoutInflater layoutInflater;
        private TextView faculty,staff,designation;
        private String[] FacultyArray;
        private String[] StaffArray;
        private String[] DesignationArray;
        public FacultyAdapter(Context context,String[] faculty,String[] staff,String[] designation){
            mcontext=context;
            FacultyArray=faculty;
            StaffArray=staff;
            DesignationArray=designation;
         layoutInflater=LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return FacultyArray.length;
        }

        @Override
        public Object getItem(int i) {
            return FacultyArray[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view==null){
                view=layoutInflater.inflate(R.layout.faculty_single_item,null);
            }
            faculty=(TextView)view.findViewById(R.id.tvFaculty);
            faculty.setText(FacultyArray[i]);
            staff=(TextView)view.findViewById(R.id.tvStaff);
            staff.setText(StaffArray[i]);
            designation=(TextView)view.findViewById(R.id.tvDesignation);
            designation.setText(DesignationArray[i]);
            LetterImageView letterImageView;
            letterImageView=(LetterImageView)view.findViewById(R.id.ivLetterFaculty);
            letterImageView.setOval(true);
            letterImageView.setLetter(FacultyArray[i].charAt(0));


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
