package com.example.krishivruddhi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class query_admin extends AppCompatActivity {
    EditText user,answer1,question;
    Button update, delete1, answer2;
    DBHandler_Query DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_admin);
        user = findViewById(R.id.user);
        update = findViewById(R.id.update);
        delete1 = findViewById(R.id.delete1);
        answer1=  findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        DB = new DBHandler_Query(this);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userTXT = user.getText().toString();
                String answer1TXT=answer1.getText().toString();
                Boolean checkupdatedata = DB.updateuserdata(userTXT,answer1TXT);
                if(checkupdatedata==true)
                    Toast.makeText(query_admin.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(query_admin.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();
            }        });

        delete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userTXT = user.getText().toString();
                Boolean checkudeletedata = DB.deletedata(userTXT);
                if(checkudeletedata==true)
                    Toast.makeText(query_admin.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(query_admin.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
            }        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userTXT = user.getText().toString();
                Cursor res = DB.getdata1();
                if(res.getCount()==0){
                    Toast.makeText(query_admin.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Username :"+res.getString(0)+"\n");
                    buffer.append("Question :"+res.getString(1)+"\n");
                    buffer.append("Answer :"+res.getString(2)+"\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(query_admin.this);
                builder.setCancelable(true);
                builder.setTitle("Queries Answered");
                builder.setMessage(buffer.toString());
                builder.show();
            }        });
    }
}