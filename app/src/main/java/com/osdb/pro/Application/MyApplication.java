package com.osdb.pro.Application;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;
import com.osdb.pro.utils.ConnectivityReceiver;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class MyApplication extends Application {

    private static volatile MyApplication myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        final Fabric fabric = new Fabric.Builder(this)
                .kits(new Crashlytics())
                .debuggable(true)
                .build();
        Fabric.with(fabric);

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        myApplication = null;
        if (myApplication == null)
            myApplication = this;
    }

    public static MyApplication getInstance() {
        if (myApplication == null) {
            synchronized (MyApplication.class) {
                if (myApplication == null) {
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
