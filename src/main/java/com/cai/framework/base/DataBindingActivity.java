package com.cai.framework.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatDelegate;

import com.cai.framework.utils.PermissionUtils;

/**
 * 视图层
 *
 * @param <M>
 */
public abstract class DataBindingActivity<M extends ViewDataBinding> extends FragmentActivity {
    public Context mContext;
    public M mViewBinding;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        mViewBinding = DataBindingUtil.setContentView(this, getLayoutId());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        PermissionUtils.onRequestPermissionsResult(requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public abstract void initView();

    public abstract int getLayoutId();
}
