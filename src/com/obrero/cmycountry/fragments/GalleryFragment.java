package com.obrero.cmycountry.fragments;

import android.app.Fragment;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import com.obrero.cmycountry.R;
import com.obrero.cmycountry.adapter.GridViewAdapter;
import com.obrero.cmycountry.dto.ImageItem;

import java.util.ArrayList;

/**
 * Created by BlackShadow on 3/2/14.
 */
public class GalleryFragment extends Fragment {
    private GridViewAdapter gridViewAdapter;
    private ArrayList<ImageItem> imageItems;
    private GridView gridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_fragment_layout, null);

        gridView = (GridView) rootView.findViewById(R.id.gridView);
        gridViewAdapter = new GridViewAdapter(getActivity(),R.layout.row_grid,getData());

        gridView.setAdapter(gridViewAdapter);

        return gridView;
    }

    private ArrayList<ImageItem> getData(){
        imageItems = new ArrayList<ImageItem>();
        // retrieve String drawable array
        TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);
        for (int i = 0; i < imgs.length(); i++) {

            BitmapFactory.Options o=new BitmapFactory.Options();
            o.inSampleSize = 4;
            o.inDither=false;                     //Disable Dithering mode
            o.inPurgeable=true;
            Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),
                    imgs.getResourceId(i, -1),o);

            imageItems.add(new ImageItem(bitmap, "Image#" + i,imgs.getResourceId(i,-1)));
        }

        return imageItems;
    }
}
