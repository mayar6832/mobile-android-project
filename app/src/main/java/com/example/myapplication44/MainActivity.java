package com.example.myapplication44;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
CalendarView calendarView;
TextView ques1;
CalendarView calendarViewOut;
TextView ques2;
TextView count1;
ImageButton add1;
ImageButton sub1;
TextView count2;
ImageButton add2;
ImageButton sub2;
TextView count3;
ImageButton add3;
ImageButton sub3;
Button search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        search=(Button)findViewById(R.id.apply) ;
        calendarView=(CalendarView) findViewById(R.id.calenderview);
        ques1=(TextView) findViewById(R.id.ques1);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String date=(i1 + 1) + "/" + i2 + "/" + i;
                ques1.setText(date);
            }
        });
        calendarViewOut=(CalendarView) findViewById(R.id.calenderviewout);
        ques2=(TextView) findViewById(R.id.ques2);
        calendarViewOut.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String dateout=(i1 + 1) + "/" + i2 + "/" + i;
                ques2.setText(dateout);
            }
        });
        count1=(TextView) findViewById(R.id.ques6);
        add1=(ImageButton) findViewById(R.id.add1);
        sub1=(ImageButton) findViewById(R.id.sub1);

        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1= Integer.toString(Integer.parseInt(count1.getText().toString())+1) ;
                count1.setText(num1);
            }
        });
        sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(count1.getText().toString())!=1) {
                    String num1 = Integer.toString(Integer.parseInt(count1.getText().toString()) - 1);
                    count1.setText(num1);
                }
            }
        });

        count2=(TextView) findViewById(R.id.ques7);
        add2=(ImageButton) findViewById(R.id.add2);
        sub2=(ImageButton) findViewById(R.id.sub2);
        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num2= Integer.toString(Integer.parseInt(count2.getText().toString())+1) ;
                count2.setText(num2);
            }
        });
        sub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(count2.getText().toString())!=1) {
                    String num2 = Integer.toString(Integer.parseInt(count2.getText().toString()) - 1);
                    count2.setText(num2);
                }
            }
        });
        count3=(TextView) findViewById(R.id.ques8);
        add3=(ImageButton) findViewById(R.id.add3);
        sub3=(ImageButton) findViewById(R.id.sub3);
        add3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num3= Integer.toString(Integer.parseInt(count3.getText().toString())+1) ;
                count3.setText(num3);
            }
        });
        sub3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(count3.getText().toString())!=0) {
                    String num3 = Integer.toString(Integer.parseInt(count3.getText().toString()) - 1);
                    count3.setText(num3);
                }
            }
        });



        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextpage=new Intent(view.getContext(),Hotel_Output.class);
                String roomnum = count1.getText().toString();
                nextpage.putExtra("NumberOfRooms",roomnum);
                startActivity(nextpage);
            }
        });


    }


}