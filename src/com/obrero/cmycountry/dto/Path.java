package com.obrero.cmycountry.dto;

import java.util.List;

/**
 * Created by BlackShadow on 3/1/14.
 */
public class Path {
    private String name;
    private String Description;
    private List<Picture> pictures;
    private List<Place> places;

    public Path(String name, String description) {
        this.name = name;
        Description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }
}
