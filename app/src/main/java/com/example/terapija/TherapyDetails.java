package com.example.terapija;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;



public class TherapyDetails extends Activity {
    TextView name,type,daily,date,amount,time,weekly;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.therapy_details_layout);

        name=(TextView) findViewById(R.id.therapy_deatils_name);
        type=(TextView) findViewById(R.id.therapy_deatils_type);
        daily=(TextView)findViewById(R.id.therapy_deatils_daily);
        date=(TextView)findViewById(R.id.therapy_deatils_date);
        amount=(TextView)findViewById(R.id.therapy_deatils_amount);
        time=(TextView)findViewById(R.id.therapy_deatils_time);
        weekly=(TextView)findViewById(R.id.therapy_deatils_weekly);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("Name");
            name.setText(value);
            type.setText(extras.getString("Type"));
            daily.setText(String.valueOf(extras.getInt("Daily")));
            date.setText(extras.getString("Date"));
            amount.setText(String.valueOf(extras.getInt("Amount")));
            time.setText(extras.getString("Time"));
            weekly.setText(String.valueOf(extras.getInt("Weekly")));




        }
    }
}


