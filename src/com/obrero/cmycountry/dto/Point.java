package com.obrero.cmycountry.dto;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 3/1/14
 * Time: 3:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class Point {

    private double latitude;
    private  double longitude;

    public Point(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
