package org.generation.italy.esempiCorso.interfaces.travelAgency;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class VoyagerRepository implements AbstractVoyageRepository{

    private List<Voyage> voyagesList = new ArrayList<>();

    @Override
    public void create(Voyage v) {
        voyagesList.add(v);
    }
    @Override
    public boolean delete(int id) {
        for (Voyage v : voyagesList) {
            if (id == v.getId()) {
                voyagesList.remove(v);
                return true;
            }
        }
        return false;
    }
    @Override
    public Collection<Voyage> findActiveVoyages() {
        LocalDate todaysDate = LocalDate.now();
        Collection<Voyage> tempCollection = new ArrayList<>();
        for (Voyage v : voyagesList) {
            if (todaysDate.isEqual(v.getStartDate()) || todaysDate.isAfter(v.getStartDate()) &&
                  todaysDate.isEqual(v.getEndDate()) || todaysDate.isBefore(v.getEndDate())){
                tempCollection.add(v);
            }
        }
        return tempCollection;
    }
    @Override
    public Collection<Voyage> findByDestinationName(String destinationName) {
        Collection<Voyage> tempCollection = new ArrayList<>();
        for (Voyage v : voyagesList) {
            for (Destination d : v.getDestinationList()){
                if (d.getName().equalsIgnoreCase(destinationName)) {
                    tempCollection.add(v);
                }
            }
        }
        return tempCollection;
    }
    @Override
    public Collection<Voyage> findActiveVoyagesByKeyWord(String word) {
        Collection<Voyage> tempCollection = new ArrayList<>();
        for (Voyage v : voyagesList) {
            for (Destination d : v.getDestinationList()){
                if (d.getName().contains(word)) {
                    tempCollection.add(v);
                }
            }
        }
        return tempCollection;
    }
    @Override
    public Collection<Voyage> findByCategoryAndDuration(Category c, int duration) {
        Collection<Voyage> tempCollection = new ArrayList<>();
        for (Voyage v : voyagesList) {
            if (v.getCategories() == c && v.getDestinationList().size() >= duration) {
                tempCollection.add(v);
            }
        }
        return tempCollection;
    }
    @Override
    public String toString(){
        String temp = "";
        for (Voyage v : voyagesList) {
            temp += v.toString();
        }
        return temp;
    }
}
