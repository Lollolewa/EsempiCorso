package org.generation.italy.travelAgency;

import java.util.ArrayList;
import java.util.List;

public class Destination {
    private String name, description, hotelName;
    private int daysSpent;
    private List<String> advisedActivities = new ArrayList<>();
    private List<String> advisedResturants = new ArrayList<>();

    public Destination(String name, String description, String hotelName, int daysSpent, List<String> advisedActivities, List<String> advisedResturants) {
        this.name = name;
        this.description = description;
        this.hotelName = hotelName;
        this.daysSpent = daysSpent;
        this.advisedActivities = advisedActivities;
        this.advisedResturants = advisedResturants;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getDaysSpent() {
        return daysSpent;
    }

    public void setDaysSpent(int daysSpent) {
        this.daysSpent = daysSpent;
    }

    public List<String> getAdvisedActivities() {
        return advisedActivities;
    }

    public void setAdvisedActivities(List<String> advisedActivities) {
        this.advisedActivities = advisedActivities;
    }

    public List<String> getAdvisedResturants() {
        return advisedResturants;
    }

    public void setAdvisedResturants(List<String> advisedResturants) {
        this.advisedResturants = advisedResturants;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s\nDescrizione: %s\nHotel: %s\nNum.Giorni: %d\nAttività consigliate:\n%s\n" +
                "Ristoranti consigliati:\n%s\n\n", name, description, hotelName, daysSpent, advisedActivities,
                advisedResturants);
    }
}
