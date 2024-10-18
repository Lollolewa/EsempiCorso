package org.generation.italy.examples.interfaces.travelagency;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private AbstractVoyageRepository repository = new VoyageRepository();

    public void begin(){
        Destination parigi = new Destination("Parigi", "Famosa per la torre e il mondiale 2006", "Hotel baguette",
                5, List.of("Mangiare lumache", "Visitare notre Dame"), List.of("McDonald", "BurgerKing"));
        Destination roma = new Destination("Roma", "Famosa per il Colosseo e la carbonara", "Hotel Negrone",
                5, List.of("PickPocket!!!!", "Visitare gli zingari"), List.of("McDonald", "BurgerKing"));
        Voyage povero = new Voyage(List.of(parigi), Category.BUDGET, 123456, 500, LocalDate.of(2024, 11, 3),
                LocalDate.of(2024, 11, 8), "Sei povero, guardati la torre eiffel e mangiati un kebaba",5);
        Voyage ricco = new Voyage(List.of(parigi, roma), Category.LUXURY, 654321, 1000, LocalDate.of(2024, 11, 3),
                LocalDate.of(2024, 11, 13), "Sei ricco, quindi non solo guardi il Colosseo ma anche la torre Eifelle",10);
        Destination newYork = new Destination(
                "New York",
                "La città che non dorme mai, famosa per la Statua della Libertà",
                "Empire Hotel",
                5,
                List.of("Visita alla Statua della Libertà", "Giro a Central Park", "Shopping sulla 5th Avenue"),
                List.of("Le Bernardin", "Eleven Madison Park", "Shake Shack", "McDonald")
        );

        Destination tokyo = new Destination(
                "Tokyo",
                "Capitale del Giappone, famosa per la tecnologia avanzata e la cultura tradizionale",
                "Shibuya Hotel",
                5,
                List.of("Visita al Tempio Senso-ji", "Tour dei quartieri di Akihabara e Shibuya", "Cibo di strada a Harajuku"),
                List.of("Sukiyabashi Jiro", "Den", "Ichiran", "McDonald")
        );

        Voyage budgetTrip = new Voyage(
                List.of(parigi),
                Category.BUDGET,
                123456,
                500,
                LocalDate.of(2024, 11, 3),
                LocalDate.of(2024, 11, 8),
                "Un viaggio economico a Parigi, per visitare la città e assaporare la cultura locale senza spendere troppo",
                5
        );

        Voyage luxuryTrip = new Voyage(
                List.of(parigi, roma),
                Category.LUXURY,
                654321,
                3000,
                LocalDate.of(2024, 11, 3),
                LocalDate.of(2024, 11, 15),
                "Un viaggio di lusso tra Parigi e Roma, con soggiorni in hotel a 5 stelle e ristoranti gourmet",
                10
        );

        Voyage newYorkExperience = new Voyage(
                List.of(newYork),
                Category.LUXURY,
                987654,
                4000,
                LocalDate.of(2024, 12, 1),
                LocalDate.of(2024, 12, 7),
                "Un'esperienza di lusso a New York, tra grattacieli, musei e ristoranti di fama mondiale",
                8
        );

        Voyage japanAdventure = new Voyage(
                List.of(tokyo),
                Category.BACKPACKER,
                543210,
                3500,
                LocalDate.of(2025, 2, 10),
                LocalDate.of(2025, 2, 20),
                "Un'avventura in Giappone alla scoperta della cultura tradizionale e moderna di Tokyo",
                9
        );
        repository.add(povero);
        repository.add(ricco);
        repository.add(budgetTrip);
        repository.add(luxuryTrip);
        repository.add(newYorkExperience);
        repository.add(japanAdventure);

        int scelta = 1;
        while (scelta!=0){
            Scanner sc = new Scanner(System.in);
            System.out.println("Selezionare un numero da 1 a 5: \n1) Trova i bundle di viaggi. \n2) Cerca un viaggio. \n3) Cerca viaggi attivi. \n4) Trova il tuo viaggio in base alla data \n5) Cancella un pachetto tramite ID");
            scelta = sc.nextInt();
            sc.nextLine();
        switch(scelta) {
            case 1:
                repository.findActiveBundles();
                break;
            case 2:
                System.out.println("Inserisci una localita': ");

                Collection<Voyage> viaggi = repository.findByDestinationName(sc.nextLine());
                for (Voyage t : viaggi) {
                    System.out.println("Pacchetto di viaggio ID: " + t.getId());
                    for (Destination location : t.getDestinations()) {
                        System.out.println(location);
                    }
                    System.out.println();
                }
                break;
            case 3:
                System.out.println("Inserisci una parola chiave per trovare un viaggio: ");
                Collection<Voyage> viaggi2 = repository.findActiveVoyagesByWord(sc.nextLine());
                for (Voyage t : viaggi2) {
                    System.out.println("Pacchetto di viaggio ID: " + t.getId());
                    for (Destination location : t.getDestinations()) {
                        System.out.println(location);
                    }
                    System.out.println();
                }
                break;
            case 4:
                System.out.println("Inserisci la durata del viaggio");
                Collection<Voyage> viaggi3 = repository.findByCategoriesAndDuration(sc.nextInt());
                for (Voyage t : viaggi3) {
                    System.out.println("Pacchetto di viaggio ID: " + t.getId());
                    for (Destination location : t.getDestinations()) {
                        System.out.println(location);
                    }
                    System.out.println();
                }
                        repository.findByCategoriesAndDuration(sc.nextInt());
                break;
            case 5:
                repository.delete(sc.nextInt());
                break;
            default:
                System.out.println("Scelta non valida, inserire un numero da 1 a 5");
                break;
        }
        }
    }
}
