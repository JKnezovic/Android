package com.example.terapija;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MedicineDetails extends AppCompatActivity {

    TextView titleTV, before_takingTV, descriptionTV, how_to_useTV, important_informationTV, side_effectsTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_details);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String before_taking = intent.getStringExtra("before_taking");
        String description = intent.getStringExtra("description");
        String how_to_use = intent.getStringExtra("how_to_use");
        String important_information = intent.getStringExtra("important_information");
        String side_effects = intent.getStringExtra("side_effects");

        // Capture the layout's TextView and set the string as its text
        titleTV = findViewById(R.id.textView);
        before_takingTV = findViewById(R.id.before_taking);
        descriptionTV = findViewById(R.id.description);
        how_to_useTV = findViewById(R.id.how_to_use);
        important_informationTV = findViewById(R.id.important_information);
        side_effectsTV = findViewById(R.id.side_effects);


        titleTV.setText(title);
        before_takingTV.setText(before_taking);
        descriptionTV.setText(description);
        how_to_useTV.setText(how_to_use);
        important_informationTV.setText(important_information);
        side_effectsTV.setText(side_effects);
    }
}
