package com.example.overdfrg.BaseActivity;

import android.app.Application;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.overdfrg.boradcast.NetStatusBroadCast;
import com.example.overdfrg.design.LoadingDialogWithContent;
import com.example.overdfrg.utild.NormalConfig;

import static android.app.DownloadManager.Request.NETWORK_MOBILE;
import static android.app.DownloadManager.Request.NETWORK_WIFI;
import static com.example.overdfrg.local_utils.NetworkUtils.NETWORK_NONE;

public class BaseActivatey extends AppCompatActivity implements NetStatusBroadCast.NetStatusListener{
    private LinearLayoutManager mManager;
    public Application application;
    public NetStatusBroadCast mNetStatusBroadCast;
    private LoadingDialogWithContent mDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = getApplication();
    }
    public void showLoadingDialog() {
        if (!mDialog.isShowing()) mDialog.show();
    }

    public void hideLoadingDialog() {
        if (mDialog.isShowing()) mDialog.dismiss();
    }

    public void showLog(Object content) {
        Log.e(NormalConfig.log1, content.toString());
    }

    public void showLog(boolean content) {
        Log.e(NormalConfig.log1, "" + content);
    }
    public void registerNetWorkStatus() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        mNetStatusBroadCast = new NetStatusBroadCast();
        mNetStatusBroadCast.setNetStatusListener(this);
        registerReceiver(mNetStatusBroadCast, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDialog != null){
            if (mDialog.isShowing())mDialog.cancel();
        }
    }

    protected int getLoadType(Object[] t) {
        return (int) ((Object[]) t[1])[0];
    }

    public void refresh() {
    }

    public void loadMore() {
    }

    public void showToast(String content) {
        Toast.makeText(getApplicationContext(), content, Toast.LENGTH_SHORT).show();
    }

    public void showLongToast(String content) {
        Toast.makeText(getApplicationContext(), content, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNetChanged(int state) {
        if (state == NETWORK_MOBILE || state == NETWORK_WIFI) onNetConnected();
        else if (state == NETWORK_NONE) onNetDisConnected();
    }

    public void onNetConnected() {
    }

    public void onNetDisConnected() {
    }
}
