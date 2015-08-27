package com.reasono.yoyodynamicloadapk.library.dynamicload;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import com.reasono.yoyodynamicloadapk.library.dynamicload.internal.DLPluginManager;
import com.reasono.yoyodynamicloadapk.library.dynamicload.internal.DLServiceAttachable;
import com.reasono.yoyodynamicloadapk.library.dynamicload.internal.DLServiceProxyImpl;

public class DLProxyService extends Service implements DLServiceAttachable {

    private static final String TAG = "DLProxyService";
    private DLServiceProxyImpl mImpl = new DLServiceProxyImpl(this);
    private DLServicePlugin mRemoteService;
    private DLPluginManager mPluginManager;

    @Override
    public IBinder onBind(Intent intent) {
        //判断是否存在插件Service，如果存在，则不进行Service插件的构造工作
        if (mRemoteService == null) {
            mImpl.init(intent);
        }
        return mRemoteService.onBind(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, TAG + " onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub
        Log.d(TAG, TAG + " onStartCommand " + this.toString());
        //判断是否存在插件Service，如果存在，则不进行Service插件的构造工作
        if (mRemoteService == null) {
            mImpl.init(intent);
        }
        super.onStartCommand(intent, flags, startId);
        return mRemoteService.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        mRemoteService.onDestroy();
        super.onDestroy();
        Log.d(TAG, TAG + " onDestroy");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        mRemoteService.onConfigurationChanged(newConfig);
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, TAG + " onConfigurationChanged");
    }

    @Override
    public void onLowMemory() {
        mRemoteService.onLowMemory();
        super.onLowMemory();
        Log.d(TAG, TAG + " onLowMemory");
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public void onTrimMemory(int level) {
        mRemoteService.onTrimMemory(level);
        super.onTrimMemory(level);
        Log.d(TAG, TAG + " onTrimMemory");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, TAG + " onUnbind");
        super.onUnbind(intent);
        return mRemoteService.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        mRemoteService.onRebind(intent);
        super.onRebind(intent);
        Log.d(TAG, TAG + " onRebind");
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public void onTaskRemoved(Intent rootIntent) {
        mRemoteService.onTaskRemoved(rootIntent);
        super.onTaskRemoved(rootIntent);
        Log.d(TAG, TAG + " onTaskRemoved");
    }

    @Override
    public void attach(DLServicePlugin remoteService, DLPluginManager pluginManager) {
        mRemoteService = remoteService;
        mPluginManager = pluginManager;
    }
}
