package org.generation.italy.examples.interfaces.travelagency;

import java.util.ArrayList;
import java.util.List;

public class Destination {
    private String attractionName, description, stayLocation;
    private int nDays;
    private List<String> suggestedActivities = new ArrayList<>();
    private List<String> suggestedRestaurants = new ArrayList<>();

    public Destination(String attractionName, String description, String stayLocation, int nDays, List<String> suggestedActivities, List<String> suggestedRestaurants) {
        this.attractionName = attractionName;
        this.description = description;
        this.stayLocation = stayLocation;
        this.nDays = nDays;
        this.suggestedActivities = suggestedActivities;
        this.suggestedRestaurants = suggestedRestaurants;
    }

    public String getAttractionName() {
        return attractionName;
    }

    public void setAttractionName(String attractionName) {
        this.attractionName = attractionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStayLocation() {
        return stayLocation;
    }

    public void setStayLocation(String stayLocation) {
        this.stayLocation = stayLocation;
    }

    public int getnDays() {
        return nDays;
    }

    public void setnDays(int nDays) {
        this.nDays = nDays;
    }

    public List<String> getSuggestedActivities() {
        return suggestedActivities;
    }

    public void setSuggestedActivities(List<String> suggestedActivities) {
        this.suggestedActivities = suggestedActivities;
    }

    public List<String> getSuggestedRestaurants() {
        return suggestedRestaurants;
    }

    public void setSuggestedRestaurants(List<String> suggestedRestaurants) {
        this.suggestedRestaurants = suggestedRestaurants;
    }
    @Override
    public String toString() {
        return "Attrazione: " + attractionName + ", Luogo: " + stayLocation;
    }
}
