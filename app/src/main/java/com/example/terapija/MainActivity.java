package com.example.terapija;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText txtName,txtSurname,txtAge,txtSex;
    Button btnSave;
    DatabaseReference reff;
    Member member = new Member();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName=(EditText)findViewById(R.id.txtName);
        txtSurname=(EditText)findViewById(R.id.txtSurename);
        txtAge=(EditText)findViewById(R.id.txtAge);
        txtSex=(EditText)findViewById(R.id.txtSex);
        btnSave=(Button) findViewById(R.id.btnSave);
        reff= FirebaseDatabase.getInstance().getReference().child("Member");
        btnSave.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int Age = Integer.parseInt(txtAge.getText().toString().trim());
            Log.i("Age",txtAge.getText().toString().trim());
            Log.i("Name",txtName.getText().toString().trim());
            Log.i("Surnmae",txtSurname.getText().toString().trim());
            Log.i("Sex",txtSex.getText().toString().trim());

            member.setName(txtName.getText().toString().trim());
            member.setSex(txtSex.getText().toString().trim());
            member.setSurname(txtSurname.getText().toString().trim());
            member.setAge(Age);
            reff.push().setValue(member);
            Toast.makeText(MainActivity.this,"data insereted successfully",Toast.LENGTH_SHORT).show();

        }
    });

    }
}
