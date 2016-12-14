package com.example.samsung.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import static com.example.samsung.myapplication.R.drawable.eye;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        //搜索按钮
        AutoCompleteTextView actv_tel=(AutoCompleteTextView)findViewById(R.id.actv_tel);
        DBHelper helper=new DBHelper(this);
        ArrayAdapter<String> fileList=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,helper.queryTel());
        actv_tel.setAdapter(fileList);

        Button btn_register=(Button)findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        Button button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RegExternalStorageActivity.class);
                startActivity(intent);
            }
        });
        Button button3=(Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ReadRawFileActivity.class);
                startActivity(intent);
            }
        });
        Button btn_user_detail=(Button)findViewById(R.id.btn_user_detail);
        btn_user_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,userInfoActivity.class);
                startActivity(intent);
            }
        });
        Button btn_search_tel=(Button)findViewById(R.id.btn_seach_tel);
        btn_search_tel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,searchActivity.class);
                startActivity(intent);
            }
        });

        final ActionBar actionBar = getSupportActionBar();//etActionBar();不行，要用 getSupportActionBar();才能正常使用动作栏
        final Button button5=(Button)findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(actionBar.isShowing()) {
                    actionBar.hide();
                    button5.setText("显示动作栏");
                    //actionBar.setDisplayShowTitleEnabled(false);//显示或隐藏动作栏的标题
                    //actionBar.setDisplayUseLogoEnabled(true);//显示或隐藏动作栏的LOGO
                }else {
                    actionBar.show();
                    button5.setText("隐藏动作栏");
                    actionBar.setDisplayHomeAsUpEnabled(true);
                    //actionBar.setDisplayShowTitleEnabled(true);
                    //actionBar.setDisplayUseLogoEnabled(true);
                }
            }
        });
    }
    //创建菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.action_item,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Toast.makeText(this,"选择："+item.getTitle(),Toast.LENGTH_LONG).show();
        return true;
    }
}
