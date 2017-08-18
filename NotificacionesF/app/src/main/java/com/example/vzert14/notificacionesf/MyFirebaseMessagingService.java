package com.example.vzert14.notificacionesf;


import android.util.Log;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "FCM Service";
    Toast toast;
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // TODO: Handle FCM messages here.
        // If the application is in the foreground handle both data and notification messages here.
        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated.
        //Log.d(TAG, "From: " + remoteMessage.getFrom());
        //Log.d(TAG, "Notification Message Body: " + remoteMessage.getNotification().getBody());
        toast = Toast.makeText(getApplicationContext(),"Notification Message Body: " + remoteMessage.getNotification().getBody(),Toast.LENGTH_LONG);
        toast.show();
        toast = Toast.makeText(getApplicationContext(),"From: " + remoteMessage.getFrom(),Toast.LENGTH_LONG);
        toast.show();
    }
}
