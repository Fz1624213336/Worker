package com.example.overdfrg.local_utils;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.example.overdfrg.BaseActivity.Application1;




public class VersionUtils {
    public static int getVersionCode(){
        PackageInfo info = null;
        try {
            info = Application1.mApplication.getPackageManager().getPackageInfo(Application1.mApplication.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException pE) {
            pE.printStackTrace();
        }
        return info.versionCode;
    }
}
