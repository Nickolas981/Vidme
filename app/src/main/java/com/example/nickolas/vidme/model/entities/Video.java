package com.example.nickolas.vidme.model.entities;

import com.google.gson.annotations.SerializedName;

public class Video {

    @SerializedName("video_id")
    private String id;
    @SerializedName("complete_url")
    private String url;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String desc;
    @SerializedName("thumbnail_url")
    private String thumbnailUrl;
    @SerializedName("height")
    private double height;
    @SerializedName("width")
    private double width;
    @SerializedName("likes_count")
    private int likesCount;

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public int getLikesCount() {
        return likesCount;
    }
}
