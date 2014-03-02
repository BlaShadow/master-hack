package com.obrero.cmycountry.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.obrero.cmycountry.R;
import com.obrero.cmycountry.activities.Home;
import com.obrero.cmycountry.activities.PlaceDetailsActivity;
import com.obrero.cmycountry.adapter.PathAdapter;
import com.obrero.cmycountry.adapter.PlaceAdapter;
import com.obrero.cmycountry.dto.Path;
import com.obrero.cmycountry.dto.Place;
import com.obrero.cmycountry.services.ServiceData;

import java.util.List;

/**
 * Created by BlackShadow on 3/1/14.
 */
public class PlaceFragment extends Fragment {

    public static String PATH = "PATH";

    public PlaceFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_fragment_layout, container, false);

        List<Place> places = ServiceData.getPlaces();

        PlaceAdapter adapter = new PlaceAdapter(getActivity(),R.layout.path_item_layout);
        adapter.addAll(places);

        ListView lv = (ListView)rootView.findViewById(R.id.lv_place_fragment);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent tmpItent = new Intent(getActivity(),PlaceDetailsActivity.class);
                startActivity(tmpItent);
            }
        });

        return rootView;
    }
}
