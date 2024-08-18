package com.example.krishivruddhi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminHome extends AppCompatActivity {
Button marketprice1,query1,details,logout,service1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        marketprice1 = (Button)findViewById(R.id.marketprice1);
        query1 = (Button)findViewById(R.id.query1);
        details = (Button)findViewById(R.id.details);
        logout = (Button)findViewById(R.id.logout);
        service1=(Button) findViewById(R.id.service1);
        marketprice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminHome.this,AdminMarket.class);
                startActivity(intent);
            }
        });
        query1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminHome.this,query_admin.class);
                startActivity(intent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminHome.this,MainMain.class);
                startActivity(intent);
            }
        });
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminHome.this,admin_farmer.class);
                startActivity(intent);
            }
        });
        service1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminHome.this,adminservice.class);
                startActivity(intent);
            }
        });

    }

}