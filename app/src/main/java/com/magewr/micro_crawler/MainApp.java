package com.magewr.micro_crawler;

import android.app.Application;

public class MainApp extends Application {
    private static MainApp singleton;

    public static MainApp getInstance() {
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
    }
}
