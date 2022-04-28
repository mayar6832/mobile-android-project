package com.example.myapplication44;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LogOut extends AppCompatActivity {

    SharedPreferences sh;
    TextView price;
    String data1;
    Button btn;
    TextView price2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_out);


        price2 = findViewById(R.id.showcost2);
        Intent intent = getIntent();
        String num = intent.getStringExtra("priceroom");
       /* int pricenight=Integer.parseInt(num);
        Intent intent2 = getIntent();
        String numrom = intent2.getStringExtra("NumberOfRooms");
        int numnights=Integer.parseInt(numrom);
        int totalnights=numnights*pricenight;
        String totalprice=Integer.toString(totalnights);*/
        price2.setText(num);

        btn = findViewById(R.id.btn);
        Intent logintent=new Intent(this,ChooseActivity.class);

        TextView t1 = findViewById(R.id.showcost);
        sh = getSharedPreferences("myfile", MODE_PRIVATE);
        if (sh.contains("cost")) {
            t1.setText(sh.getString("cost", ""));
        }


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("notify", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(LogOut.this, "notify");
                builder.setContentTitle("Checkout Complete");
                builder.setContentText("Booking has been Varified");
                builder.setSmallIcon(R.drawable.nimg);
                builder.setAutoCancel(true);
                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(LogOut.this);
                managerCompat.notify(0, builder.build());
                startActivity(logintent);

            }
        });

    }
}