package com.example.myapplication44;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LogIn extends AppCompatActivity {
     EditText email , password ;
     Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        email = findViewById(R.id.idEdtUserName);
        password = findViewById(R.id.idEdtPassword);
        login = findViewById(R.id.BtnLogin);
        Intent intent = new Intent(this,ChooseActivity.class);
        login.setOnClickListener(new View.OnClickListener() {
            Boolean chek=true;
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(email.getText().toString())){
                    email.setError("Username is required!");
                    chek=false;
                }
                if(TextUtils.isEmpty(password.getText().toString())){
                    password.setError("Email is required!");
                    chek=false;
                }
                 if(!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()){
                    email.setError("Pleas enter a valid email address");
                    chek=false;
                }
                if(chek==true){
                    startActivity(intent);
                }
            }
        });

    }
}
