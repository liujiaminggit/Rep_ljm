package com.example.samsung.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RegReadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_read);
        /*
        FileInputStream fis=null;
        byte[] buffer=null;
        try{
            fis=openFileInput("register");
            buffer=new byte[fis.available()];
            fis.read(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        */

        DBHelper helper=new DBHelper(RegReadActivity.this);
        User user=helper.query(1);
        TextView tv_realname=(TextView)findViewById(R.id.tv_username);
        TextView tv_tel=(TextView)findViewById(R.id.tv_tel);
        TextView tv_rel=(TextView)findViewById(R.id.tv_rel);
        TextView tv_remark=(TextView)findViewById(R.id.tv_remark);
/*
        String data=new String(buffer);
        String username=data.split(" ")[0];
        String tel=data.split(" ")[1];
        String rel=data.split(" ")[2];
        String remark =data.split(" ")[3];
*/
        tv_realname.setText(user.getRealname());
        tv_tel.setText(user.getTel());
        tv_rel.setText(user.getRel());
        tv_remark.setText(user.getRemark());

    }
}
