package com.example.nickolas.vidme.model.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nickolas on 21.09.2017.
 */

public class Video {
    //    let id: String
//    let url: String
//    let title: String
//    let description: String
//    let likesCount: Int
//    let thumbnailUrl: String
//    let height: Double
//    let width: Double
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

}
