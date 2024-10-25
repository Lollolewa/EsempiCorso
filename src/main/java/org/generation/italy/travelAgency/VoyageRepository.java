package org.generation.italy.travelAgency;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class VoyageRepository implements AbstractVoyageRepository{
    private List<Voyage> voyages;

    public VoyageRepository() {
        this.voyages = new ArrayList<>();
        Destination d1 = new Destination("Roma", "visita alla città migliore del mondo",
                "Hotel Colosseo", 5, List.of("Visita al Colosseo", "Cena a Trastevere"),
                List.of("Neo Patacca", "Il Ragno D'oro"));
        Destination d2 = new Destination("Venezia", "spero che ti piaccia l'umido",
                "Hotel Marea", 7, List.of("Visita Murano", "Giro in gondola"),
                List.of("Alta Marea", "Bassa Marea"));
        Voyage v1 = new Voyage(1, 300, LocalDate.of(2025, 10, 20),
                LocalDate.of(2025,11,01), Category.COMFORT, List.of(d1,d2));


        Destination d3 = new Destination("New York", "viaggio nella città delle opportunità",
                "Apple Hotel", 8,List.of("Visita Times Square", "Visita Central Park"),
                List.of("Apple1", "Apple2"));
        Destination d4 = new Destination("Las Vegas", "preparati a perdere i soldi",
                "Caesars Palace", 7, List.of("Roulette", "BlackJack"),
                List.of("Scommessona", "HaiPerso"));
        Voyage v2 = new Voyage(2, 899.99, LocalDate.of(2025, 03, 01),
                LocalDate.of(2025,03,16), Category.LUXURY, List.of(d3,d4));

        this.voyages.add(v1);
        this.voyages.add(v2);

    }

    @Override
    public void create(Voyage v) {
        this.voyages.add(v);
    }

    @Override
    public boolean delete(int id) {
//        for(Voyage voyage : voyages) {
//            if(voyage.getId() == id) {
//                voyages.remove(voyage);
//                return true;
//            }
//        }
        //Iterator<Voyage> it -> un iteratore di "viaggi", cicla su elementi di classe "tipo";
        //Collection voyages -> prende l'iteratore. iteratore = un oggetto che sa scorrere tutta la collection
        //it.hasNext() mi dice se l'iteratore ha un elemento successivo da darmi
        for(Iterator<Voyage> it = voyages.iterator(); it.hasNext();) {
            Voyage voyage = it.next();
            if(voyage.getId() == id) {
                it.remove(); //è l'iteratore stesso che rimuove l'oggetto e non un'altra funzione
                return true;
            }
        }
        return false;
    }


    @Override
    public Collection<Voyage> findActiveVoyages() {
        Collection<Voyage> activeVoyages = voyages.stream().filter(v -> v.getStartDate().isAfter(LocalDate.now())).toList();
        return activeVoyages;

//        Collection<Voyage> activeVoyages = new ArrayList<>();
//        for(Voyage voyage : voyages) {
//            if(voyage.getStartDate().isAfter(LocalDate.now()) || voyage.getStartDate().isEqual(LocalDate.now())) {
//                activeVoyages.add(voyage);
//            }
//        }
//        return activeVoyages;
    }
    //ok

    @Override
    public  Collection<Voyage> findMyDestinationName(String destination) {
        Collection<Voyage> destinationNames = new ArrayList<>();
        for(Voyage voyage : voyages) {
            for(Destination d : voyage.getDestination()) {
                if(d.getName().equalsIgnoreCase(destination)) {
                    destinationNames.add(voyage);
                    break;
                }
            }
        }
        return destinationNames;
    }
    //ok

    @Override
    public Collection<Voyage> findActiveVoyagesByWord(String word) {
        Collection<Voyage> activeVoyagesW = new ArrayList<>();
        for (Voyage voyage : voyages) {
            for (Destination d : voyage.getDestination())
                if      (d.getName().toLowerCase().contains(word.toLowerCase())         ||
                        d.getDescription().toLowerCase().contains(word.toLowerCase())  ||
                        d.getHotelName().toLowerCase().contains(word.toLowerCase())    ||
                        d.getAdvisedActivities().contains(word)                        ||
                        d.getAdvisedResturants().contains(word)                         ) {
                    activeVoyagesW.add(voyage);
                }
        }
        return activeVoyagesW;
    }
    //ok

    @Override
    public Collection<Voyage> findByCategoryAndDuration(Category c, int destinations) {
        Collection<Voyage> categoryAndDuration = new ArrayList<>();
        for(Voyage voyage : voyages) {
            if(voyage.getCategory().equals(c) && voyage.destinations() >= destinations) {
                categoryAndDuration.add(voyage);
            }
        }
        return categoryAndDuration;
    }
    //ok

    @Override
    public List<Integer> findVoyagesById(int id) {
        List<Integer> voyagesIds = new ArrayList<>();
        for(Voyage voyage : voyages) {
            if(voyage.getId() == id) {
                voyagesIds.add(id);
            }
        }
        return voyagesIds;
    }
    //ok

    @Override
    public List<Integer> showAllID() {
        List<Integer> idList = new ArrayList<>();
        for(Voyage voyage : voyages) {
            idList.add(voyage.getId());
        }
        return idList;
    }
}

