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

public class Service extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText name1,dob1,address1,acres;
    Button insert12,book;
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
        setContentView(R.layout.activity_service);

        Spinner spino = findViewById(R.id.spinner);
        spino.setOnItemSelectedListener(this);
        Spinner spino1 = findViewById(R.id.spinner1);
        spino1.setOnItemSelectedListener(this);
        name1=(EditText)findViewById(R.id.name1);
        acres=(EditText) findViewById(R.id.acres);
        dob1=(EditText)findViewById(R.id.dob1);
        address1=(EditText)findViewById(R.id.address1);
        insert12=(Button) findViewById(R.id.insert12);
        book=(Button) findViewById(R.id.book);
        DB = new DBHandler1(this);

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

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1TXT=name1.getText().toString();
                String spinoTXT = spino.getSelectedItem().toString();
                String spino1TXT = spino1.getSelectedItem().toString();
                String dob1TXT = dob1.getText().toString();
                String acresTXT = acres.getText().toString();
                if(dob1TXT.equals("")||!dob1TXT.matches("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$"))
                {
                    Toast.makeText(Service.this,"Date not in format",Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checkinsertdata = DB.insertuserdata1(name1TXT, spinoTXT, spino1TXT, dob1TXT, acresTXT);
                    if (checkinsertdata == true)
                        Toast.makeText(Service.this, "Booked", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(Service.this, "Booking not done", Toast.LENGTH_SHORT).show();
                }
            }        });


        insert12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String spinoTXT = spino.getSelectedItem().toString();
                String spino1TXT = spino1.getSelectedItem().toString();
                Cursor res = DB.getdata1(spinoTXT,spino1TXT);
                if(res.getCount()==0){
                    Toast.makeText(Service.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){

                    buffer.append("Service :"+res.getString(0)+"\n");
                    buffer.append("Crop :"+res.getString(1)+"\n");
                    buffer.append("Price :"+res.getString(2)+"\n");

                }




                AlertDialog.Builder builder = new AlertDialog.Builder(Service.this);
                builder.setCancelable(true);
                builder.setTitle("Price/Acre");
                builder.setMessage(buffer.toString());
                builder.show();
            }        });
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