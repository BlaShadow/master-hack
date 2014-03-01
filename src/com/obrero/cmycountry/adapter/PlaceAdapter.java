package com.obrero.cmycountry.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.obrero.cmycountry.R;
import com.obrero.cmycountry.dto.Place;

/**
 * Created by BlackShadow on 3/1/14.
 */
public class PlaceAdapter extends ArrayAdapter<Place>{
    public PlaceAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.place_item_layout,null);
        }

        Place item = getItem(position);

        TextView name = (TextView)convertView.findViewById(R.id.txt_name_item_place);
        TextView description = (TextView)convertView.findViewById(R.id.txt_descripcion_item_place);

        name.setText(item.getName());
        description.setText(item.getDescription());

        return convertView;
    }
}
