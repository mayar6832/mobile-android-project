package com.example.myapplication44;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Flights extends AppCompatActivity {
    Button b1,b2,b3,b4;
    TextView t1,t2,t3,t4;
    TextView from1,from2,from3,from4;
    TextView to1,to2,to3,to4;
    ImageView imgback,s1,s2,s3,s4;
    SharedPreferences sh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flights);


        sh = getSharedPreferences("myfile",MODE_PRIVATE);

        Intent next = new Intent(this,LogOut.class);
        Intent back = new Intent(this,SearchHotel.class);
        Intent search1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.egyptair.com/"));
        Intent search2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.turkishairlines.com/"));
        Intent search3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.etihad.com/"));
        Intent search4 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.emirates.com/"));


        b1=findViewById(R.id.flight1_btm);
        b2=findViewById(R.id.flight2_btm);
        b3=findViewById(R.id.flight3_btm);
        b4=findViewById(R.id.flight4_btm);

        imgback=findViewById(R.id.backimage);
        s1=findViewById(R.id.flight1_search);
        s2=findViewById(R.id.flight2_search);
        s3=findViewById(R.id.flight3_search);
        s4=findViewById(R.id.flight4_search);

        t1=findViewById(R.id.flight1_cost);
        t2=findViewById(R.id.flight2_cost);
        t3=findViewById(R.id.flight3_cost);
        t4=findViewById(R.id.flight4_cost);

        from1=findViewById(R.id.flight1_city_1);
        from2=findViewById(R.id.flight2_city_1);
        from3=findViewById(R.id.flight3_city_1);
        from4=findViewById(R.id.flight4_city_1);

        to1=findViewById(R.id.flight1_city_2);
        to2=findViewById(R.id.flight2_city_2);
        to3=findViewById(R.id.flight3_city_2);
        to4=findViewById(R.id.flight4_city_2);

        Intent x = getIntent();
        String outfrom = x.getStringExtra("outfrom");
        String outto = x.getStringExtra("outto");
        from1.setText(outfrom);
        from2.setText(outfrom);
        from3.setText(outfrom);
        from4.setText(outfrom);
        to1.setText(outto);
        to2.setText(outto);
        to3.setText(outto);
        to4.setText(outto);




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cost1 = t1.getText().toString();
                SharedPreferences.Editor editor = sh.edit();
                editor.putString("cost", cost1);
                editor.commit();
                startActivity(next);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cost2 = t2.getText().toString();
                SharedPreferences.Editor editor = sh.edit();
                editor.putString("cost", cost2);
                editor.commit();
                startActivity(next);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cost3 = t3.getText().toString();
                SharedPreferences.Editor editor = sh.edit();
                editor.putString("cost", cost3);
                editor.commit();
                startActivity(next);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cost4 = t4.getText().toString();
                SharedPreferences.Editor editor = sh.edit();
                editor.putString("cost", cost4);
                editor.commit();
                startActivity(next);
            }
        });


        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(back);
            }
        });


        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(search1);
            }
        });
        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(search2); }
        });
        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(search3);
            }
        });
        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(search4);
            }
        });

    }
}