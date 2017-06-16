package dk.gamehub.workr.Util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.util.Log;
import android.widget.Toast;
import android.os.Vibrator;

/**
 * Created by mathiaslarsen on 15/06/2017.
 */

/*********************************************
 * This class handles the network connection *
 *********************************************/

public class NetworkChangeReciever extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, final Intent intent) {

        if(checkInternet(context))
        {
            Toast.makeText(context, "Netværk ikke tilgængeligt",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(context, "Netværk tilgængeligt igen",Toast.LENGTH_LONG).show();
        }

    }


    public boolean checkInternet(Context context) {
        ServiceManager serviceManager = new ServiceManager(context);
        if (serviceManager.isNetworkAvailable()) {
            return true;
        } else {
            Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(2000);
            return false;
        }
    }

}