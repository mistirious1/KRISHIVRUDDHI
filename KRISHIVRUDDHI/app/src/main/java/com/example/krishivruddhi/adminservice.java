package com.example.krishivruddhi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class adminservice extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText name1,dob1,address1,acres;
    Button insert22,view22,update22;
    DBHandler1 DB;

    String[] courses = { "Type of Service" ,
            "Drone", "Site Visit"};
    String[] courses1 = { "Type of crop" ,
            "Arecanut", "Cashew",
            "Coconut", "Paddy",
            "Pepper", "Rubber" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminservice);



            Spinner spino = findViewById(R.id.spinner);
            spino.setOnItemSelectedListener(this);
            Spinner spino1 = findViewById(R.id.spinner1);
            spino1.setOnItemSelectedListener(this);
            name1=(EditText)findViewById(R.id.name1);
            acres=(EditText) findViewById(R.id.acres);
            dob1=(EditText)findViewById(R.id.dob1);
            address1=(EditText)findViewById(R.id.address1);
            insert22=(Button) findViewById(R.id.insert22);
            view22=(Button) findViewById(R.id.view22);
            update22=(Button) findViewById(R.id.update22);
            DB = new DBHandler1(this);

            // Create the instance of ArrayAdapter
            // having the list of courses
            ArrayAdapter ad
                    = new ArrayAdapter(
                    this,
                    android.R.layout.simple_spinner_item,
                    courses);
            ArrayAdapter ad1
                    = new ArrayAdapter(
                    this,
                    android.R.layout.simple_spinner_item,
                    courses1);

            insert22.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String spinoTXT = spino.getSelectedItem().toString();
                    String spino1TXT = spino1.getSelectedItem().toString();
                    String dob1TXT = dob1.getText().toString();
                    String address1TXT = address1.getText().toString();

                    Boolean checkinsertdata = DB.insertuserdata(spinoTXT, spino1TXT,dob1TXT,address1TXT);
                    if(checkinsertdata==true)
                        Toast.makeText(adminservice.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(adminservice.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
                }        });

            update22.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String spinoTXT = spino.getSelectedItem().toString();
                    String spino1TXT = spino1.getSelectedItem().toString();
                    String dob1TXT = dob1.getText().toString();
                    String address1TXT = address1.getText().toString();
                    Boolean checkupdatedata = DB.updateuserdata(spinoTXT, spino1TXT,dob1TXT,address1TXT);
                    if(checkupdatedata==true)
                        Toast.makeText(adminservice.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(adminservice.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();
                }        });


        view22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if(res.getCount()==0){
                    Toast.makeText(adminservice.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){

                        buffer.append("Username :" + res.getString(0) + "\n");
                        buffer.append("Service :" + res.getString(1) + "\n");
                        buffer.append("Crop :" + res.getString(2) + "\n");
                        buffer.append("Date :" + res.getString(3) + "\n\n");
                        buffer.append("Acres :" + res.getString(4) + "\n\n");



                }




                AlertDialog.Builder builder = new AlertDialog.Builder(adminservice.this);
                builder.setCancelable(true);
                builder.setTitle("Confirmed Booking");
                builder.setMessage(buffer.toString());
                builder.show();
            }        });
            // set simple layout resource file
            // for each item of spinner
            ad.setDropDownViewResource(
                    android.R.layout
                            .simple_spinner_dropdown_item);
            ad1.setDropDownViewResource(
                    android.R.layout
                            .simple_spinner_dropdown_item);

            // Set the ArrayAdapter (ad) data on the
            // Spinner which binds data to spinner
            spino.setAdapter(ad);
            spino1.setAdapter(ad1);


        }

    public void onItemSelected(AdapterView<?> adapterView, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(), courses[position], Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), courses1[position], Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}

