package com.example.krishivruddhi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class QueryFarmer extends AppCompatActivity {
    EditText user,question,answer1;
    Button update, ask, delete1, answer;
    DBHandler_Query DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_farmer);
        user = findViewById(R.id.user);
        question = findViewById(R.id.question);
        update = findViewById(R.id.update);
        ask = findViewById(R.id.askk);
        delete1 = findViewById(R.id.delete1);
        answer1=  findViewById(R.id.answer1);
        answer = findViewById(R.id.answer2);
        DB = new DBHandler_Query(this);

        ask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userTXT = user.getText().toString();
                String questionTXT = question.getText().toString();
                Boolean checkinsertdata = DB.insertuserdata(userTXT,questionTXT);
                if(checkinsertdata==true)
                    Toast.makeText(QueryFarmer.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(QueryFarmer.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }        });


        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userTXT = user.getText().toString();
                Cursor res = DB.getdata(userTXT);
                if(res.getCount()==0){
                    Toast.makeText(QueryFarmer.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Username :"+res.getString(0)+"\n");
                    buffer.append("Question :"+res.getString(1)+"\n");
                    buffer.append("Answer :"+res.getString(2)+"\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(QueryFarmer.this);
                builder.setCancelable(true);
                builder.setTitle("Queries Answered");
                builder.setMessage(buffer.toString());
                builder.show();
            }        });
    }}

