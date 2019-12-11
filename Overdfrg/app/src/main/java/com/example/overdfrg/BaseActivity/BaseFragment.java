package com.example.overdfrg.BaseActivity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.overdfrg.R;
import com.example.overdfrg.design.LoadingDialogWithContent;
import com.example.overdfrg.utild.NormalConfig;

public class BaseFragment extends Fragment {
    public LinearLayoutManager mManager;
    private LoadingDialogWithContent mDialog;
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mDialog!=null){
            if (mDialog.isShowing())mDialog.cancel();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDialog=new LoadingDialogWithContent(getActivity(), getString(R.string.loading));
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    public void showLoadingDialog() {
        if (!mDialog.isShowing()) mDialog.show();
    }


    public void showToast(String content) {
        Toast.makeText(getContext().getApplicationContext(), content, Toast.LENGTH_SHORT).show();
    }

    public void showLongToast(String content) {
        Toast.makeText(getContext().getApplicationContext(), content, Toast.LENGTH_LONG).show();
    }

    public void hideLoadingDialog() {
        if (mDialog.isShowing()) mDialog.dismiss();
    }

    public void refresh() {
    }

    public void loadMore() {
    }
    public void showLog(String content) {
        Log.e(NormalConfig.log1, content);
    }

    public void showLog(boolean content) {
        Log.e(NormalConfig.log1, "" + content);
    }
}
