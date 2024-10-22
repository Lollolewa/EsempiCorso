package org.generation.italy.esempiCorso.griffindor.eserciziCollection.travelAgency;

import java.util.Comparator;

public class VoyageComparatorByDate implements Comparator<Voyage> {

    @Override
    public int compare(Voyage o1, Voyage o2) {
        return o1.getStartDate().compareTo(o2.getStartDate());
    }
}
