package com.obrero.cmycountry.dto;

import android.graphics.Bitmap;

/**
 * Created by Eefret on 3/1/14.
 */
public class ImageItem {
    private Bitmap image;
    private String title;
    private int rawItem;

    public ImageItem(Bitmap image, String title, int rawItem) {
        this.image = image;
        this.title = title;
        this.rawItem = rawItem;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRawItem() {
        return rawItem;
    }

    public void setRawItem(int rawItem) {
        this.rawItem = rawItem;
    }
}
