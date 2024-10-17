package org.generation.italy.esempiCorso.interfaces.travelAgency;

import java.util.Collection;

public interface AbstractVoyageRepository {

    void create(Voyage v);
    boolean delete(int id);
    Collection<Voyage> findActiveVoyages();
    Collection<Voyage> findByDestinationName(String destinationName);
    Collection<Voyage> findActiveVoyagesByKeyWord(String word);
    Collection<Voyage> findByCategoryAndDuration(Category c, int duration);
}
