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

public class admin_farmer extends AppCompatActivity {
    EditText username, password, email, phone;
    Button buttona,edit,delete2,viewp2;
    Register_DBHandler DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_farmer);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        buttona = (Button) findViewById(R.id.buttona);
        edit = (Button) findViewById(R.id.edit);
        delete2 = (Button) findViewById(R.id.delete2);
        viewp2 = (Button) findViewById(R.id.viewp2);
        DB = new Register_DBHandler(this);
        buttona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usernameTXT = username.getText().toString();
                String passwordTXT = password.getText().toString();
                String emailTXT = email.getText().toString();
                String phoneTXT = phone.getText().toString();
                if (usernameTXT.equals("") || passwordTXT.equals("") || !passwordTXT.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$") || emailTXT.equals("") || phoneTXT.equals(""))
                    Toast.makeText(admin_farmer.this, "Please enter all the fields or password not valid", Toast.LENGTH_SHORT).show();

                else {
                    Boolean checkuser = DB.checkusername(usernameTXT);
                    if (checkuser == false) {
                        Boolean insert = DB.insertuserdata1(usernameTXT, passwordTXT, emailTXT, phoneTXT);
                        if (insert == true) {
                            Toast.makeText(admin_farmer.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), login.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(admin_farmer.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(admin_farmer.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameTXT = username.getText().toString();
                String passwordTXT = password.getText().toString();
                String emailTXT = email.getText().toString();
                String phoneTXT = phone.getText().toString();

                Boolean checkupdatedata = DB.updateuserdata1(usernameTXT, passwordTXT,emailTXT,phoneTXT);
                if(checkupdatedata==true)
                    Toast.makeText(admin_farmer.this, "Profile Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(admin_farmer.this, "Profile Not Updated", Toast.LENGTH_SHORT).show();
            }        });

        viewp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameTXT = username.getText().toString();
                Cursor res = DB.getdata1();
                if(res.getCount()==0){
                    Toast.makeText(admin_farmer.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Username :"+res.getString(0)+"\n");
                    buffer.append("Password :"+res.getString(1)+"\n");
                    buffer.append("Email :"+res.getString(2)+"\n");
                    buffer.append("Phone :"+res.getString(3)+"\n\n");
                }




                AlertDialog.Builder builder = new AlertDialog.Builder(admin_farmer.this);
                builder.setCancelable(true);
                builder.setTitle("Profile");
                builder.setMessage(buffer.toString());
                builder.show();
            }        });

        delete2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idTXT = username.getText().toString();
                Boolean checkudeletedata = DB.deletedata(idTXT);
                if(checkudeletedata==true)
                    Toast.makeText(admin_farmer.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(admin_farmer.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
            }        });
    }
}