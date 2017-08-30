package com.justforfun.test.model;

/**
 * Created by hectormoreno on 8/30/17.
 */

public class Promotion {

    int id;
    String title = "";
    String shortTitle = "";
    String subtitle = "";

    String description = "";

    int image;
    int logo;

    public Promotion(int id, String title, String shortTitle, String subtitle, String description, int image, int logo){
        this.id = id;
        this.title = title;
        this.shortTitle = shortTitle;
        this.subtitle = subtitle;
        this.description = description;
        this.image = image;
        this.logo = logo;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getDescription() {
        return description;
    }

    public int getLogo() {
        return logo;
    }

    public int getId() {
        return id;
    }
}
