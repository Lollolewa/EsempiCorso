package org.generation.italy.examples.interfaces.travelagency;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
//        UserInterface ui = new UserInterface();
//        ui.begin();
        Destination places1 = new Destination("Parigi", "Famosa per la torre e il mondiale 2006", "Hotel baguette",
                5, List.of("Mangiare lumache", "Visitare notre Dame"), List.of("McDonald", "BurgerKing"));
        Destination places2 = new Destination("Roma", "Famosa per il Colosseo e la carbonara", "Hotel Negrone",
                5, List.of("PickPocket!!!!", "Visitare gli zingari"), List.of("McDonald", "BurgerKing"));
        Voyage povero = new Voyage(List.of(places1), Category.BUDGET, 123456, 500, LocalDate.of(2024, 11, 3),
                LocalDate.of(2024, 11, 8), "Sei povero, guardati il Colosseo e mangiati un kebaba",5);
        Voyage ricco = new Voyage(List.of(places1, places2), Category.LUXURY, 654321, 1000, LocalDate.of(2024, 11, 3),
                LocalDate.of(2024, 11, 13), "Sei ricco, quindi non solo guardi il Colosseo ma anche la torre Eifelle",10);
        VoyageRepository v = new VoyageRepository();
        v.add(povero);
        v.add(ricco);


       //v.findActiveVoyages(); //stampa a schermo i pacchetti di viaggio disponibili e attivi;
        Scanner sc = new Scanner(System.in);
//       Collection<Voyage> viaggi = v.findByDestinationName(sc.nextLine()); //richiamo la funzione per cercare pacchetti tramite nome che gli passo per poi assegnarli ad una collection per stamparli a schermo;
//       for (Voyage t : viaggi) {
//           System.out.println("Pacchetto di viaggio ID: " + t.getId());
//           for (Destination location : t.getDestinations()) {
//                System.out.println(location);
//          }
//           System.out.println();
//       }
//        Collection<Voyage> viaggi = v.findActiveVoyagesByWord(sc.nextLine());
//        for (Voyage t : viaggi) {
//            System.out.println("Pacchetto di viaggio ID: " + t.getId());
//            for (Destination location : t.getDestinations()) {
//                System.out.println(location);
//            }
//            System.out.println();
//
//        }

        Collection<Voyage> viaggi2= v.findByCategoriesAndDuration(sc.nextInt());
        for (Voyage t : viaggi2) {
            System.out.println("Pacchetto di viaggio ID: " + t.getId());
            for (Destination location : t.getDestinations()) {
                System.out.println(location);
            }
            System.out.println();
        }


    }
}

