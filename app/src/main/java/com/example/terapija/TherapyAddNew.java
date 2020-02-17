package com.example.terapija;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.AlarmClock;
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
        createNotificationChannel();
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
                createReminder();

                reff.push().setValue(therapy);
                Toast.makeText(TherapyAddNew.this,"data inserted successfully",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_HOUR,21);
                intent.putExtra(AlarmClock.EXTRA_MINUTES,20);
                startActivity(intent);
                finish();

            }
        });




    }
    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            CharSequence name="TherapyReminderChannel";
            String description="Channel for Therapy Reminder";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel= new NotificationChannel("therapyReminder",name,importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void createReminder(){
        Intent intent= new Intent(TherapyAddNew.this,ReminderBroadcast.class);
        PendingIntent pendingIntent= PendingIntent.getBroadcast(TherapyAddNew.this,0,intent,0);

        AlarmManager alarmManager=(AlarmManager) getSystemService(ALARM_SERVICE);

        long timeAtButtonCLick=System.currentTimeMillis();
        long tensec=1000*10;

        alarmManager.set(AlarmManager.RTC_WAKEUP,timeAtButtonCLick+tensec,pendingIntent);
    }

}