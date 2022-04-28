package com.example.myapplication44;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseActivity extends AppCompatActivity {
Button flight;
Button hotel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        flight=(Button) findViewById(R.id.button1);
        hotel=(Button) findViewById(R.id.button2);
        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {
                Intent intent1=new Intent(view.getContext(),MainActivity.class);
                startActivity(intent1);
            }
        });

        flight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4=new Intent(view.getContext(),SearchHotel.class);
                startActivity(intent4);

            }
        });
    }

}