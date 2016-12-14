package com.example.samsung.myapplication;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;

public class RegExternalStorageActivity extends AppCompatActivity {
//外部存储的例子
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        TextView tv=(TextView)findViewById(R.id.message);
        File root= Environment.getExternalStorageDirectory();//获得SD卡根路径
        if(root.exists()&&root.canWrite()){
            File file=new File(root,"DemoFile.png");
            try {
                if(file.createNewFile()){
                    tv.setText(file.getName()+"创建成功！");
                }else{
                    tv.setText(file.getName()+"创建失败！");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            tv.setText("！SD卡不存在或者不可写");
        }
    }
}
