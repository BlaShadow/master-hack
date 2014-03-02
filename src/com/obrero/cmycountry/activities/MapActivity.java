package com.obrero.cmycountry.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.obrero.cmycountry.R;
import com.obrero.cmycountry.dto.Place;

import java.util.List;

/**
 * Created by BlackShadow on 3/1/14.
 */
public class MapActivity extends FragmentActivity {

    //private GoogleMap map;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity_layout);

        //map = ((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
//
//        // pintara un path
//        if( getIntent().hasExtra(PathFragment.PATH) ){
//
//            Path path = (Path)getIntent().getExtras().getSerializable(PathFragment.PATH);
//            DrawOnMap(null);
//
//            //pintara un place y sus fotos
//        }else if( getIntent().hasExtra(PlaceFragment.PATH) ){
//
//            DrawOnMap(null);
//            Place place = (Place)getIntent().getExtras().getSerializable(PlaceFragment.PATH);
//        }
    }

    public void DrawOnMap(List<Place> places){

        /*map.addMarker(new MarkerOptions()
                .position(new LatLng(19.079552, -70.824278))
                .title("Titulo")
                .snippet("Descirpcion place")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.location_icon)));
        */
        //19.079552, -70.824278
    }

}