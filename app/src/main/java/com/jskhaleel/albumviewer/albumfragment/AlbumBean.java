package com.jskhaleel.albumviewer.albumfragment;

import java.io.Serializable;

public class AlbumBean implements Serializable {

    public String id, imgUrl, imgThumbUrl;

    public AlbumBean(String id, String imgUrl, String imgThumbUrl) {
        this.id = id;
        this.imgUrl = imgUrl;

        this.imgThumbUrl = imgThumbUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgThumbUrl() {
        return imgThumbUrl;
    }

    public void setImgThumbUrl(String imgThumbUrl) {
        this.imgThumbUrl = imgThumbUrl;
    }


    @Override
    public String toString() {
        return "AlbumBean{" +
                "id='" + id + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
