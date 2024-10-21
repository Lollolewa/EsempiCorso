package org.generation.italy.examples.interfaces.travelagency;

import java.util.ArrayList;
import java.util.List;

public class Destination {
    private String city, description, housing;
    int days;
    List<String> advisedActivity = new ArrayList<>();
    List<String> advisedRestaurant = new ArrayList<>();



    public Destination(String city, String description, String housing, int days, List<String> advisedActivity, List<String> advisedRestourant) {
        this.city = city;
        this.description = description;
        this.housing = housing;
        this.days = days;
        //this.advisedActivity = advisedActivity;
        this.advisedRestaurant = advisedRestourant;
    }






    public String getCity() {
        return city;
    }

    public String getDescription() {
        return description;
    }

    public String getHousing() {
        return housing;
    }

    public int getDays() {
        return days;
    }

    public List<String> getAdvisedActivity() {
        return advisedActivity;
    }

    public List<String> getAdvisedRestourant() {
        return advisedRestaurant;
    }

    @Override
    public String toString() {
        return "Destination{" +
                "city='" + city + '\'' +
                ", description='" + description + '\'' +
                ", housing='" + housing + '\'' +
                ", days=" + days +
                ", advisedActivity=" + advisedActivity +
                ", advisedRestaurant=" + advisedRestaurant +
                '}';
    }
}

