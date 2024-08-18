package com.example.krishivruddhi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends AppCompatActivity {
    Button expert, croppractices, marketprice, news, profile, croppratices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        expert = (Button)findViewById(R.id.expert);
        croppractices = (Button)findViewById(R.id.croppratices);
        marketprice = (Button)findViewById(R.id.marketprice);
        news = (Button)findViewById(R.id.news);
        profile = (Button)findViewById(R.id.profile);
        croppratices = (Button)findViewById(R.id.croppratices);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity3.this,MainActivity4.class);
                startActivity(intent);
            }
        });

        marketprice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity3.this,ViewPrice.class);
                startActivity(intent);
            }
        });

        croppratices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity3.this, CropInfo.class);
                startActivity(intent);
            }
        });

        expert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity3.this,QueryFarmer.class);
                startActivity(intent);
            }
            });

        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity3.this,Service.class);
                startActivity(intent);
            }
        });

    }
}