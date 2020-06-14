package com.example.brtest;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String CUSTOM_ACTION="com.example.brtest";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyReceiver receiver=new MyReceiver();
        IntentFilter filter=new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        filter.addAction(CUSTOM_ACTION);
        this.registerReceiver(receiver,filter);
    }

    public void sendCustom(View view) {
        Intent i =new Intent(CUSTOM_ACTION);
        sendBroadcast(i);

    }
}
