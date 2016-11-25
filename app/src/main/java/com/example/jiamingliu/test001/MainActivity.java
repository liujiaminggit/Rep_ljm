package com.example.jiamingliu.test001;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView layout=(TextView)findViewById(R.id.tvPWD);
        layout.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int x=(int)motionEvent.getX();
        int y=(int)motionEvent.getY();
        Toast.makeText(this,"触摸屏幕位置为:(" + x + "," + y + ")", Toast.LENGTH_LONG).show();
        return true;

    }
}
