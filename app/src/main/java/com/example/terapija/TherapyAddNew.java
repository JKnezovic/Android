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

import java.util.Calendar;


public class TherapyAddNew extends AppCompatActivity {

    EditText name,type,daily,date,amount,time,weekly;
    Button saveBtn;
    Therapy therapy = new Therapy();
    Reminder reminder= new Reminder();
    DatabaseReference reffReminder;
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
        reffReminder= FirebaseDatabase.getInstance().getReference().child("reminder");

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dates=date.getText().toString().trim();
                String times=time.getText().toString().trim();
                therapy.setName(name.getText().toString().trim());
                therapy.setType(type.getText().toString().trim());
                therapy.setDialy(Integer.parseInt(daily.getText().toString().trim()));
                therapy.setDate(dates);
                therapy.setAmount(Integer.parseInt(amount.getText().toString().trim()));
                therapy.setTime(times);
                therapy.setWeekly(Integer.parseInt(weekly.getText().toString().trim()));
                String[] datesSplt=dates.split("/");
                String[] timesSplit=times.split(":");

                createReminder(datesSplt[0],datesSplt[1],datesSplt[2],timesSplit[1],timesSplit[0]);

                reminder.setName(name.getText().toString().trim());
                reminder.setTime(times);
                reminder.setAmount(Integer.parseInt(amount.getText().toString().trim()));
                reminder.setEnd_date(dates);

                reffReminder.push().setValue(reminder);
                reff.push().setValue(therapy);
                Toast.makeText(TherapyAddNew.this,"data inserted successfully",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_HOUR,Integer.parseInt(timesSplit[0]));
                intent.putExtra(AlarmClock.EXTRA_MINUTES,Integer.parseInt(timesSplit[1]));
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

    private void createReminder(String day,String month,String year ,String minute,String hour){

        Intent intent= new Intent(TherapyAddNew.this,ReminderBroadcast.class);
        PendingIntent pendingIntent= PendingIntent.getBroadcast(TherapyAddNew.this,0,intent,0);

        AlarmManager alarmManager=(AlarmManager) getSystemService(ALARM_SERVICE);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hour));
        calendar.set(Calendar.MINUTE, Integer.parseInt(minute));
        calendar.set(Calendar.DAY_OF_MONTH,Integer.parseInt(day));
        calendar.set(Calendar.MONTH,Integer.parseInt(month));
        calendar.set(Calendar.YEAR,Integer.parseInt(year));




        Log.i("Datum",day +month+year+minute+hour);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),alarmManager.INTERVAL_DAY,pendingIntent);
    }



}