<<<<<<< HEAD
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
    public static List<Place> places = new ArrayList<Place>();
    private static Random rand = new Random();

    public static List<Place> getPlaces(){
        if( places.size() < 1 ){
            for(int i=0;i<10;i++){
                places.add(new Place("Place " + i,detailsExample,"http://www.lipsum.com/"));
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
=======
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
>>>>>>> 0b18ee89ce8fddd39c61b81b4fd0a38ed4c35792
