package org.generation.italy.esempiCorso.travelagencymio;

import java.util.Collection;


public interface AbstractVoyageRepository {
    void add(Voyage v);
    boolean delete(int id);
    Collection<Voyage> findActiveBundles();
    Collection<Voyage> findByDestinationName(String destinationName);
    Collection<Voyage> findActiveVoyagesByWord(String word);
    Collection<Voyage> findByCategoriesAndDuration(Category c,int duration);
    Collection<Voyage> findVoyageByNumberOfDestination(int n);
}
