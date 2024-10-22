package org.generation.italy.examples.interfaces.travelagency;

import java.util.Collection;


public  interface AbstractVoyageRepository {

    void create(Voyage v);

    boolean delete(int id);

    Collection<Voyage> findActiveVoyages();

    Collection<Voyage> findByDestinationName(String destinationName);

    Collection<Voyage> findActiveVoyagesByWord(String word);

    Collection<Voyage> findByCategoriesAndDuration(Category c, int duration);

}
