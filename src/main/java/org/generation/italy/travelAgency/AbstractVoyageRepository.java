package org.generation.italy.travelAgency;

import java.util.Collection;
import java.util.List;

public interface AbstractVoyageRepository {

    void create(Voyage v);
    boolean delete(int id);
    Collection<Voyage> findActiveVoyages();
    Collection<Voyage> findMyDestinationName(String destination);
    Collection<Voyage> findActiveVoyagesByWord(String word);
    Collection<Voyage> findByCategoryAndDuration(Category c, int duration);


    List<Integer> findVoyagesById(int id);
}
