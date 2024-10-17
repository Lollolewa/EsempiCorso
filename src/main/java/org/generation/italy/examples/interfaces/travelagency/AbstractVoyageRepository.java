package org.generation.italy.examples.interfaces.travelagency;

import java.util.Collection;


public interface AbstractVoyageRepository {

    void add(Voyage v);

    boolean delete(int id);

    void findActiveVoyages();

    Collection<Voyage> findByDestinationName(String destinationName);

    Collection<Voyage> findActiveVoyagesByWord(String word);

    Collection<Voyage> findByCategoriesAndDuration(Category c, int duration);

}
