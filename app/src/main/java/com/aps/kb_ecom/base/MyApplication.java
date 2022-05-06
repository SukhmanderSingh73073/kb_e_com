package com.aps.kb_ecom.base;

import android.app.Application;
import android.content.Context;

import androidx.annotation.Nullable;


public class MyApplication extends Application {

    private static final String TAG = MyApplication.class.getSimpleName();

    private static MyApplication sInstance;

    @Nullable
    public static Context getAppContext() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        //FirebaseApp.initializeApp(getAppContext())  ;
        //AndroidNetworking.initialize(getApplicationContext());




    }
}