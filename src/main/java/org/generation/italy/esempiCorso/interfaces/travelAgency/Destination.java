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

    @Override
    public String toString(){
        String temp = String.format("Nome: %s%nDescrizione: %s%nSistemazione: %s%nNumero di giorni: %d%nAttività consigliate: %n", name, description, accomodation, daysNum);
        for (String s : suggestedActivities){
            temp += "-" + s + ",\n";
        }
        temp += "Ristoranti consigliati: \n";
        for (String s : suggestedResturants){
            temp += "-" + s + ",\n";
        }
        return temp + "\n";
    }
}
