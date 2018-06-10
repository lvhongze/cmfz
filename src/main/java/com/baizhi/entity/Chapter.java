package com.baizhi.entity;

import java.io.Serializable;

public class Chapter implements Serializable {
    private String id;
    private String name;
    private String download_url;
    private String size;
    private String length;
    private String album_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDownload_url() {
        return download_url;
    }

    public void setDownload_url(String download_url) {
        this.download_url = download_url;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }

    public Chapter() {
    }

    public Chapter(String id, String name, String download_url, String size, String length, String album_id) {
        this.id = id;
        this.name = name;
        this.download_url = download_url;
        this.size = size;
        this.length = length;
        this.album_id = album_id;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", download_url='" + download_url + '\'' +
                ", size=" + size +
                ", length=" + length +
                ", album_id='" + album_id + '\'' +
                '}';
    }

}
