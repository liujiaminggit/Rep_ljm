package com.example.samsung.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

public class searchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        AutoCompleteTextView actv_tel=(AutoCompleteTextView)findViewById(R.id.actv_tel);
        DBHelper helper=new DBHelper(this);
        ArrayAdapter<String> fileList=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,helper.queryTel());
        actv_tel.setAdapter(fileList);
    }
}
