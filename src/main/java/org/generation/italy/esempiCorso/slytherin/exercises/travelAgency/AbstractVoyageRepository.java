package org.generation.italy.esempiCorso.slytherin.exercises.travelAgency;

import java.util.Collection;

public interface AbstractVoyageRepository {
    void create(Voyage voyage);
    boolean delete(int id);
    Collection<Voyage> findActiveVoyages();
    Collection<Voyage> findVoyagesByDestination(String destination);
    Collection<Voyage> findActiveVoyagesByWord(String word);
    Collection<Voyage> findCategoriesAndDestinations(Category c, int destination);
}
