package com.example.notificationtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b;
    NotificationManager manager;

    public static final String PRIMARY_CHANNEL_ID=
            "com.example.notificationtest";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.notificationButton);
        manager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);


        if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.O) {
            // Create a NotificationChannel
            NotificationChannel channel = new NotificationChannel(PRIMARY_CHANNEL_ID,
                    "Mastan Notification",NotificationManager.IMPORTANCE_HIGH);
            channel.enableLights(true);
            channel.setLightColor(Color.RED);
            channel.enableVibration(true);
            channel.setDescription("Notification from Mascot");
            manager.createNotificationChannel(channel);
        }


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification();

            }
        });
    }

    public void sendNotification(){
        NotificationCompat.Builder builder = new
                NotificationCompat.Builder(this,PRIMARY_CHANNEL_ID);

        builder.setSmallIcon(R.drawable.notification_icon);
        builder.setContentTitle("My First Notification");
        builder.setContentText("This notification created by the Mastan from APSSDC");
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);
        builder.addAction(R.drawable.notification_icon,"Reply",null);
        builder.addAction(R.drawable.notification_icon,"Cancel",null);
        builder.setColor(Color.RED);
        manager.notify(22,builder.build());

    }
}
