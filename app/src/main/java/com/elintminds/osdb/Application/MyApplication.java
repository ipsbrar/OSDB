package com.elintminds.osdb.Application;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

    }
}
