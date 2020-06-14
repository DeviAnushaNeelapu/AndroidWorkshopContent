package com.example.brtest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
       String action = intent.getAction();
       switch (action){
           case Intent.ACTION_POWER_CONNECTED:
               Toast.makeText(context,
                       "Power is Conncted", Toast.LENGTH_SHORT).show();
               break;
           case Intent.ACTION_POWER_DISCONNECTED:
               Toast.makeText(context,
                       "Power Disconnected", Toast.LENGTH_SHORT).show();
               break;
           case Intent.ACTION_AIRPLANE_MODE_CHANGED:
               Toast.makeText(context,
                       "Airplain Mode Changed", Toast.LENGTH_SHORT).show();
           case MainActivity.CUSTOM_ACTION:
               Toast.makeText(context,
                       "This is Custom BR", Toast.LENGTH_SHORT).show();


       }

    }
}
