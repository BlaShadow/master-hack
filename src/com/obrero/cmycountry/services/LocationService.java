package com.obrero.cmycountry.services;

import android.app.*;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.obrero.cmycountry.R;
import com.obrero.cmycountry.activities.Home;
import com.obrero.cmycountry.api.appservices.PlaceAppService;
import com.obrero.cmycountry.dto.Place;
import com.obrero.cmycountry.dto.Point;
import com.obrero.cmycountry.utils.Converter;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: dragon
 * Date: 3/1/14
 * Time: 8:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class LocationService extends Service implements LocationListener {

    private Context currentContext;

    private static final String TAG = "LocationService";

    /***
    * Equivalent to 1 (one) minute
     */
    private static final long MIN_TIME_BETWEEN_UPDATE = 1000 * 60 * 1;

    /***
     * Equivalent to 20 meters
     */
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATE = 20;


    private boolean isGpsEnabled;

    private boolean isNetworkEnabled;

    private boolean canGetLocation;

    protected LocationManager locationManager;

    private Timer timer = new Timer();

    private Handler handler = new Handler();

    private Location lastLocation;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "Enter on onStartCommand");
        this.currentContext = getApplicationContext();
        initLocationManager();
        initProviders();
        setRequestLocationUpdates();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Location location = getLocation();
                if (lastLocation == null || !lastLocation.equals(location)){
                    onLocationChanged(location);
                    lastLocation = location;
                }
            }
        }, 0, MIN_TIME_BETWEEN_UPDATE);

        return super.onStartCommand(intent, flags, startId);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    private void initLocationManager(){
        this.locationManager = Converter.doConvert(LocationManager.class,
                this.currentContext.getSystemService(LOCATION_SERVICE));
    }

    private void initProviders(){
        if (canUseLocationManager()){
            isGpsEnabled = this.locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            isNetworkEnabled = this.locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        }
    }

    private void setRequestLocationUpdates(){
        if(isNetworkEnabled){
            Log.i(TAG, "Network provider");

            this.locationManager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER,
                    MIN_TIME_BETWEEN_UPDATE,
                    MIN_DISTANCE_CHANGE_FOR_UPDATE,
                    this);
        }

        if (isGpsEnabled){
            Log.i(TAG, "GPS provider");

            this.locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    MIN_TIME_BETWEEN_UPDATE,
                    MIN_DISTANCE_CHANGE_FOR_UPDATE,
                    this);
        }
    }

    private Location getLocation(){
        Location location = null;

        if (isGpsEnabled){
            location = this.locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        }

        if (isNetworkEnabled){
            location = this.locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        }

        return location;
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onLocationChanged(Location location) {
        PlaceAppService placeAppService = new PlaceAppService();
        List<Place> places = placeAppService.getNearPlaces(new Point(location.getLongitude(), location.getLatitude()));
        Notification notification = null;
        if (places.size() == 1){
            notification = createNotificationFromPlace(places.get(0));
        }
        else{
            notification = createNotificationFromPlacesList(places);
        }
        pushNotifications(notification);
    }

    private Notification createNotificationFromPlace(Place place){
        Intent resultIntent = new Intent(this, Home.class);
        Notification notification = createNotification(place.getName(), place.getDescription(), resultIntent, Home.class);
        return notification;
    }

    private Notification createNotificationFromPlacesList(List<Place> places){
        Intent resultIntent = new Intent(this, Home.class);
        Place firstPlace = places.get(0);
        Notification.Builder builder = createNotificationBuilder(firstPlace.getName(), firstPlace.getDescription(), resultIntent, Home.class);
        List<Place> placesWithoutFirstPlace = places.subList(1, places.size() - 1);
        builder.setStyle(createNotificationInboxStyle(placesWithoutFirstPlace));
        return builder.build();
    }

    private Notification createNotification(String title, String content, Intent resultIntent, Class<?> resultIntentType) {
        Notification.Builder builder = createNotificationBuilder(title, content, resultIntent, resultIntentType);
        return builder.build();
    }

    private Notification.Builder createNotificationBuilder(String title, String content, Intent resultIntent, Class<?> resultIntentType){
        Notification.Builder mBuilder = new Notification.Builder(this)
                                                            .setSmallIcon(R.drawable.ic_launcher)
                                                            .setContentTitle(title)
                                                            .setStyle(new Notification.BigTextStyle().bigText(content));

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(getApplicationContext());

        stackBuilder.addParentStack(resultIntentType);

        stackBuilder.addNextIntent(resultIntent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(pendingIntent);

        return mBuilder;
    }

    private Notification.InboxStyle createNotificationInboxStyle(List<Place> places){
        Notification.InboxStyle inboxStyle = new Notification.InboxStyle();
        inboxStyle.setBigContentTitle(getResources().getString(R.string.otherPlaces));
        for(Place place : places){
            inboxStyle.addLine(place.getName());
        }
        return inboxStyle;
    }




    private void pushNotifications(Notification notification){
        NotificationManager notificationManager = getNotificationManager();

        Log.i(TAG, "Before push Notification");
        notificationManager.notify(0, notification);
        Log.i(TAG, "After push Notification");
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        //To change body of implemented methods use File | Settings | File Templates.
        Log.i(TAG, "Status Changed");
    }

    @Override
    public void onProviderEnabled(String provider) {
        initProviders();
        setRequestLocationUpdates();

        Log.i(TAG, "Provider Enabled");
    }

    @Override
    public void onProviderDisabled(String provider) {
        //To change body of implemented methods use File | Settings | File Templates.
        initProviders();
        setRequestLocationUpdates();

        Log.i(TAG, "Provider Disabled");
    }

    private boolean canUseLocationManager(){
        return this.locationManager != null;
    }

    NotificationManager notificationManager;
    private NotificationManager getNotificationManager(){
        if (notificationManager == null){
            notificationManager = Converter.doConvert(NotificationManager.class, getSystemService(NOTIFICATION_SERVICE));
        }
        return notificationManager;
    }


}
