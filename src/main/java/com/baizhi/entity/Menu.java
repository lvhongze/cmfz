package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

public class Menu implements Serializable {
    private String id;
    private String name;
    private String iconCls;
    private String href;
    private String parentid;
    private List<Menu> menuChilder;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIconCls() {
        return iconCls;
    }

    public String getHref() {
        return href;
    }

    public String getParentid() {
        return parentid;
    }

    public Menu() {
    }

    public List<Menu> getMenuChilder() {
        return menuChilder;
    }

    public void setMenuChilder(List<Menu> menuChilder) {
        this.menuChilder = menuChilder;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", href='" + href + '\'' +
                ", parentid='" + parentid + '\'' +
                ", menuChilder=" + menuChilder +
                '}';
    }

    public Menu(String id, String name, String iconCls, String href, String parentid, List<Menu> menuChilder) {
        this.id = id;
        this.name = name;
        this.iconCls = iconCls;
        this.href = href;
        this.parentid = parentid;
        this.menuChilder = menuChilder;
    }
}
