package restart;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import java.security.SecureRandom;
import android.app.AlarmManager;
import android.app.PendingIntent;
import io.ionic.starter.MainActivity;

public class restart extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("restartApp")) {
            int time = args.getInt(0);
            this.restartApp(time, callbackContext);
            return true;
        }
        return false;
    }

    private void restartApp(int time, CallbackContext callbackContext) {
        try {
            Intent mStartActivity = new Intent(cordova.getActivity().getApplicationContext(), MainActivity.class);

            int mPendingIntentId = new SecureRandom().nextInt();

            PendingIntent mPendingIntent = PendingIntent.getActivity(cordova.getActivity().getApplicationContext(),
                    mPendingIntentId, mStartActivity,

                    PendingIntent.FLAG_CANCEL_CURRENT);

            AlarmManager mgr = (AlarmManager) cordova.getActivity().getApplicationContext()
                    .getSystemService(Context.ALARM_SERVICE);

            mgr.set(AlarmManager.RTC, System.currentTimeMillis() + time, mPendingIntent);

            System.exit(0);

            callbackContext.success();
        } catch (Exception ex) {
            callbackContext.error(ex.getMessage());
        }
    }
}
