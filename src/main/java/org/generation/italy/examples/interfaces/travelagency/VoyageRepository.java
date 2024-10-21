package org.generation.italy.examples.interfaces.travelagency;

import java.time.LocalDate;
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
        return false;
    }

    @Override
    public Collection<Voyage> findActiveVoyages() {
        LocalDate today = LocalDate.now();
        List<Voyage> result = new ArrayList<>();
        for (Voyage v : voyages) {
            if (!v.getArrival().isBefore(today)) {
                result.add(v);
            }
        }
        return result;
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
