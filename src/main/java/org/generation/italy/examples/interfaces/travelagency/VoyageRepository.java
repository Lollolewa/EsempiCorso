package org.generation.italy.examples.interfaces.travelagency;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class VoyageRepository implements AbstractVoyageRepository{

    private List<Voyage> voyages = new ArrayList<>();


    @Override
    public void create(Voyage v) {
        voyages.add(v);

    }

    @Override
    public boolean delete(int id) {
        for(Voyage voyage : voyages){
            if (voyage.getId() == id){
                voyages.remove(voyage);
                return true;
            }

        }
        return false;
    }

    @Override
    public Collection<Voyage> findActiveVoyages() {
        return voyages;
    }

    @Override
    public Collection<Voyage> findByDestinationName(String destinationName){
        List<Voyage> k = new ArrayList<>();
        for(Voyage voyage : voyages){
            if (voyage.getDestinations().equals(destinationName)){
                k.add(voyage);
            }
        }
        return k;

    }
    @Override
    public Collection<Voyage> findActiveVoyagesByWord(String word){
        List<Voyage> k = new ArrayList<>();
        for(Voyage voyage : voyages){
            if (voyage.getName().contains(word)){
                k.add(voyage);
            }
        }
        return k;

    }

    @Override
    public Collection<Voyage> findByCategoriesAndDuration(Category c, int duration) {
        List<Voyage> k = new ArrayList<>();
        for(Voyage voyage : voyages){
        Duration gay =  Duration.between(voyage.getsDate(), voyage.geteDate());
        long pippo = gay.getSeconds() % 60;
        long pippoSuperSayian = (((pippo/60) /60) / 24);
            if ((voyage.getCategory().equals(c)) && pippoSuperSayian == duration) {
                k.add(voyage);
            }
        }
        return k;
    }
}


