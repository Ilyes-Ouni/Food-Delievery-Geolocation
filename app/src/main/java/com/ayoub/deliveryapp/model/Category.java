package com.ayoub.deliveryapp.model;

public class Category {
    private String icon;
    private String name;
    private boolean isNew;


    public Category() {
    }

    public Category(String icon, String name, boolean isNew) {
        this.icon = icon;
        this.name = name;
        this.isNew = isNew;
    }

    public String getIcon() {
        return icon;
    }
    public String getName() {
        return name;
    }
    public boolean getNew() {
        return isNew;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public void setNew(boolean isNew) {
        this.isNew = isNew;
    }
    public void setTitle(String title) {
        this.name = title;
    }
}