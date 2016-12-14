package com.example.samsung.myapplication;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class userInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        DBHelper helper=new DBHelper(this);
        ListView lv=(ListView)findViewById(R.id.userList);
        //ArrayAdapter<String> fileList=new ArrayAdapter<String>(this,R.layout.list_item,helper.queryAll());
        ArrayAdapter<String> fileList=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,helper.queryAll());
        lv.setAdapter(fileList);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String result =parent.getItemAtPosition(position).toString();
                Toast.makeText(userInfoActivity.this,result,Toast.LENGTH_SHORT).show();
            }
        });
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
