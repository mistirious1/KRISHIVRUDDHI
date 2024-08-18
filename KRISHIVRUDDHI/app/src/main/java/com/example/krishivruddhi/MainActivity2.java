package com.example.krishivruddhi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity2 extends AppCompatActivity {


        EditText username, password, email, phone;
        TextView text1;
        Button button;
        Register_DBHandler DB;
        private ProgressDialog loader;

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);

            text1 = (TextView) findViewById(R.id.text1);
            username = (EditText) findViewById(R.id.username);
            password = (EditText) findViewById(R.id.password);
            email = (EditText) findViewById(R.id.email);
            phone = (EditText) findViewById(R.id.phone);
            DB = new Register_DBHandler(this);
            button = (Button) findViewById(R.id.button);
            loader = new ProgressDialog(this);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String usernameTXT = username.getText().toString();
                    String passwordTXT = password.getText().toString();
                    String emailTXT = email.getText().toString();
                    String phoneTXT = phone.getText().toString();
                    if(usernameTXT.equals("")||passwordTXT.equals("")||!passwordTXT.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")||emailTXT.equals("")||phoneTXT.equals(""))
                        Toast.makeText(MainActivity2.this, "Please enter all the fields or password not valid", Toast.LENGTH_SHORT).show();

                    else{
                            Boolean checkuser = DB.checkusername(usernameTXT);
                            if(checkuser==false){
                                Boolean insert = DB.insertuserdata(usernameTXT, passwordTXT,emailTXT,phoneTXT);
                                if(insert==true){
                                    Toast.makeText(MainActivity2.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(),login.class);
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(MainActivity2.this, "Registration failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(MainActivity2.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                            }
                        }

                    /*String nameReg = username.getText().toString().trim();
                    String phoneReg = phone.getText().toString().trim();
                    String passwdReg = password.getText().toString().trim();
                    String emailReg = email.getText().toString().trim();
                    if (nameReg.length() == 0 || phoneReg.length() == 0 || passwdReg.length() == 0 || emailReg.length() == 0) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);

                        builder.setCancelable(true);
                        builder.setTitle("Empty field!");
                        builder.setMessage("Fill all fields");
                        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //alertTextView.setVisibility(View.VISIBLE);
                            }
                        });
                        builder.show();
                    } else {

                        String usernameTXT = username.getText().toString();
                        String passwordTXT = password.getText().toString();
                        String emailTXT = email.getText().toString();
                        String phoneTXT = phone.getText().toString();

                        Boolean checkinsertdata = DB.insertuserdata(usernameTXT,passwordTXT, emailTXT, phoneTXT);
                        if(checkinsertdata==true)
                            Toast.makeText(MainActivity2.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity2.this, "Registration Unsuccessful", Toast.LENGTH_SHORT).show();

                    }*/
                }

            });


            text1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity2.this, login.class);
                    startActivity(intent);
                }
            });

            }



    }