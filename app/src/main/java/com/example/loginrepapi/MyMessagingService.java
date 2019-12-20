package com.example.loginrepapi;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        showNotification(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
    }

    public void showNotification(String title,String message)
    {
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"mynotification")
        .setContentTitle(title)
        .setSmallIcon(R.drawable.com_facebook_button_icon)
        .setAutoCancel(true)
        .setContentText(message);
        NotificationManagerCompat manager=NotificationManagerCompat.from(this);
        manager.notify((int) System.currentTimeMillis(),builder.build());

    }
}
