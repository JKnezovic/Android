package com.example.terapija;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;



public class TherapyDetails extends Activity {
    TextView name,type;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.therapy_details_layout);

        name=(TextView) findViewById(R.id.therapy_deatils_name);
        type=(TextView) findViewById(R.id.therapy_deatils_type);



        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("TITLE");
            type.setText(value);
            name.setText(extras.getString("CONTENT"));


        }
    }
}


