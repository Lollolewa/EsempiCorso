package org.generation.italy.esempiCorso.interfaces.travelAgency;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class VoyagerRepository implements AbstractVoyageRepository{

    private List<Voyage> voyagesList;

    public VoyagerRepository() {
        Destination d1 = new Destination("Roma", "sporca ma se magna bene", "per tera",
                5, List.of("Corri", "Magna", "Caga"), List.of("ErGrande", "ErPiccolo", "ErMedio"));
        Destination d2 = new Destination("Venezia", "mezza pulita", "per tera",
                5, List.of("Corri", "Magna", "Caga"), List.of("ErGrande", "ErPiccolo", "ErMedio"));
        Destination d3 = new Destination("Prato", "sporca", "tenda",
                2, List.of("Caga", "Magna", "Caga"), List.of("ErGrande", "ErPiccolo", "ErMedio"));
        Destination d4 = new Destination("Firenze", "bella", "GranBudapestHotel",
                2, List.of("Lampredotto", "basta"), List.of("ErGrande", "ErPiccolo", "ErMedio"));
        Destination d5 = new Destination("Trapani", "boh", "dove vuoi",
                8, List.of("Caga", "Caga", "Caga"), List.of("ErGrande", "ErPiccolo", "ErMedio"));
        Voyage v1 = new Voyage(List.of(d1, d2, d3), 1234, 1800, LocalDate.of(2010, 8, 12), LocalDate.of(2012, 9, 9), Category.COMFORT);
        Voyage v2 = new Voyage(List.of(d4, d5, d2, d1), 1235, 4000, LocalDate.of(2009, 8, 12), LocalDate.of(2033, 9, 9), Category.BUSINESS);
        this.voyagesList = new ArrayList<>();
        voyagesList.add(v1);
        voyagesList.add(v2);
    }

    @Override
    public void create(Voyage v) {
        voyagesList.add(v);
    }
//    @Override
//    public boolean delete(int id) {
//        for (Voyage v : voyagesList) {
//            if (id == v.getId()) {
//                voyagesList.remove(v);
//                return true;
//            }
//        }
//        return false;
//    }
    @Override
    public boolean delete(int id) {
        Iterator<Voyage> iterator = voyagesList.iterator();
        while (iterator.hasNext()) {
            Voyage viaggio = iterator.next();
            if (viaggio.getId() == id) {
                iterator.remove();
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
