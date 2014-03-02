package com.obrero.cmycountry.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.obrero.cmycountry.R;
import com.obrero.cmycountry.activities.FullImageActivity;
import com.obrero.cmycountry.dto.ImageItem;
import com.obrero.cmycountry.tasks.*;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Created by Eefret on 3/1/14.
 */
public class GridViewAdapter extends ArrayAdapter<ImageItem> {
    private static final String TAG = "GridViewAdapter";
    private Context context;
    private int layoutResourceId;
    private ViewHolder holder = null;
    public static int imageid;
    private ArrayList<ImageItem> data = new ArrayList<ImageItem>();
    private int rawItem;
    private Bitmap PlaceHolderBitmap;

    public GridViewAdapter(Context context, int layoutResourceId,
                           ArrayList<ImageItem> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;


        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.imageTitle = (TextView) row.findViewById(R.id.text);
            holder.image = (ImageView) row.findViewById(R.id.image);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        ImageItem item = data.get(position);
        holder.imageTitle.setText(item.getTitle());
        holder.image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        //holder.image.setLayoutParams(new GridView.LayoutParams(GridView.LayoutParams.MATCH_PARENT, GridView.LayoutParams.MATCH_PARENT));
        //holder.image.setImageResource(item.getRawItem());
        loadBitmap(item.getRawItem(),holder.image,PlaceHolderBitmap);
        holder.image.setTag(item.getRawItem());


        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, view.getId() + " clicked");
                Intent intent = new Intent(context, FullImageActivity.class);
                //Log.d(TAG,String.valueOf(view.findViewById(R.id.full_image_image).getId()));
                intent.putExtra("image", view.getTag().toString());
                //imageid = view.getId();

                //Drawable d = getContext().getResources().getDrawable(view.getId());

                Log.i(TAG, rawItem + "" );

                context.startActivity(intent);

            }
        });
        return row;
    }

    public void loadBitmap(int resId, ImageView imageView,Bitmap mPlaceHolderBitmap) {
        if (cancelPotentialWork(resId, imageView)) {
            final BitmapWorkerTask task = new BitmapWorkerTask(context,imageView);
            final AsyncDrawable asyncDrawable =
                    new AsyncDrawable(context.getResources(), mPlaceHolderBitmap, task);

            imageView.setImageDrawable(asyncDrawable);
            task.execute(resId);
        }
    }

    static class AsyncDrawable extends BitmapDrawable {
        private final WeakReference<BitmapWorkerTask> bitmapWorkerTaskReference;

        public AsyncDrawable(Resources res, Bitmap bitmap,
                             BitmapWorkerTask bitmapWorkerTask) {
            super(res, bitmap);
            bitmapWorkerTaskReference =
                    new WeakReference<BitmapWorkerTask>(bitmapWorkerTask);
        }

        public BitmapWorkerTask getBitmapWorkerTask() {
            return bitmapWorkerTaskReference.get();
        }
    }

    public static boolean cancelPotentialWork(int data, ImageView imageView) {
        final BitmapWorkerTask bitmapWorkerTask = getBitmapWorkerTask(imageView);

        if (bitmapWorkerTask != null) {
            final int bitmapData = bitmapWorkerTask.data;
            if (bitmapData != data) {
                // Cancel previous task
                bitmapWorkerTask.cancel(true);
            } else {
                // The same work is already in progress
                return false;
            }
        }
        // No task associated with the ImageView, or an existing task was cancelled
        return true;
    }

    private static BitmapWorkerTask getBitmapWorkerTask(ImageView imageView) {
        if (imageView != null) {
            final Drawable drawable = imageView.getDrawable();
            if (drawable instanceof AsyncDrawable) {
                final AsyncDrawable asyncDrawable = (AsyncDrawable) drawable;
                return asyncDrawable.getBitmapWorkerTask();
            }
        }
        return null;
    }

    static class ViewHolder {
        TextView imageTitle;
        ImageView image;
    }


}