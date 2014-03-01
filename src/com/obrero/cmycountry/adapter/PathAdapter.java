package com.obrero.cmycountry.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.obrero.cmycountry.R;
import com.obrero.cmycountry.dto.Path;

/**
 * Created by BlackShadow on 3/1/14.
 */
public class PathAdapter extends ArrayAdapter<Path> {
    public PathAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.path_item_layout,null);
        }

        Path item = getItem(position);

        TextView name = (TextView)convertView.findViewById(R.id.txt_name_item_path);
        TextView description = (TextView)convertView.findViewById(R.id.txt_descripcion_item_path);

        name.setText(item.getName());
        description.setText(item.getDescription());

        return convertView;
    }
}
