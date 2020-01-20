package com.kareemradwan.foodapp.model;

public class AboutModel {

    private int imageIcon;
    private String title;
    private String description;


    public AboutModel() {
    }

    public AboutModel(int imageIcon, String title, String description) {
        this.imageIcon = imageIcon;
        this.title = title;
        this.description = description;
    }


    public int getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(int imageIcon) {
        this.imageIcon = imageIcon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
