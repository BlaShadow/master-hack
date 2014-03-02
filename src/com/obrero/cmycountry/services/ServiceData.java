package com.obrero.cmycountry.services;

import com.obrero.cmycountry.dto.Path;
import com.obrero.cmycountry.dto.Place;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by BlackShadow on 3/1/14.
 */
public class ServiceData {

    public static String detailsExample = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.";
    public static String[] title = {"Parque los 3 ojos", "Parque nacional valle nuevo", "Cueva de pelempito","parque nacional jaragua"};
    public static String[] titlesPaths = {"Ruta Independencia","Ruta Colonizadora","Ruta Aborigen"};
    public static List<Place> places = new ArrayList<Place>();
    private static Random rand = new Random();

    public static List<Place> getPlaces(){
        if( places.size() < 1 ){
            int index = (int)rand.nextDouble() * 3;
            for(int i=0;i<10;i++){
                places.add(new Place(titlesPaths[index] + i,detailsExample,"http://www.lipsum.com/"));
            }
        }
        return  places;
    }

    public static List<Path> getPaths(){
        List<Path> results = new ArrayList<Path>();

        int id = (int)rand.nextDouble() * 4;

        for(int i=0;i<10;i++){
            results.add(new Path(title[id],detailsExample));
        }

        return  results;
    }

    public static Place getCurrentPlace(){
        Random random = new Random();
        int id = (int)random.nextDouble() * 4;

        return new Place( title[id] ,detailsExample,"http://google.com");
    }
}
