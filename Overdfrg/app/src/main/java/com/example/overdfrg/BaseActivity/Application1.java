package com.example.overdfrg.BaseActivity;

import android.app.Application;
import android.content.Context;

import com.example.overdfrg.local_utils.DeviceUuidFactory;

import java.util.UUID;

public class Application1 extends Application {
    public static Application1 mApplication;
    public boolean mPlayInWifi;
    public UUID mUuid;
    public String mToken = "";
    public String mUserPhoto = "";

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        mUuid = DeviceUuidFactory.getInstance(getApplicationContext()).getDeviceUuid();

    }
    public static Context getAppContext(){
        return mApplication.getApplicationContext();
    }
    public static Application1 getApplication(){
        return mApplication;
    }
}
