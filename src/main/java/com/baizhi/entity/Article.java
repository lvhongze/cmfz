package com.baizhi.entity;

import java.io.Serializable;

public class Article implements Serializable {
    private String id;
    private String name;
    private String photoPath;
    private String text;
    private String illuStration;
    private String ext;
    private String download;
    private String guruid;

    public Article() {
    }

    public Article(String id, String name, String photoPath, String text, String illuStration, String ext, String download, String guruid) {
        this.id = id;
        this.name = name;
        this.photoPath = photoPath;
        this.text = text;
        this.illuStration = illuStration;
        this.ext = ext;
        this.download = download;
        this.guruid = guruid;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", photoPath='" + photoPath + '\'' +
                ", text='" + text + '\'' +
                ", illuStration='" + illuStration + '\'' +
                ", ext='" + ext + '\'' +
                ", download='" + download + '\'' +
                ", guruid='" + guruid + '\'' +
                '}';
    }

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

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIlluStration() {
        return illuStration;
    }

    public void setIlluStration(String illuStration) {
        this.illuStration = illuStration;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getDownload() {
        return download;
    }

    public void setDownload(String download) {
        this.download = download;
    }

    public String getGuruid() {
        return guruid;
    }

    public void setGuruid(String guruid) {
        this.guruid = guruid;
    }
}
