package com.example.krishivruddhi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ViewPrice extends AppCompatActivity {

    EditText lc;
    Button view;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_price);

        lc = (EditText) findViewById(R.id.lc);
        view = (Button) findViewById(R.id.view);
        DB = new DBHelper(this);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lcTXT = lc.getText().toString();
                Cursor res = DB.getdata(lcTXT);
                if(res.getCount()==0){
                    Toast.makeText(ViewPrice.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){

                    buffer.append("Crop :"+res.getString(2)+"\n");
                    buffer.append("Price :"+res.getString(3)+"\n\n");
                }




                AlertDialog.Builder builder = new AlertDialog.Builder(ViewPrice.this);
                builder.setCancelable(true);
                builder.setTitle("Market Price");
                builder.setMessage(buffer.toString());
                builder.show();
            }        });

    }

}