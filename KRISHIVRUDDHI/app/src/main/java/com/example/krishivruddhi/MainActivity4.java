package com.example.krishivruddhi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {
    Button btnlogout, btnhome, edit1,viewp;
    EditText username,password,email,phone;
    Register_DBHandler DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        btnlogout = (Button)findViewById(R.id.btnlogout);
        btnhome = (Button)findViewById(R.id.btnhome);
        edit1 = (Button)findViewById(R.id.edit1);
        viewp = (Button)findViewById(R.id.viewp);
        username=(EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.password);
        email=(EditText) findViewById(R.id.email);
        phone=(EditText) findViewById(R.id.phone);
        DB = new Register_DBHandler(this);

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity4.this, MainMain.class);
                startActivity(intent);
            }
        });

        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity4.this,MainActivity3.class);
                startActivity(intent);
            }
        });

        edit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameTXT = username.getText().toString();
                String passwordTXT = password.getText().toString();
                String emailTXT = email.getText().toString();
                String phoneTXT = phone.getText().toString();

                Boolean checkupdatedata = DB.updateuserdata(usernameTXT, passwordTXT,emailTXT,phoneTXT);
                if(checkupdatedata==true)
                    Toast.makeText(MainActivity4.this, "Profile Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity4.this, "Profile Not Updated", Toast.LENGTH_SHORT).show();
            }        });

        viewp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameTXT = username.getText().toString();
                Cursor res = DB.getdata(usernameTXT);
                if(res.getCount()==0){
                    Toast.makeText(MainActivity4.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Username :"+res.getString(0)+"\n");
                    buffer.append("Password :"+res.getString(1)+"\n");
                    buffer.append("Email :"+res.getString(2)+"\n");
                    buffer.append("Phone :"+res.getString(3)+"\n\n");
                }




                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity4.this);
                builder.setCancelable(true);
                builder.setTitle("Profile");
                builder.setMessage(buffer.toString());
                builder.show();
            }        });
    }
}