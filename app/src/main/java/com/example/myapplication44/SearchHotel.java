package com.example.myapplication44;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SearchHotel extends AppCompatActivity {
    Button btn, btn2, btn3,btn4 , button6;
    TextView v1;
    int num=0;
    TextView mDateFormat,mDateFormat2;
    DatePickerDialog.OnDateSetListener onDateSetListener;

    DatePickerDialog.OnDateSetListener onDateSetListener2;

    private Spinner spinner, spinner2 ,spinner3;
    TextView textview_0;


    private Button dateButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_hotel);


        spinner = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        spinner3=   findViewById(R.id.spinner3);
        btn2= findViewById(R.id.buttons);
        btn3= findViewById(R.id.buttons2);
        btn4= findViewById(R.id.buttons3);
        button6= findViewById(R.id.button6);


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn2.setTextSize(18);
                btn2.setTextColor(Color.parseColor("#FFFF00"));

                btn3.setEnabled(false);
                btn4.setEnabled(false);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn3.setTextSize(18);
                btn3.setTextColor(Color.parseColor("#FFFF00"));

                btn2.setEnabled(false);
                btn4.setEnabled(false);

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn4.setTextSize(18);
                btn4.setTextColor(Color.parseColor("#FFFF00"));

                btn2.setEnabled(false);
                btn3.setEnabled(false);
            }
        });



        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);


        final Calendar calendar2 = Calendar.getInstance();
        int year2 = calendar.get(Calendar.YEAR);
        int month2 = calendar.get(Calendar.MONTH);
        int day2 = calendar.get(Calendar.DAY_OF_MONTH);


        mDateFormat=findViewById(R.id.dateformat);
        mDateFormat2=findViewById(R.id.dateformat2);

        mDateFormat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog= new DatePickerDialog(v.getContext()
                        , android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        onDateSetListener, year , month ,day );
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                datePickerDialog.show();


            }
        });

        mDateFormat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog2= new DatePickerDialog(v.getContext()
                        , android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        onDateSetListener2, year2 , month2 ,day2 );
                datePickerDialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                datePickerDialog2.show();


            }
        });
        onDateSetListener= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayofmonth) {

                month=month+1;
                String date = dayofmonth+"/"+month+"/"+year;

                mDateFormat.setText(date);

            }
        };

        onDateSetListener2= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year2, int month2, int dayofmonth2) {

                month2=month2+1;
                String date2 = dayofmonth2+"/"+month2+"/"+year2;

                mDateFormat2.setText(date2);

            }
        };



        btn = findViewById(R.id.button1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String country1= spinner.getSelectedItem().toString();
                String country2= spinner2.getSelectedItem().toString();

                Intent intent = new Intent (view.getContext(),Flights.class);

                intent.putExtra("outfrom",country1);
                intent.putExtra("outto",country2);
                startActivity(intent);
            }
        });



        List<String> categories = new ArrayList<>();
        List<String> categories2 = new ArrayList<>();

        List<String> categories3 = new ArrayList<>();

        categories.add(0,"Egypt");
        categories.add("Turkey");
        categories.add("Dubai");
        categories.add("Tunisia");


        categories2.add(0,"Qatar");
        categories2.add("USA");
        categories2.add("Russia");
        categories2.add("India");


        categories3.add(0,"Economy");
        categories3.add("First Class");
        categories3.add("Business Class");



        ArrayAdapter<String> dataAdapter;

        ArrayAdapter<String> dataAdapter2;


        ArrayAdapter<String> dataAdapter3;


        dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,categories);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);

        dataAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,categories2);

        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner2.setAdapter(dataAdapter2);


        dataAdapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,categories3);

        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner3.setAdapter(dataAdapter3);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (parent.getItemAtPosition(position).equals("choose category"))
                {

                }
                else{
                    String item = parent.getItemAtPosition(position).toString();
                  //  Toast.makeText(parent.getContext(), "Selected : " + item , Toast.LENGTH_SHORT).show();

                }
            }
            public void  Nothing(AdapterView<?> parent){

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent2, View view, int position2, long id2) {

                if (parent2.getItemAtPosition(position2).equals("choose category"))
                {

                }
                else{
                    String item = parent2.getItemAtPosition(position2).toString();
                  //  Toast.makeText(parent2.getContext(), "Selected : " + item , Toast.LENGTH_SHORT).show();
                }
            }
            public void  Nothing(AdapterView<?> parent2){

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent3, View view, int position3, long id3) {

                if (parent3.getItemAtPosition(position3).equals("choose category"))
                {

                }
                else{
                    String item = parent3.getItemAtPosition(position3).toString();
                   // Toast.makeText(parent3.getContext(), "Selected : " + item , Toast.LENGTH_SHORT).show();
                }
            }
            public void  Nothing(AdapterView<?> parent3){

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });









        textview_0 = findViewById(R.id.textView12);
        textview_0.setText("" +num);



        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);

        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);


        ArrayAdapter <String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.back));

        ArrayAdapter <String> adapter3 = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Levels));





    }








    public void increment (View view){
        num++;
        textview_0.setText("" +num);

    }
    public void decrement (View view){

        if (num<=0) {
            num=0;}
        else{
            num--;
        }
        textview_0.setText("" +num);
    }
}