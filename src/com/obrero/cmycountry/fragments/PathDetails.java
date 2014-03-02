package com.obrero.cmycountry.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.obrero.cmycountry.R;
import com.obrero.cmycountry.activities.PlaceDetailsActivity;
import com.obrero.cmycountry.adapter.PathAdapter;
import com.obrero.cmycountry.adapter.PlaceAdapter;
import com.obrero.cmycountry.dto.Path;
import com.obrero.cmycountry.dto.Place;
import com.obrero.cmycountry.services.ServiceData;

import java.util.List;

/**
 * Created by BlackShadow on 3/2/14.
 */
public class PathDetails extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.path_details_fragment_layout, container, false);

        List<Path> paths = ServiceData.getPaths();
        List<Place> places = ServiceData.getPlaces();

        ListView lvPlaces = (ListView)rootView.findViewById(R.id.lv_places_path_details);
        PlaceAdapter placeAdapter = new PlaceAdapter(getActivity(),R.layout.place_item_layout);
        placeAdapter.addAll(places);
        lvPlaces.setAdapter(placeAdapter);

        lvPlaces.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent tmpItent = new Intent(getActivity(),PlaceDetailsActivity.class);
                startActivity(tmpItent);
            }
        });

        Toast.makeText(getActivity(),places.size() + " ",0).show();

        TextView txtNamePath = (TextView)rootView.findViewById(R.id.txt_path_name_path_details);
        TextView txtPathDescripcion = (TextView) rootView.findViewById(R.id.txt_details_path_details);

        Path path = paths.get(0);

        txtNamePath.setText(path.getName());
        txtPathDescripcion.setText(ServiceData.detailsExample);

        return rootView;
    }

}
