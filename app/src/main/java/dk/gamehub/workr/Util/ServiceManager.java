package dk.gamehub.workr.Util;

import android.content.Context;
import android.content.ContextWrapper;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by mathiaslarsen on 15/06/2017.
 */

public class ServiceManager extends ContextWrapper {

    public ServiceManager(Context base) {
        super(base);
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        //Tjek for null også, da flytilstand er null
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

}