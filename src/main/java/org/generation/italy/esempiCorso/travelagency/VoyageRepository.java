package org.generation.italy.esempiCorso.travelagency;

import java.time.LocalDate;
import java.util.*;

public class VoyageRepository implements AbstractVoyageRepository{
    private static int id =1;
    private List<Voyage> voyages = new ArrayList<>();

    public VoyageRepository() {
        //creare viaggi e aggiungerli a voyages
    }

    public List<Voyage> getVoyages() {
        return voyages;
    }

    public void setVoyages(List<Voyage> voyages) {
        this.voyages = voyages;
    }

    @Override
    public void create(Voyage v) {
        v.setID(id++);
        voyages.add(v);
    }

    @Override
    public boolean delete(int id) {
        for(Voyage v : voyages){
            if(v.getID()==id){
                voyages.remove(id);
                return true;
            }
        }
        return false;
    }

    @Override
    public Collection<Voyage> findActiveVoyages() {
        LocalDate oggi = LocalDate.now();
        List<Voyage> activeVoyages = new ArrayList<>();
        for (Voyage v : voyages) {
            if (v.getDataInizio().isAfter(oggi) || v.getDataInizio().isEqual(oggi)) {
                activeVoyages.add(v);
            }
        }
        Collections.sort(activeVoyages);
        return activeVoyages;
    }

    @Override
    public Collection<Voyage> findByDestinationName(String destinationName) {
        List<Voyage> voyagesByDestination = new ArrayList<>();
        for(Voyage v : voyages) {
            if (voyages.contains(v.getDestinations())) {
                voyagesByDestination.add(v);
            }
        }
        Comparator<Voyage> cv = new VoyageComparatorByDestination();
        //Collections.sort(voyageByDestination,cv):
        //il secondo parametro del metodo sort sarà comunque un oggetto di una classe che i,plementa l'interfaccia Comparator<Voyage>
        //Collections.sort(voyagesByDestination,(v1,v2)-> v1.getDestinations().size()-v2..getDestinations().size()); LAMBDA EXPRESSION
        //Collections.sort(voyagesByDestination, Comparator.comparingInt(v-> v.getDestinations().size()));
        //Collections.sort(voyagesByDestination, Comparator.comparingInt(v-> v.getDestinationsSize()));
        voyagesByDestination.sort(Comparator.comparingInt(Voyage::getDestionationsSize));
        voyagesByDestination.sort(VoyageRepository::compareStatic);
        return voyagesByDestination;
    }

    @Override
    public Collection<Voyage> findActiveVoyagesByWord(String word) {
        List<Voyage> voyagesByWord = new ArrayList<>();
        for(Voyage v : voyages){
            if(v.getDestinations().contains(word)){
                voyagesByWord.add(v);
            }
        }
        Collections.sort(voyagesByWord, new VoyageComparatorByDate());
        return voyagesByWord;
    }

    @Override
    public Collection<Voyage> findByCategoriesAndDuration(Category c, int numDestinations) {
        Collection<Voyage> voyageByCatAndDur = new ArrayList<>();
        for(Voyage v : voyages){
            if(v.getCategory().equals(c) && v.getDestinations().size()>= numDestinations){
                voyageByCatAndDur.add(v);
            }
        }
        return voyageByCatAndDur;
    }
    @Override
    public int size(){
        return voyages.size();
    }
    @Override
    public String toString() {
        return "VoyageRepository{" +
                "voyages=" + voyages +
                '}';
    }

    public static int compareStatic(Voyage v1, Voyage v2) {
        return v1.getDestionationsSize() - v2.getDestionationsSize();
    }


}

