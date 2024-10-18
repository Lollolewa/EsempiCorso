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

    @Override
    public String toString() {
        return "Attrazione: " + attractionName + ", Luogo: " + stayLocation;
    }
}
