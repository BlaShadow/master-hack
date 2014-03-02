package com.obrero.cmycountry.dto;

/**
 * Created by Eefret on 3/1/14.
 */
public class CommentItem {
    private int userImage;
    private String commentDate;
    private String comment;

    public CommentItem(int userImage, String commentDate, String comment) {
        this.userImage = userImage;
        this.commentDate = commentDate;
        this.comment = comment;
    }

    public int getUserImage() {
        return userImage;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public String getComment() {
        return comment;
    }
}
