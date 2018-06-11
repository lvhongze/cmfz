package com.baizhi.entity;

import java.util.Date;

/**
 * Created with IDEA
 * 类功能描述:
 *
 * @author:Z大 Date:2018/6/11
 * Time:20:00
 */
public class Logs {
    private String id;
    private String name;
    private String method;
    private Date date;
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

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Logs() {
    }

    public Logs(String id, String name, String method, Date date, int status) {
        this.id = id;
        this.name = name;
        this.method = method;
        this.date = date;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Logs{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", method='" + method + '\'' +
                ", date=" + date +
                ", status=" + status +
                '}';
    }
}
