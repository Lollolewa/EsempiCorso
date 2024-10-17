package org.generation.italy.esempiCorso.interfaces.travelAgency;

import java.util.ArrayList;
import java.util.List;

public class Destination {
    private String name, description, accomodation;
    private int daysNum;
    private List<String> suggestedActivities = new ArrayList<>();
    private List<String> suggestedResturants = new ArrayList<>();

    public Destination(String name, String description, String accomodation, int daysNum, List<String> suggestedActivities, List<String> suggestedResturants) {
        this.name = name;
        this.description = description;
        this.accomodation = accomodation;
        this.daysNum = daysNum;
        this.suggestedActivities = suggestedActivities;
        this.suggestedResturants = suggestedResturants;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getAccomodation() {
        return accomodation;
    }
    public int getDaysNum() {
        return daysNum;
    }
    public List<String> getSuggestedActivities() {
        return suggestedActivities;
    }
    public List<String> getSuggestedResturants() {
        return suggestedResturants;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setAccomodation(String accomodation) {
        this.accomodation = accomodation;
    }
    public void setDaysNum(int daysNum) {
        this.daysNum = daysNum;
    }
    public void setSuggestedActivities(List<String> suggestedActivities) {
        this.suggestedActivities = suggestedActivities;
    }
    public void setSuggestedResturants(List<String> suggestedResturants) {
        this.suggestedResturants = suggestedResturants;
    }
}
