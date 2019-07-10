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

public class SubjectActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listView;
private String[] subjects;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        toolbar=(Toolbar)findViewById(R.id.ToolbarSubject);
        listView=(ListView)findViewById(R.id.lvSubject);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Subjects(4th Semester)");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupListView();
    }
    private void setupListView(){
        subjects=getResources().getStringArray(R.array.Subjects);
        SubjectAdapter adp=new SubjectAdapter(this,subjects);
        listView.setAdapter(adp);
    }
    public class SubjectAdapter extends BaseAdapter{
        private Context mcontext;
        private LayoutInflater layoutInflater;
        private TextView Subject;
        private String[] SubjectArray;
        public SubjectAdapter(Context context,String[] Subject){
            mcontext=context;
            SubjectArray=Subject;
            layoutInflater=LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return SubjectArray.length;
        }

        @Override
        public Object getItem(int i) {
            return SubjectArray[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view==null){
                view=layoutInflater.inflate(R.layout.activity_subject_single_item,null);
            }
            Subject=(TextView)view.findViewById(R.id.tvSubject);
            Subject.setText(SubjectArray[i]);
            LetterImageView letterImageView;
            letterImageView=(LetterImageView)view.findViewById(R.id.ivLetterSubject);
            letterImageView.setOval(true);
            letterImageView.setLetter(SubjectArray[i].charAt(0));






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
