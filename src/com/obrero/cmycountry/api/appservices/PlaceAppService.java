package com.obrero.cmycountry.api.appservices;

import com.obrero.cmycountry.dto.Place;
import com.obrero.cmycountry.dto.Point;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 3/1/14
 * Time: 3:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlaceAppService {

    private List<Place> places = new LinkedList<Place>();

    public PlaceAppService() {
        for (int ind = 1; ind <= 10; ind++){
            places.add(new Place("Nombre"+ind, "Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description " + ind, null));
        }
    }

    public List<Place> getNearPlaces (Point point){
        return places;
    }
}
