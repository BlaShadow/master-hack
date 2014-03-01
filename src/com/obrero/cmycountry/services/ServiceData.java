package com.obrero.cmycountry.services;

import com.obrero.cmycountry.dto.Path;
import com.obrero.cmycountry.dto.Place;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BlackShadow on 3/1/14.
 */
public class ServiceData {
    public static List<Place> getPlaces(){
        List<Place> results = new ArrayList<Place>();

        for(int i=0;i<10;i++){
            results.add(new Place("nombre " + i,"Descripcion ","linkwikipage"));
        }

        return  results;
    }

    public static List<Path> getPaths(){
        List<Path> results = new ArrayList<Path>();

        for(int i=0;i<10;i++){
            results.add(new Path("nombre Path" + i,"Descripcion path"));
        }

        return  results;
    }
}
