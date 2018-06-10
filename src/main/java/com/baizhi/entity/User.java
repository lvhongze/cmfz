package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String id;
    private String name;
    private String photoNum;
    private String password;
    private String farmington;
    private int sex;
    private String photo;
    private String localtion;
    private String province;
    private String city;
    private String description;
    private String guruid;
    private int status;
    private Date date;

    public User() {
    }

    public User(String id, String name, String photoNum, String password, String farmington, int sex, String photo, String localtion, String province, String city, String description, String guruid, int status, Date date) {
        this.id = id;
        this.name = name;
        this.photoNum = photoNum;
        this.password = password;
        this.farmington = farmington;
        this.sex = sex;
        this.photo = photo;
        this.localtion = localtion;
        this.province = province;
        this.city = city;
        this.description = description;
        this.guruid = guruid;
        this.status = status;
        this.date = date;
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

    public String getPhotoNum() {
        return photoNum;
    }

    public void setPhotoNum(String photoNum) {
        this.photoNum = photoNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFarmington() {
        return farmington;
    }

    public void setFarmington(String farmington) {
        this.farmington = farmington;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLocaltion() {
        return localtion;
    }

    public void setLocaltion(String localtion) {
        this.localtion = localtion;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGuruid() {
        return guruid;
    }

    public void setGuruid(String guruid) {
        this.guruid = guruid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", photoNum='" + photoNum + '\'' +
                ", password='" + password + '\'' +
                ", farmington='" + farmington + '\'' +
                ", sex=" + sex +
                ", photo='" + photo + '\'' +
                ", localtion='" + localtion + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", description='" + description + '\'' +
                ", guruid='" + guruid + '\'' +
                ", status=" + status +
                ", date=" + date +
                '}';
    }
}
