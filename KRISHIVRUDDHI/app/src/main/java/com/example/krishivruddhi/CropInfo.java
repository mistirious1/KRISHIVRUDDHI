package com.example.krishivruddhi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CropInfo extends AppCompatActivity {
Button Arecanut,Coconut,Cashew,Paddy,Pepper,Rubber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_info);
        Arecanut=(Button) findViewById(R.id.Arecanut);
        Coconut=(Button) findViewById(R.id.Coconut);
        Cashew=(Button) findViewById(R.id.Cashew);
        Paddy=(Button) findViewById(R.id.Paddy);
        Pepper=(Button) findViewById(R.id.Pepper);
        Rubber=(Button) findViewById(R.id.Rubber);
        Arecanut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CropInfo.this,Areca_nut.class);
                startActivity(intent);
            }
        });
        Coconut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CropInfo.this,Coconut.class);
                startActivity(intent);
            }
        });
        Cashew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CropInfo.this,Cashew.class);
                startActivity(intent);
            }
        });
        Paddy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CropInfo.this,Paddy.class);
                startActivity(intent);
            }
        });
        Pepper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CropInfo.this,Pepper.class);
                startActivity(intent);
            }
        });
        Rubber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CropInfo.this,Rubber.class);
                startActivity(intent);
            }
        });
    }
}