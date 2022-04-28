package com.example.myapplication44;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Hotel_Output extends AppCompatActivity {
    String s1[], s2[] ,s3[];
    int image [] ={R .drawable._2,R .drawable ._1,R .drawable._3,R.drawable._4};
    int star   = R.drawable.star2 ;
    RecyclerView recyclerView;
    the_adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_output);
        s1 =getResources().getStringArray(R .array.Hotels_name);
        s2 =getResources().getStringArray(R .array.Hotels_rate);
        s3 =getResources().getStringArray(R .array.Hotels_price);
        recyclerView = findViewById(R .id.recycler);
        adapter = new the_adapter(this,image,star,s1,s2,s3);
        //الصفحه اللى انا فيها
        recyclerView .setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
Intent intent1=getIntent();
String room=intent1.getStringExtra("NumberOfRooms");
Intent intent2=new Intent(this,LogOut.class);
intent2.putExtra("roomsnum",room);


    }
}