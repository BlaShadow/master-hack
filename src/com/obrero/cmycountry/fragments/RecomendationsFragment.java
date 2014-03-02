package com.obrero.cmycountry.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.obrero.cmycountry.R;
import com.obrero.cmycountry.adapter.PathAdapter;
import com.obrero.cmycountry.dto.Path;
import com.obrero.cmycountry.services.ServiceData;

import java.util.List;

/**
 * Created by BlackShadow on 3/1/14.
 */
public class RecomendationsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recomendation_fragment_layout, container, false);

        List<Path> paths = ServiceData.getPaths();

        PathAdapter adapter = new PathAdapter(getActivity(),R.layout.place_item_layout);
        adapter.addAll(paths);

        ListView lv = (ListView)rootView.findViewById(R.id.lv_place_fragment);
        lv.setAdapter(adapter);

        return rootView;
    }
}
