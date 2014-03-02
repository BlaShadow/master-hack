package com.obrero.cmycountry.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.obrero.cmycountry.R;

/**
 * Created by Eefret on three/one/14.
 */
public class HomeFragment extends Fragment {
    public HomeFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home_fragment_layout, container, false);

        return rootView;
    }
}
