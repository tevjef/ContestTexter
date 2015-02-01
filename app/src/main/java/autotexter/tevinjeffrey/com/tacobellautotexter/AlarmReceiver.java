package autotexter.tevinjeffrey.com.tacobellautotexter;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AlarmReceiver extends BroadcastReceiver {
    public AlarmReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // an Intent broadcast.
        sendText(context, "87654", "3A6NNMH399L");
    }

    private void sendText(Context context, String number, String message) {
        //sends text message
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(number, null, message, null, null);
        //notifies user a text message was sent
        makeNotification(context);
    }

    public void makeNotification(Context context) {
        NotificationCompat.Builder nb = new NotificationCompat.Builder(context);
        nb.setContentText("Just sent message for Tacobell contest");
        nb.setSmallIcon(R.drawable.ic_launcher);
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        nb.setSound(alarmSound);
        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(123, nb.build());
        Toast.makeText(context,"Just sent message for Tacobell contest", Toast.LENGTH_SHORT).show();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        // Set the alarm to start at 8:30 a.m.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        Log.d("AM", "Message sent at: " + dateFormat.format(calendar.getTime()));
    }
}
