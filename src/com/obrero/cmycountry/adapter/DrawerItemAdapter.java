package com.obrero.cmycountry.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.obrero.cmycountry.R;
import com.obrero.cmycountry.dto.DrawerItem;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Eefret on three/one/14.
 */
public class DrawerItemAdapter extends ArrayAdapter<DrawerItem> {

    private static final String TAG = "DrawerItemAdapter";
    private final Context context;
    private final ArrayList<DrawerItem> entries;

    public DrawerItemAdapter(Context context, ArrayList<DrawerItem> entries) {
        super(context, R.layout.drawer_item, entries);
        this.context = context;
        this.entries = entries;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DrawerItemHolder holder;
        ImageView icon;
        DrawerItem item = getItem(position);

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.drawer_item,parent,false);

            TextView title = (TextView)convertView.findViewById(R.id.drawer_item_txt);
            title.setText(item.getTitle());

            icon = (ImageView) convertView.findViewById(R.id.drawer_item_icon);
            holder = new DrawerItemHolder(icon);
            convertView.setTag(holder);
        }

        holder = (DrawerItemHolder) convertView.getTag();
        holder.getIcon().setImageResource(entries.get(position).getIcon());

        return convertView;
    }


    private class DrawerItemHolder{
        private ImageView icon;

        private DrawerItemHolder(ImageView icon) {
            this.icon = icon;
        }

        public ImageView getIcon() {
            return icon;
        }
    }
}
