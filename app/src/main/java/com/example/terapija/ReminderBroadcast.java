package com.example.terapija;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class ReminderBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "therapyReminder")
                .setSmallIcon(R.drawable.ic_add_black_24dp)
                .setContentTitle("Terapija")
                .setContentInfo("Moras da pijes tablete")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager= NotificationManagerCompat.from(context);

                notificationManager.notify(200,builder.build());
    }
}
