package org.generation.italy.esempiCorso.slytherin.exercises.travelAgency;

import java.util.Comparator;

public class VoyageComparatorByDestination implements Comparator<Voyage> {

    @Override
    public int compare(Voyage o1, Voyage o2) {
        return o1.getDestinations().size() - o2.getDestinations().size();
    }
}
