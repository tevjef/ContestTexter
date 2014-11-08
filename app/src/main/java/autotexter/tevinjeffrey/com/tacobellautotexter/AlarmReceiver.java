package autotexter.tevinjeffrey.com.tacobellautotexter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {
    public AlarmReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // an Intent broadcast.
        sendText(context, "87654", "3A6NNMH399L");
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void sendText(Context context, String number, String message) {

        TelephonyManager tMgr = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        String mPhoneNumber = tMgr.getLine1Number();

        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(number, null, message, null, null);
        sms.sendTextMessage(mPhoneNumber, null, "Just sent message for Tacobell contest", null, null);
        Toast.makeText(context,"Just sent message for Tacobell contest", Toast.LENGTH_LONG).show();


    }
}
