package com.example.terapija;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TherapyAddNew extends AppCompatActivity {

    EditText name,type,daily,date,amount,time,weekly;
    Button saveBtn;
    Therapy therapy = new Therapy();
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.therapy_add_new_layout);

        name=findViewById(R.id.TherapyAddNewName);
        type=findViewById(R.id.TherapyAddNewType);
        daily=findViewById(R.id.TherapyAddNewDaily);
        date=findViewById(R.id.TherapyAddNewDate);
        amount=findViewById(R.id.TherapyAddNewAmount);
        time=findViewById(R.id.TherapyAddNewTime);
        weekly=findViewById(R.id.TherapyAddNewWeekly);
        saveBtn=findViewById(R.id.TherapyAddNewButton);

        reff= FirebaseDatabase.getInstance().getReference().child("therapy");

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                therapy.setName(name.getText().toString().trim());
                therapy.setType(type.getText().toString().trim());
                therapy.setDialy(Integer.parseInt(daily.getText().toString().trim()));
                therapy.setDate(date.getText().toString().trim());
                therapy.setAmount(Integer.parseInt(amount.getText().toString().trim()));
                therapy.setTime(time.getText().toString().trim());
                therapy.setWeekly(Integer.parseInt(weekly.getText().toString().trim()));


                reff.push().setValue(therapy);
                Toast.makeText(TherapyAddNew.this,"data inserted successfully",Toast.LENGTH_SHORT).show();
                finish();

            }
        });




    }
}