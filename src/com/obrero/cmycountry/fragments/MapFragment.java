package com.obrero.cmycountry.fragments;

import android.app.Fragment;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import com.obrero.cmycountry.R;
import com.obrero.cmycountry.adapter.GridViewAdapter;
import android.widget.AdapterView.OnItemClickListener;
import com.obrero.cmycountry.dto.ImageItem;

import java.util.ArrayList;

/**
 * Created by Eefretsoul on 3/1/14.
 */
public class MapFragment extends Fragment {
    private GridView gridview;
    private GridViewAdapter customGridAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.map_fragment_layout, container, false);

        gridview = (GridView) rootView.findViewById(R.id.gridView);
        customGridAdapter = new GridViewAdapter(getActivity(),R.layout.row_grid,getImages());
        gridview.setAdapter(customGridAdapter);

        gridview.setOnItemClickListener(new OnItemClickListener (){

            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getActivity(), position + "#Selected",
                        Toast.LENGTH_SHORT).show();
            }
        });


        return rootView;
    }

    private ArrayList<ImageItem> getImages(){
        ArrayList<ImageItem> imageItems = new ArrayList<ImageItem>();
        TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);

        BitmapFactory.Options o=new BitmapFactory.Options();
        o.inSampleSize = 4;
        o.inDither=false;                     //Disable Dithering mode
        o.inPurgeable=true;                   //Tell to gc that whether it needs free memory, the Bitmap can be cleared



        for(int i = 0; i < imgs.length(); i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getActivity().getResources(),
                    imgs.getResourceId(i, -1),o);
            imageItems.add(new ImageItem(bitmap, "Image#" + i,imgs.getResourceId(i,-1)));
        }


        return imageItems;
    }

}
