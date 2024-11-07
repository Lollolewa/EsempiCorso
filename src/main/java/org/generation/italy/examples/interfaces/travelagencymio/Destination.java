package org.generation.italy.examples.interfaces.travelagencymio;

import java.util.ArrayList;
import java.util.List;

public class Destination {
    private String attractionName, description, stayLocation;
    private int nDays,nprezzo;
    private List<String> suggestedActivities = new ArrayList<>();
    private List<String> suggestedRestaurants = new ArrayList<>();

    public Destination(String attractionName, String description, String stayLocation, int nDays, List<String> suggestedActivities, List<String> suggestedRestaurants, int nprezzo) {
        this.attractionName = attractionName;
        this.description = description;
        this.stayLocation = stayLocation;
        this.nDays = nDays;
        this.suggestedActivities = suggestedActivities;
        this.suggestedRestaurants = suggestedRestaurants;
        this.nprezzo= nprezzo;
    }

    public String getDescription() {
        return description;
    }

    public String getAttractionName() {
        return attractionName;
    }

    public int getPrezzo() {
        return nprezzo;
    }
    @Override
    public String toString() {
        return "Attrazione: " + attractionName + ", Luogo: " + stayLocation;
    }
}
