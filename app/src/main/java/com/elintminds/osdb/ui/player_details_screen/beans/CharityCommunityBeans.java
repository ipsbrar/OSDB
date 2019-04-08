package com.elintminds.osdb.ui.player_details_screen.beans;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CharityCommunityBeans implements Serializable {
    private String contentText, imgUrl;

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
