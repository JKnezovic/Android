package com.example.terapija;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MedicineDetails extends AppCompatActivity {

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
        TextView textView = findViewById(R.id.textView);
        textView.setText(title);
    }
}
