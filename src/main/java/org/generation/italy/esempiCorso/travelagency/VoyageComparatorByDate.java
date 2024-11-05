package org.generation.italy.esempiCorso.travelagency;

import java.util.Collection;
import java.util.Collections;

import java.util.Comparator;

public class VoyageComparatorByDate implements Comparator<Voyage> {

    @Override
    public int compare(Voyage o1, Voyage o2) {
        return o1.getDataInizio().compareTo(o2.getDataInizio());
    }
}