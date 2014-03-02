package com.obrero.cmycountry.dto;

import android.location.Location;

import java.util.List;

/**
 * Created by BlackShadow on 3/1/14.
 */
public class Place {
    private String name;
    private String description;
    private String wikiPage;
    private Location location;
    private List<Picture> pictures;

    public Place(String name, String description, String wikiPage) {
        this.name = name;
        this.description = description;
        this.wikiPage = wikiPage;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getWikiPage() {
        return wikiPage;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWikiPage(String wikiPage) {
        this.wikiPage = wikiPage;
    }
}
