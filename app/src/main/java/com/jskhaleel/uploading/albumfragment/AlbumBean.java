package com.jskhaleel.uploading.albumfragment;

import java.io.Serializable;

public class AlbumBean implements Serializable {

    public String id, imgUrl;

    public AlbumBean(String id, String imgUrl) {
        this.id = id;
        this.imgUrl = imgUrl;
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

    @Override
    public String toString() {
        return "AlbumBean{" +
                "id='" + id + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
