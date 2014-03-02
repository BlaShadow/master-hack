<<<<<<< HEAD
package com.obrero.cmycountry.services;


import android.app.Service;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.util.Log;
import com.obrero.cmycountry.R;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by Eefret on three/one/14.
 */
public class WallpaperService extends Service {

    Timer mytimer;
    int interval=1000;
    Drawable drawable;
    WallpaperManager wpm;
    int currentIndex=1;
    private static final String TAG = "WallpaperService";

    @Override
    public void onCreate() {
        super.onCreate();
        mytimer=new Timer();
        wpm=WallpaperManager.getInstance(WallpaperService.this);
        Log.d(TAG,"Service Started");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"onStartCommand");
        mytimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Bitmap wallpaper=getCurrentImage();
                rotateCurrent();
                Log.d(TAG,"Running");
                try {
                    wpm.setBitmap(wallpaper);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, interval,1000*60*1);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    public Bitmap getCurrentImage(){
        Log.d(TAG,"getImage"+currentIndex);
        if(currentIndex==1){
            drawable = getResources().getDrawable(R.drawable.one);
        }
        else if(currentIndex==2){
            drawable = getResources().getDrawable(R.drawable.two);
        }
        else{
            drawable = getResources().getDrawable(R.drawable.three);
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    public void rotateCurrent(){
        Log.d(TAG,"rotateCurrent");
        if(currentIndex <3){
            currentIndex++;
        }else{
            currentIndex = 1;
        }
    }
=======
package com.obrero.cmycountry.services;


import android.app.Service;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.util.Log;
import com.obrero.cmycountry.R;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by Eefret on three/one/14.
 */
public class WallpaperService extends Service {

    Timer mytimer;
    int interval=1000;
    Drawable drawable;
    WallpaperManager wpm;
    int currentIndex=1;
    private static final String TAG = "WallpaperService";

    @Override
    public void onCreate() {
        super.onCreate();
        mytimer=new Timer();
        wpm=WallpaperManager.getInstance(WallpaperService.this);
        Log.d(TAG,"Service Started");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"onStartCommand");
        mytimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Bitmap wallpaper=getCurrentImage();
                rotateCurrent();
                Log.d(TAG,"Running");
                try {

                    wpm.setBitmap(wallpaper);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, interval,1000*60*1);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mytimer.cancel();
    }

    public Bitmap getCurrentImage(){
        Log.d(TAG,"getImage"+currentIndex);
        if(currentIndex==1){
            drawable = getResources().getDrawable(R.drawable.one);
        }
        else if(currentIndex==2){
            drawable = getResources().getDrawable(R.drawable.two);
        }
        else{
            drawable = getResources().getDrawable(R.drawable.three);
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    public void rotateCurrent(){
        Log.d(TAG,"rotateCurrent");
        if(currentIndex <3){
            currentIndex++;
        }else{
            currentIndex = 1;
        }
    }
>>>>>>> 0b18ee89ce8fddd39c61b81b4fd0a38ed4c35792
}