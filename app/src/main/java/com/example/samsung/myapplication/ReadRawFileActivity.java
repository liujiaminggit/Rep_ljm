package com.example.samsung.myapplication;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class ReadRawFileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        TextView tv=(TextView)findViewById(R.id.message);
        Resources resources=getResources();//获取资源实例
        InputStream is=null;
        is=resources.openRawResource(R.raw.demo_raw);
        byte[] buffer;
        try {
            buffer=new byte[is.available()];
            is.read(buffer);
            String result=new String(buffer,"utf-8");
            tv.setText(result.toString());
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
