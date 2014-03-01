package com.obrero.cmycountry.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.obrero.cmycountry.R;
import com.obrero.cmycountry.adapter.PlaceAdapter;
import com.obrero.cmycountry.dto.Place;
import com.obrero.cmycountry.services.ServiceData;

import java.util.List;

/**
 * Created by BlackShadow on 3/1/14.
 */
public class PathFragment extends Fragment {
    public PathFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.path_fragment_layout, container, false);

        List<Place> places = ServiceData.getPlaces();

        PlaceAdapter adapter = new PlaceAdapter(getActivity(),R.layout.path_item_layout);
        adapter.addAll(places);

        ListView lv = (ListView)rootView.findViewById(R.id.lv_path_fragment);
        lv.setAdapter(adapter);

        return rootView;
    }
}
