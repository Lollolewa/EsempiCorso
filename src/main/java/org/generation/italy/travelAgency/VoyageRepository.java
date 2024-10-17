package org.generation.italy.travelAgency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class VoyageRepository implements AbstractVoyageRepository{
    private List<Voyage> voyages = new ArrayList<>();

    @Override
    public void create(Voyage v) {

    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Collection<Voyage> findActiveVoyages() {
        return List.of();
    }

    @Override
    public Collection<Voyage> findMyDestinationName(String destination) {
        return List.of();
    }

    @Override
    public Collection<Voyage> findActiveVoyagesByWord(String word) {
        return List.of();
    }

    @Override
    public Collection<Voyage> findByCategoryAndDuration(Category c, int duration) {
        return List.of();
    }
}