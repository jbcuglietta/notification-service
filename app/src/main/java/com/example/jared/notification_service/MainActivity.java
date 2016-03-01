package com.example.jared.notification_service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startBtn = (Button) findViewById(R.id.startForegroundBtn);
        Button stopBtn = (Button) findViewById(R.id.stopForegroundBtn);
        startBtn.setOnClickListener(onClickListener);
        stopBtn.setOnClickListener(onClickListener);




    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.startForegroundBtn:
                    Intent startIntent = new Intent(MainActivity.this,NotificationService.class);
                    startIntent.setAction(CustomActions.START_FOREGROUND_SERVICE);
                    startService(startIntent);
                    break;
                case R.id.stopForegroundBtn:
                    Intent stopIntent = new Intent(MainActivity.this,NotificationService.class);
                    stopIntent.setAction(CustomActions.STOP_FOREGROUND_SERVICE);
                    startService(stopIntent);
                    break;
                default:
                    break;
            }
        }
    };
}
