package org.generation.italy.esempiCorso.travelagency;

import java.util.Collection;


public interface AbstractVoyageRepository {

    int size();

    void create(Voyage v);

    boolean delete(int id);

    Collection<Voyage> findActiveVoyages();

    Collection<Voyage> findByDestinationName(String destinationName);

    Collection<Voyage> findActiveVoyagesByWord(String word);

    Collection<Voyage> findByCategoriesAndDuration(Category c, int duration);


}
