package com.example.samsung.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Message;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class RegisterActivity extends AppCompatActivity {
//内部存储数据的例子
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button btn_return=(Button)findViewById(R.id.btn_return);
        btn_return.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            finish();
            }
        });
        final EditText et_realname=(EditText)findViewById(R.id.et_realname) ;
        final EditText et_tel=(EditText)findViewById(R.id.et_tel) ;
        final Spinner sp_rel=(Spinner) findViewById(R.id.sp_rel) ;
        final EditText et_remark=(EditText)findViewById(R.id.et_remark) ;
        final TextView tv_info=(TextView)findViewById(R.id.tv_info) ;
        Button btn_subit=(Button)findViewById(R.id.btn_subit);
        btn_subit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String realname=et_realname.getText().toString();
                String tel=et_tel.getText().toString();
                String rel=sp_rel.getSelectedItem().toString();
                String remark=et_remark.getText().toString();

                User user=new User(realname,tel,rel,remark);//将数据存储到用户类的实例中
                DBHelper helper=new DBHelper(RegisterActivity.this);//实例化操作数据库的类对象
                Boolean exist_tel=helper.checkTelExist(tel);
                if (exist_tel==false)
                {
                    helper.insert(user);//将用户类中的实例数据提交到数据库中
                    Intent intent=new Intent();
                    intent.setClass(RegisterActivity.this,RegReadActivity.class);
                    startActivity(intent);
                }
                else
                {
                    tv_info.setTextColor(Color.RED);
                    tv_info.setText("该电话号码已经存在，请重新输入！");
                    tv_info.setVisibility(View.VISIBLE);

                }

               /*数据存储在内部文件中
                String reg_content=username+" "+tel+" "+rel+" "+remark;
                FileOutputStream fos=null;
                try{
                    fos=openFileOutput("register",MODE_PRIVATE|MODE_APPEND);//获得文件输出流MODE_PRIVATE表示只能被创建它的人访问；MODE_APPEND表示追加模式；
                    fos.write(reg_content.getBytes());//保存用户名和密码
                    fos.flush();//清除缓存
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(fos!=null){
                        try{
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                */


            }
        });
    }
}
