package in.silive.scrolls.Services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

import in.silive.scrolls.R;

/**
 * Created by akriti on 4/9/16.
 */
public class RegisterGCM extends IntentService {
    private static final String TAG = "RegisterGCMService";
   //public PrefManager prefManager;

    public RegisterGCM() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        InstanceID instanceID = InstanceID.getInstance(this);
        //prefManager = new PrefManager(this);
        Log.i(TAG, "GCM Registration Token: " + "started");
        try {
            String token = instanceID.getToken(getString(R.string.gcm_defaultSenderId),
                    GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);
            Log.i(TAG, "GCM Registration Token: " + token);
            //  prefManager.GCMTokenSent();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
