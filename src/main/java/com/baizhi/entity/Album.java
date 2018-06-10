package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Album implements Serializable {
    private String id;
    private String name;
    private String score;
    private String author;
    private String announcer;
    private Integer episode;
    private String introduce;
    private Date date;
    private String cover;
    private Integer downloadcodes;
    private List<Chapter> children;

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getAnnouncer() {
        return announcer;
    }

    public void setAnnouncer(String announcer) {
        this.announcer = announcer;
    }

    public Integer getEpisode() {
        return episode;
    }

    public void setEpisode(Integer episode) {
        this.episode = episode;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getDownloadcodes() {
        return downloadcodes;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDownloadcodes(Integer downloadcodes) {
        this.downloadcodes = downloadcodes;
    }

    public Album() {
    }


    public Album(String id, String name, String score, String author, String announcer, Integer episode, String introduce, Date date, String cover, Integer downloadcodes, List<Chapter> children) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.author = author;
        this.announcer = announcer;
        this.episode = episode;
        this.introduce = introduce;
        this.date = date;
        this.cover = cover;
        this.downloadcodes = downloadcodes;
        this.children = children;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", score='" + score + '\'' +
                ", author='" + author + '\'' +
                ", announcer='" + announcer + '\'' +
                ", episode=" + episode +
                ", introduce='" + introduce + '\'' +
                ", date=" + date +
                ", cover='" + cover + '\'' +
                ", downloadcodes=" + downloadcodes +
                ", children=" + children +
                '}';
    }
}

