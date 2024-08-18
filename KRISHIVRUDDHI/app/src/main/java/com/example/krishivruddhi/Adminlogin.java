package com.example.krishivruddhi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class Adminlogin extends AppCompatActivity {
    Button button2a;
    EditText emaila,passworda;
    int counter = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);
        button2a=(Button) findViewById(R.id.button2a);
        emaila=(EditText) findViewById(R.id.emaila);
        passworda=(EditText) findViewById(R.id.passworda);


        button2a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(emaila.getText().toString().equals("admin") &&
                        passworda.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(), "Redirecting...",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Adminlogin.this,AdminHome.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
                    counter--;
                    if (counter == 0) {
                        button2a.setEnabled(false);
                    }
                }
            }
        });
    }
}