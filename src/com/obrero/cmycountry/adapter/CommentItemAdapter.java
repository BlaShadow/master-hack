package com.obrero.cmycountry.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.obrero.cmycountry.R;
import com.obrero.cmycountry.dto.CommentItem;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Eefret on 3/1/14.
 */
public class CommentItemAdapter extends ArrayAdapter<CommentItem> {

    private static final String TAG = "CommentItemAdapter";

    private Context context;
    private ArrayList<CommentItem> entries;

    public CommentItemAdapter(Context context,  ArrayList<CommentItem> entries) {
        super(context, R.layout.full_image_comment_item, entries);
        this.context = context;
        this.entries = entries;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CommentItemHolder holder;
        ImageView userImage;
        TextView commentDate;
        TextView comment;


        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.full_image_comment_item,parent,false);

            userImage = (ImageView) convertView.findViewById(R.id.full_image_comment_user_image);
            commentDate = (TextView) convertView.findViewById(R.id.full_image_comment_date);
            comment = (TextView) convertView.findViewById(R.id.full_image_comment_comment);

            holder = new CommentItemHolder(userImage,commentDate,comment);
            convertView.setTag(holder);
        }

        holder = (CommentItemHolder) convertView.getTag();

        holder.getUserImage().setImageResource(entries.get(position).getUserImage());
        holder.getCommentDate().setText(entries.get(position).getCommentDate());
        holder.getComment().setText(entries.get(position).getComment());

        return convertView;
    }


    private class CommentItemHolder{

        private ImageView userImage;
        private TextView commentDate;
        private TextView comment;

        private CommentItemHolder(ImageView userImage, TextView commentDate, TextView comment) {
            this.userImage = userImage;
            this.commentDate = commentDate;
            this.comment = comment;
        }

        public ImageView getUserImage() {
            return userImage;
        }

        public TextView getCommentDate() {
            return commentDate;
        }

        public TextView getComment() {
            return comment;
        }
    }
}
