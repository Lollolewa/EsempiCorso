package org.generation.italy.examples.interfaces.travelagency;

import java.util.List;

public class Destination {
    private String mvp;
    private String description;
    private int daySpent;
    private String place;
    private List<String> thumberg;
    private List<String> rest;

    public Destination(String mvp, String description, int daySpent, String place, List<String> thumberg, List<String> rest) {
        this.mvp = mvp;
        this.description = description;
        this.daySpent = daySpent;
        this.place = place;
        this.thumberg = thumberg;
        this.rest = rest;
    }

    public String getMvp() {
        return mvp;
    }

    public void setMvp(String mvp) {
        this.mvp = mvp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDaySpent() {
        return daySpent;
    }

    public void setDaySpent(int daySpent) {
        this.daySpent = daySpent;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public List<String> getThumberg() {
        return thumberg;
    }

    public void setThumberg(List<String> thumberg) {
        this.thumberg = thumberg;
    }

    public List<String> getRest() {
        return rest;
    }

    public void setRest(List<String> rest) {
        this.rest = rest;
    }
}
