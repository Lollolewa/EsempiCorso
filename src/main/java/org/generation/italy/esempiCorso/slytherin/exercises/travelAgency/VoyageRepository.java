package org.generation.italy.esempiCorso.slytherin.exercises.travelAgency;

import java.time.LocalDate;
import java.util.*;

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
        List<Voyage> activeVoyages = new ArrayList<>();
        for (Voyage v : voyages) {
            if (v.getStartDate().isAfter(today) || v.getStartDate().isEqual(today)) {
                activeVoyages.add(v);
            }
        }
        Collections.sort(activeVoyages);
        return activeVoyages;
    }

    @Override
    public Collection<Voyage> findVoyagesByDestination(String destination) {
        List<Voyage> voyagesByDestination = new ArrayList<>();
        for (Voyage v : voyages) {
            for (Destination d : v.getDestinations()) {
                if (d.getCity().equalsIgnoreCase(destination)) {
                    voyagesByDestination.add(v);
                    break;
                }
            }
        }
        Comparator<Voyage> cv = new VoyageComparatorByDestination();
//        Collections.sort(voyagesByDestination, cv);
//        il secondo parametro del metodo sort sarà comunque un oggette di una classe che implementa l'interfaccia Comparator<Voyage>
//        Collections.sort(voyagesByDestination, (v1, v2) -> v1.getDestinations().size() - v2.getDestinations().size()); // lambda expression
//        Collections.sort(voyagesByDestination, Comparator.comparingInt(v -> v.getDestinations().size()));
//        Collections.sort(voyagesByDestination, Comparator.comparingInt(v -> v.getDestinationsSize()));
        voyagesByDestination.sort(Comparator.comparingInt(Voyage::getDestinationsSize)); // method reference
        voyagesByDestination.sort(VoyageRepository::compareStatic);
        return voyagesByDestination;
    }

    @Override
    public Collection<Voyage> findActiveVoyagesByWord(String word) {
        List<Voyage> voyagesByWord = new ArrayList<>();
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
        Collections.sort(voyagesByWord, new VoyageComparatorByDate());
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

    public int compare(Voyage v1, Voyage v2) {
        return v1.getDestinationsSize() - v2.getDestinationsSize();
    }

    public static int compareStatic(Voyage v1, Voyage v2){
        return v1.getDestinationsSize() - v2.getDestinationsSize();
    }
}
