package com.obrero.cmycountry.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.obrero.cmycountry.R;
import com.obrero.cmycountry.adapter.PlaceAdapter;
import com.obrero.cmycountry.dto.Place;
import com.obrero.cmycountry.services.ServiceData;

import java.util.List;

/**
 * Created by BlackShadow on 3/1/14.
 */
public class PlaceDetailsFragment extends Fragment {

    private int placeID;

    public PlaceDetailsFragment(int id){
        this.placeID = id;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_details_fragment, container, false);

        TextView title = (TextView)rootView.findViewById(R.id.txt_name_details_place);
        TextView details = (TextView)rootView.findViewById(R.id.txt_details_details_place);
        TextView moreInfo = (TextView)rootView.findViewById(R.id.txt_more_details_place);

        Place itemPlace = ServiceData.getCurrentPlace();

        title.setText(itemPlace.getName());
        details.setText(ServiceData.detailsExample);
        moreInfo.setText( Html.fromHtml("<a href='http://google.com'>Mas Informacion</a>") );

        moreInfo.setClickable(true);
        moreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://google.com";
                Intent tmpIntent = new Intent(Intent.ACTION_VIEW);
                tmpIntent.setData(Uri.parse(url));
                startActivity(tmpIntent);
            }
        });

        return rootView;
    }

}
