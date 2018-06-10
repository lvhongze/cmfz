package com.baizhi.entity;

import java.io.Serializable;

public class TitlePic implements Serializable {
    private String id;
    private String name;
    private String thumbnail;
    private String introduce;
    private int status;

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

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public TitlePic(String id, String name, String thumbnail, String introduce, int status) {
        this.id = id;
        this.name = name;
        this.thumbnail = thumbnail;
        this.introduce = introduce;
        this.status = status;
    }

    public TitlePic() {
    }

    @Override
    public String toString() {
        return "TitlePic{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", introduce='" + introduce + '\'' +
                ", status=" + status +
                '}';
    }
}
