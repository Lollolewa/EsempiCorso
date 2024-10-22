package org.generation.italy.esempiCorso.slytherin.exercises.travelAgency;

import java.util.ArrayList;
import java.util.List;

public class Destination {
    private String city, description, hotel;
    private int numberOfDays;
    private List<String> activities;
    private List<String> restaurants;

    public Destination(String city, String description, String hotel, int numberOfDays, List<String> activities, List<String> restaurants) {
        this.city = city;
        this.description = description;
        this.hotel = hotel;
        this.numberOfDays = numberOfDays;
        this.activities = activities;
        this.restaurants = restaurants;
    }

    public String getCity() {
        return city;
    }

    public String getDescription() {
        return description;
    }

    public String getHotel() {
        return hotel;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public List<String> getActivities() {
        return activities;
    }

    public List<String> getRestaurants() {
        return restaurants;
    }
    public List<String> getLowerCaseRestaurants() { // Fatto un altro poiche potrebbe servirmi leggerlo come dico io.
        List<String> lowerCaseRestaurants = new ArrayList<>();
        for (String restaurant : restaurants) {
            lowerCaseRestaurants.add(restaurant.toLowerCase());
        }
        return lowerCaseRestaurants;
    }
    public List<String> getLowerCaseActivities() {
        List<String> lowerCaseActivities = new ArrayList<>();
        for (String activity : activities) {
            lowerCaseActivities.add(activity.toLowerCase());
        }
        return lowerCaseActivities;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public void setActivities(List<String> activities) {
        this.activities = activities;
    }

    public void setRestaurants(List<String> restaurants) {
        this.restaurants = restaurants;
    }

    public String toString(String city, String description, String hotel, int numberOfDays, List<String> attractions, List<String> restaurants){
        return "Città: " + city + "\nDescription: " + description + "\nHotel: " + hotel + "\nNumero giorni: " + numberOfDays + "\nAttivita: " + activities + "\nRistoranti: " + restaurants;
    }

    @Override
    public String toString() {
        return "Destination{" +
                "city='" + city + '\'' +
                ", description='" + description + '\'' +
                ", hotel='" + hotel + '\'' +
                ", numberOfDays=" + numberOfDays +
                ", activities=" + activities +
                ", restaurants=" + restaurants +
                '}';
    }
}
