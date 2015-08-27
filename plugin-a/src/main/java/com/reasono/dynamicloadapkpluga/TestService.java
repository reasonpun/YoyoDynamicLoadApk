package com.reasono.dynamicloadapkpluga;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.reasono.yoyodynamicloadapk.library.dynamicload.DLBasePluginService;
import com.reasono.yoyodynamicloadapk.library.dynamicload.service.ITestServiceInterface;

public class TestService extends DLBasePluginService {

    private static final String TAG = "TestService";
    private MyBinder mBinder = new MyBinder();
    
    private class MyBinder extends Binder implements ITestServiceInterface {
        
        @Override
        public int sum(int a, int b) {
            // TODO Auto-generated method stub
            return a + b;
        }
    }
    
    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        Log.e(TAG, "onBind");
        return mBinder;
    } 
    
    @Override
    public boolean onUnbind(Intent intent) {
        // TODO Auto-generated method stub
        Log.e(TAG, "onUnbind");
        return super.onUnbind(intent);
    }
    
    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        Log.e(TAG, "onCreate");
    }
    
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub
        Log.e(TAG, "onStartCommand " + this.toString());
        return super.onStartCommand(intent, flags, startId);
    }

    
    
}
