package com.example.krishivruddhi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMain extends AppCompatActivity {
        Button admin,farmer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_main);
        admin=(Button) findViewById(R.id.admin);
        farmer=(Button) findViewById(R.id.farmer);
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainMain.this,Adminlogin.class);
                startActivity(intent);
            }
        });

        farmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainMain.this,login.class);
                startActivity(intent);
            }
        });
    }
}