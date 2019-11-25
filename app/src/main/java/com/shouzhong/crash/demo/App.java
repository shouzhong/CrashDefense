package com.shouzhong.crash.demo;

import android.app.Application;
import android.util.Log;

import com.shouzhong.crash.CrashDefense;
import com.shouzhong.crash.ExceptionHandler;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CrashDefense.install(this, new ExceptionHandler() {
            @Override
            protected void onUncaughtExceptionHappened(Thread thread, Throwable e) {
                Log.e("CrashDefense", "onUncaughtExceptionHappened:" + thread + "-->" + e.getMessage());
            }

            @Override
            protected void onBandageExceptionHappened(Throwable e) {
                Log.e("CrashDefense", "onBandageExceptionHappened:" + e.getMessage());
            }

            @Override
            protected void onEnterSafeMode() {
                Log.e("CrashDefense", "onEnterSafeMode");
            }

            @Override
            protected void onMayBeBlackScreen(Throwable e) {
                Log.e("CrashDefense", "onMayBeBlackScreen:" + e.getMessage());
            }
        });
    }
}
