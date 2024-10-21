package org.generation.italy.esempiCorso.griffindor.eserciziCollection.travelAgency;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class VoyageRepository implements AbstractVoyageRepository {

    private List<Voyage> voyages = new ArrayList<>();

    public VoyageRepository(List<Voyage> voyages) {
        this.voyages = voyages;
    }

    public List<Voyage> getVoyages() {
        return voyages;
    }

    @Override
    public void create(Voyage voyage) {
        voyages.add(voyage);
    }

    @Override
    public boolean delete(int id) {
        for (int i = 0; i < voyages.size(); i++) {
            if (voyages.get(i).getId() == id) {
                voyages.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public Collection<Voyage> findActiveVoyages() {
        LocalDate today = LocalDate.now();
        Collection<Voyage> activeVoyages = new ArrayList<>();
        for (Voyage v : voyages) {
            if (v.getStartDate().isAfter(today) || v.getStartDate().isEqual(today)) {
                activeVoyages.add(v);
            }
        }
        return activeVoyages;
    }

    @Override
    public Collection<Voyage> findVoyagesByDestination(String destination) {
        Collection<Voyage> voyagesByDestination = new ArrayList<>();
        for (Voyage v : voyages) {
            for (Destination d : v.getDestinations()) {
                if (d.getCity().equalsIgnoreCase(destination)) {
                    voyagesByDestination.add(v);
                    break;
                }
            }
        }
        return voyagesByDestination;
    }

    @Override
    public Collection<Voyage> findActiveVoyagesByWord(String word) {
        Collection<Voyage> voyagesByWord = new ArrayList<>();
        for (Voyage v : voyages) {
            boolean containsWord = false;
            for (Destination d : v.getDestinations()) {
                if (d.getDescription().toLowerCase().contains(word.toLowerCase())|| d.getHotel().toLowerCase().contains(word.toLowerCase()) || d.getCity().toLowerCase().contains(word)
                || d.getLowerCaseRestaurants().contains(word.toLowerCase()) || d.getLowerCaseActivities().contains(word.toLowerCase())){
                    containsWord = true;
                    break;
                }
            }
            if (containsWord) {
                voyagesByWord.add(v);
            }
        }
        return voyagesByWord;
    }

    @Override
    public Collection<Voyage> findCategoriesAndDestinations(Category c, int destination) {
        Collection<Voyage> categoriesAndDuration = new ArrayList<>();
        for (Voyage v : voyages) {
            if (v.getCategory().equals(c) && v.getDestinations().size() >= destination) {
                categoriesAndDuration.add(v);
            }
        }
        return categoriesAndDuration;
    }

    @Override
    public String toString() {
        return "VoyageRepository{" +
                "voyages=" + voyages +
                '}';
    }
}
