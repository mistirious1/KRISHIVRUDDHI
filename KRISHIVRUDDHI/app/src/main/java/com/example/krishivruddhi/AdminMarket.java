package com.example.krishivruddhi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminMarket extends AppCompatActivity {
        EditText id,lc, cp, pr;
        Button insert, update, delete, view;
        DBHelper DB;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_admin_market);
            lc = findViewById(R.id.lc);
            id = findViewById(R.id.id);
            cp = findViewById(R.id.cp);
            pr = findViewById(R.id.pr);
            insert = findViewById(R.id.btninsert);
            update = findViewById(R.id.btnupdate);
            delete = findViewById(R.id.btndelete);
            view = findViewById(R.id.view);
            DB = new DBHelper(this);
            insert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String idTXT = id.getText().toString();
                    String lcTXT = lc.getText().toString();
                    String cpTXT = cp.getText().toString();
                    String prTXT = pr.getText().toString();

                    Boolean checkinsertdata = DB.insertuserdata(idTXT,lcTXT, cpTXT, prTXT);
                    if(checkinsertdata==true)
                        Toast.makeText(AdminMarket.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(AdminMarket.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
                }        });
            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String idTXT = id.getText().toString();
                    String lcTXT = lc.getText().toString();
                    String cpTXT = cp.getText().toString();
                    String prTXT = pr.getText().toString();

                    Boolean checkupdatedata = DB.updateuserdata(idTXT,lcTXT, cpTXT, prTXT);
                    if(checkupdatedata==true)
                        Toast.makeText(AdminMarket.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(AdminMarket.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();
                }        });
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String idTXT = id.getText().toString();
                    Boolean checkudeletedata = DB.deletedata(idTXT);
                    if(checkudeletedata==true)
                        Toast.makeText(AdminMarket.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(AdminMarket.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
                }        });

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String lcTXT = lc.getText().toString();
                    Cursor res = DB.getdata(lcTXT);
                    if(res.getCount()==0){
                        Toast.makeText(AdminMarket.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    StringBuffer buffer = new StringBuffer();
                    while(res.moveToNext()){
                        buffer.append("Id :"+res.getString(0)+"\n");
                        buffer.append("Location :"+res.getString(1)+"\n");
                        buffer.append("Crop :"+res.getString(2)+"\n");
                        buffer.append("Price :"+res.getString(3)+"\n\n");
                    }




                    AlertDialog.Builder builder = new AlertDialog.Builder(AdminMarket.this);
                    builder.setCancelable(true);
                    builder.setTitle("Market Price");
                    builder.setMessage(buffer.toString());
                    builder.show();
                }        });
        }}
