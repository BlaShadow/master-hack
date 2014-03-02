package com.obrero.cmycountry.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;
import com.obrero.cmycountry.R;
import com.obrero.cmycountry.adapter.CommentItemAdapter;
import com.obrero.cmycountry.adapter.GridViewAdapter;
import com.obrero.cmycountry.dto.CommentItem;

import java.util.ArrayList;

/**
 * Created by Eefret on 3/1/14.
 */


public class FullImageActivity extends Activity {

    public static final String TAG = "FullImageActivity";

    public static ArrayList<CommentItem> entries;
    EditText commentInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.full_image_activity);
        Intent i = getIntent();
        int imageBitmap = Integer.parseInt(i.getStringExtra("image"));

        Log.d(TAG,String.valueOf(imageBitmap));
        ImageView image = (ImageView) findViewById(R.id.full_image_image);
        image.setImageResource(imageBitmap);

        Drawable d = getResources().getDrawable(imageBitmap);

        Log.d(TAG,d + "");
        commentInput = (EditText) findViewById(R.id.full_image_write_field);
        ImageButton sendCommmentButton = (ImageButton) findViewById(R.id.full_image_write_button);
        ImageButton showCommentButton = (ImageButton) findViewById(R.id.full_image_comment_button);

        sendCommmentButton.setOnClickListener(clickTrigger);
        showCommentButton.setOnClickListener(clickTrigger);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);

    }



    View.OnClickListener clickTrigger = new View.OnClickListener(){


        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.full_image_comment_button:
                    Toast.makeText(getBaseContext(),"comment button",Toast.LENGTH_SHORT).show();
                    LayoutInflater inflater = getLayoutInflater().from(getBaseContext());
                    ListView list = (ListView) inflater.inflate(R.layout.full_image_comment, null);
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(FullImageActivity.this);
                    alertDialogBuilder.setView(list);
                    entries = new ArrayList<CommentItem>();
                    entries.add(new CommentItem(R.drawable.ic_launcher,"12/12/2014","Lorem Ipsum"));
                    entries.add(new CommentItem(R.drawable.ic_launcher,"12/12/2014","Lorem Ipsum"));
                    entries.add(new CommentItem(R.drawable.ic_launcher,"12/12/2014","Lorem Ipsum"));
                    entries.add(new CommentItem(R.drawable.ic_launcher,"12/12/2014","Lorem Ipsum"));
                    entries.add(new CommentItem(R.drawable.ic_launcher,"12/12/2014","Lorem Ipsum"));
                    entries.add(new CommentItem(R.drawable.ic_launcher,"12/12/2014","Lorem Ipsum"));
                    list.setAdapter(new CommentItemAdapter(getBaseContext(),entries));
                    alertDialogBuilder.setCancelable(false).setPositiveButton("OK",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int id) {
                        dialog.cancel();
                        }});
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                    break;
                //TODO terminar
                case R.id.full_image_write_button:
                    if (commentInput.getText().toString().equals("")){
                        return;
                    }else{
                        entries.add(new CommentItem(R.drawable.ic_launcher,"12/12/2014",commentInput.getText().toString()));
                    }
                    break;
                //TODO terminar
                default:
                    return;
            }
        }
    };
}
