package org.generation.italy.examples.interfaces.travelagency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

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
    public void findActiveBundles() { //stampa a schermo i pacchetti di viaggio disponibili;
            for (Voyage v : voyages) {
                System.out.println("Il prezzo e'"+ v.getPrice());
                System.out.println("Pacchetto di viaggio ID: " + v.getId());
                System.out.println("Categoria di viaggio: " + v.getCategories());
                System.out.println("Descrizione: " + v.getDescription());
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
        List<Voyage> matchWord = new ArrayList<>();
        for(Voyage v : voyages){
           if(v.getDescription().contains(word)|| v.getDestinations().contains(word)){
               matchWord.add(v);
           }
        }
        return matchWord;
    }

    @Override
    public Collection<Voyage> findByCategoriesAndDuration(int duration) {
        System.out.println("Scegli una categoria di viaggio!Inserisci:\n1)Luxury\n2)Comfort\n3)Budget\n4)Backpacker");
        Category c = null;
        Scanner sc= new Scanner(System.in);
        int s=0;
        do {
            s=sc.nextInt();
            if(s==1){
                c = Category.LUXURY;
                break;
            }
            else if(s==2){
                c = Category.COMFORT;
                break;
            }
            else if(s==3){
                c = Category.BUDGET;
                break;
            }
            else if(s==4){
                c = Category.BACKPACKER;
                break;
            }
            else {
                System.out.println("Scelta non valida");
            }
        }while(s>=0);
        List<Voyage> lv = new ArrayList<>();
        for(Voyage v : voyages){
            if(v.getCategories().equals(c) && v.getDuration() == duration){
                lv.add(v);
            }
        }
        return lv;
    }
}









