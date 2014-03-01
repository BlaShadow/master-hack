package com.obrero.cmycountry.services;

import android.app.IntentService;
import android.app.Service;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import com.obrero.cmycountry.R;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by Eefret on three/one/14.
 */
public class WallpaperService extends Service {

    Timer mytimer;
    int interval=60000;
    Drawable drawable;
    WallpaperManager wpm;
    int prev=1;

    @Override
    public void onCreate() {
        super.onCreate();
        mytimer=new Timer();
        wpm=WallpaperManager.getInstance(WallpaperService.this);
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mytimer.schedule(new TimerTask() {
            @Override
            public void run() {

                if(prev==1){
                    drawable = getResources().getDrawable(R.drawable.one);
                    prev=2;
                }
                else if(prev==2){
                    drawable = getResources().getDrawable(R.drawable.two);
                    prev=3;
                }
                else{
                    drawable = getResources().getDrawable(R.drawable.three);
                    prev=1;
                }


                Bitmap wallpaper=((BitmapDrawable)drawable).getBitmap();

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
}