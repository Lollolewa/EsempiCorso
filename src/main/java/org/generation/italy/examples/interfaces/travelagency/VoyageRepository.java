package org.generation.italy.examples.interfaces.travelagency;

import java.time.LocalDate;
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
    public Collection<Voyage> findActiveBundles() {
            LocalDate yesterday = LocalDate.now().minusDays(1);
            Collection<Voyage> activeBundles = new ArrayList<>();
            for(Voyage v: voyages){
                if(v.getStartingDate().isAfter(yesterday)){
                    activeBundles.add(v);
                }
            }
            return activeBundles;
        }

    @Override
    public Collection<Voyage> findByDestinationName(String destinationName) {
        Collection<Voyage> result = new ArrayList<>();
    outer:  for (Voyage v : voyages) {
                for (Destination location : v.getDestinations()) {
                    if (location.getAttractionName().equals(destinationName)) {
                        result.add(v);
                        continue outer;
                    }
                }
             }
        return result;
    }
    @Override
    public Collection<Voyage> findActiveVoyagesByWord(String word) {
        Collection<Voyage> matchWord = new ArrayList<>();
        for(Voyage v : voyages){
           if(v.getDescription().contains(word)|| v.anyDestinationContains(word)){
               matchWord.add(v);
           }
        }
        return matchWord;
    }

    @Override
    public Collection<Voyage> findByCategoriesAndDuration(Category c,int duration) {
//        System.out.println("Scegli una categoria di viaggio!Inserisci:\n1)Luxury\n2)Comfort\n3)Budget\n4)Backpacker");
//        Category c = null;
//        Scanner sc= new Scanner(System.in);
//        int s=0;
//        do {
//            s=sc.nextInt();
//            sc.nextLine();
//            switch (s){
//                case 1,6: //è possibile dare più valori per ogni caso
            //      case 5:
//                    c = Category.LUXURY;
//                    break;
//
//                case 2:
//                    c = Category.COMFORT;
//                    break;
//
//                case 3:
//                    c = Category.BUDGET;
//                    break;
//
//                case 4:
//                    c = Category.BACKPACKER;
//                    break;
//
//                default:
//                    System.out.println("Scelta non valida");
//                }
//            Category x = switch (s){ //switch expression
//                case 1 -> Category.LUXURY;
//                case 2 -> Category.COMFORT;
//                case 3 -> Category.BUDGET;
//                case 4 -> Category.BACKPACKER;
//                default -> null;
////            }
//        }while(s>=0);
        Collection<Voyage> lv = new ArrayList<>();
        for(Voyage v : voyages){
            if(v.getCategory().equals(c) && v.getDuration() == duration){
                lv.add(v);
            }
        }
        return lv;
    }
    @Override
    public Collection<Voyage> findVoyageByNumberOfDestination(int n){
        Collection<Voyage> matchNumber = new ArrayList<>();
        for(Voyage v : voyages){
            if(v.getLength()>=n){
                matchNumber.add(v);
            }
        }
        return matchNumber;

    }
}









