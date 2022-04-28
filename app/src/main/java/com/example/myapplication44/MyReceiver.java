package com.example.myapplication44;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if (Intent.ACTION_TIMEZONE_CHANGED.equals(intent.getAction()))
            Toast.makeText(context, "Time Zone Changed", Toast.LENGTH_LONG).show();
    }
}