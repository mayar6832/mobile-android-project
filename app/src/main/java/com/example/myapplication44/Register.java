package com.example.myapplication44;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.regex.Pattern;


public class Register extends AppCompatActivity {
Button log;
Button reg;
EditText ed1;
EditText ed2;
EditText ed3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("notify", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }


        ed1=(EditText) findViewById(R.id.username);
        ed2=(EditText) findViewById(R.id.useremail);
        ed3=(EditText) findViewById(R.id.userpassword);
        log=(Button) findViewById(R.id.clichlogin);
        reg=(Button)findViewById(R.id.btnREG) ;
        log.setPaintFlags(log.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        Intent golog= new Intent(this,LogIn.class);
        Intent goreg= new Intent(this,LogIn.class);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean checker=true;
                    if(TextUtils.isEmpty(ed1.getText().toString())){
                        ed1.setError("Username is required!");
                        checker=false;
                    }
                    if(TextUtils.isEmpty(ed2.getText().toString())){
                        ed2.setError("Email is required!");
                        checker=false;
                    }
                    if(!Patterns.EMAIL_ADDRESS.matcher(ed2.getText().toString()).matches()){
                        ed2.setError("Pleas enter a valid email address");
                        checker=false;
                    }
                    if(TextUtils.isEmpty(ed3.getText().toString())){
                        ed3.setError("Password is required!");
                        checker=false;
                    }
                    if(checker==true){
                        NotificationCompat.Builder builder = new NotificationCompat.Builder(Register.this, "notify");
                        builder.setContentTitle("Registration Complete");
                        builder.setContentText("Login is Available");
                        builder.setSmallIcon(R.drawable.nimg);
                        builder.setAutoCancel(true);
                        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(Register.this);
                        managerCompat.notify(0,builder.build());
                        startActivity(goreg);
                    }


            }





        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(golog);
            }
        });
    }




}