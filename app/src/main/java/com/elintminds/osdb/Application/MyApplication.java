package com.elintminds.osdb.Application;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;
import com.elintminds.osdb.utils.ConnectivityReceiver;

public class MyApplication extends Application {

    private static volatile MyApplication myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        myApplication = null;
        if (myApplication == null)
        myApplication = this;
    }

    public static MyApplication getInstance(){
        if (myApplication == null){
            synchronized (MyApplication.class){
                if (myApplication == null){
                    myApplication = new MyApplication();
                }
            }
        }
        return myApplication;
    }

    public void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener listener) {
        ConnectivityReceiver.connectivityReceiverListener = listener;
    }
}
