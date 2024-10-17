package org.generation.italy.examples.interfaces.travelagency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class VoyageRepository implements AbstractVoyageRepository{

    private List<Voyage> voyages = new ArrayList<>();

    public VoyageRepository(List<Voyage> voyages) {
        this.voyages = voyages;
    }


    @Override
    public void create(Voyage v) {
        v.getDestinations();


    }

    @Override
    public boolean delete(int id) {
        for(Voyage voyage: voyages){
            if(id == voyage.getId()){
                voyages.remove(voyage);
                return true;

            }else{
            return false;
        }

    }

    @Override
    public Collection<Voyage> findActiveVoyages() {
            return List.of(voyages);
    }

    @Override
    public Collection<Voyage> findByDestinationName(String destinationName) {
        return List.of();
    }

    @Override
    public Collection<Voyage> findActiveVoyagesByWord(String word) {
        return List.of();
    }

    @Override
    public Collection<Voyage> findByCategoriesAndDuration(Category c, int duration) {
        return List.of();
    }
}

    public List<Voyage> getVoyages() {
        return voyages;
    }

    public void setVoyages(List<Voyage> voyages) {
        this.voyages = voyages;
    }
