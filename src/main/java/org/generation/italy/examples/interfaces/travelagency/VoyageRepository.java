package org.generation.italy.examples.interfaces.travelagency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class VoyageRepository implements AbstractVoyageRepository {

    private List<Voyage> voyages = new ArrayList<>();


    @Override
    public void add(Voyage v) { //metodo per aggiungere dei Voyage in VoyageRepository(VR);
        voyages.add(v);
    }

    @Override
    public boolean delete(int id) { //metodo per eliminare dei Voyage da VR tramite id del pacchetto viaggio;
        for (Voyage voyage : voyages) {
            if (id == voyage.getId()) {
                voyages.remove(voyage);
                return true;
            }
        }
        return false;
    }



    @Override
    public void findActiveVoyages() { //stampa a schermo i pacchetti di viaggio disponibili;
            for (Voyage v : voyages) {
                System.out.println("Pacchetto di viaggio ID: " + v.getId());
                System.out.println("Categoria di viaggio: " + v.getCategories());
                for (Destination location : v.getDestinations()) {
                    System.out.println(location);
                }
                System.out.println(); // Separatore tra pacchetti perchè sennò li stampava tutti attaccati e faceva pena;
            }
        }




    @Override
    public Collection<Voyage> findByDestinationName(String destinationName) {
        List<Voyage> matchDestination = new ArrayList<>();
        for (Voyage v : voyages) {
            for (Destination location : v.getDestinations()) {
                if (location.getAttractionName().equals(destinationName)) {
                    matchDestination.add(v);
                }
            }
        }
        return matchDestination;
    }
    @Override
    public Collection<Voyage> findActiveVoyagesByWord(String word) {
        return List.of();
    }

    @Override
    public Collection<Voyage> findByCategoriesAndDuration(Category c, int duration) {
        return List.of();
    }


}





