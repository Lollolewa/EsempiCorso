package org.generation.italy.examples.interfaces.travelagency;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private AbstractVoyageRepository repository = new VoyageRepository();

    public void begin(){
        System.out.println("Ben venuto all'agenzia di viaggio Rocketclaw! Dove potrai trovare solo viaggi spaziali!");
        Destination parigi = new Destination("Parigi", "Famosa per la torre e il mondiale 2006", "Hotel baguette",
                5, List.of("Mangiare lumache", "Visitare notre Dame"), List.of("McDonald", "BurgerKing"),340);
        Destination roma = new Destination("Roma", "Famosa per il Colosseo e la carbonara", "Hotel Negrone",
                5, List.of("PickPocket!!!!", "Visitare gli zingari"), List.of("McDonald", "BurgerKing"),250);
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
                List.of("Le Bernardin", "Eleven Madison Park", "Shake Shack", "McDonald"),300
        );

        Destination tokyo = new Destination(
                "Tokyo",
                "Capitale del Giappone, famosa per la tecnologia avanzata e la cultura tradizionale",
                "Shibuya Hotel",
                5,
                List.of("Visita al Tempio Senso-ji", "Tour dei quartieri di Akihabara e Shibuya", "Cibo di strada a Harajuku"),
                List.of("Sukiyabashi Jiro", "Den", "Ichiran", "McDonald"),230
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
        List<Destination> possibleDestination= new ArrayList<>(List.of(parigi,roma,newYork,tokyo));
        int scelta = 1;
        while (scelta!=0){
            Scanner sc = new Scanner(System.in);
            System.out.println("Selezionare un numero da 1 a 7 per: \n1) Guarda tutti i bundle di viaggi al momento. \n2) Cerca un viaggio in base alla destinazione desiderata. " +
                        "\n3) Cerca viaggi attivi tramite attività o località di interesse \n4) Trova il tuo viaggio in base alla data \n5) Cancella un pacchetto tramite ID " +
                        "\n6)Trova il tuo viaggio in base al numero di destinazioni \n7)Creare un pacchetto personalizzato");
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
                break;
            case 5:
                repository.delete(sc.nextInt());
                break;
            case 6:
                System.out.println(("inserisci il numero di destinazioni minimo che vuoi nel tuo pacchetto"));
                int n = sc.nextInt();
                Collection<Voyage> viaggi4 = repository.findVoyageByNumberOfDestination(n);
                for (Voyage t : viaggi4) {
                    System.out.println("Pacchetto di viaggio ID: " + t.getId());
                    for (Destination location : t.getDestinations()) {
                        System.out.println(location);
                    }
                    System.out.println();
                }
                break;
            case 7:
                System.out.println("Ecco le liste delle destinazioni disponibili; poi creare il tuo pacchetto di viaggio personale aggiungendo una destinazione alla volta fino ad un massimo di 3 destinazioni! Stai attento alle date!");
                List<Destination> destinazioniSelezionate = new ArrayList<>();
                for (int i = 0; i < possibleDestination.size(); i++) {
                    System.out.println((i + 1) + ". " + possibleDestination.get(i).toString());
                }

                while (destinazioniSelezionate.size() < 3) {
                    System.out.println("Inserisci il numero della destinazione da aggiungere (o 0 per terminare):");
                    int numero = sc.nextInt();

                    if (numero == 0) {
                        break;
                    }

                    if (numero > 0 && numero <= possibleDestination.size()) {
                        destinazioniSelezionate.add(possibleDestination.get(numero - 1));
                        System.out.println("Destinazione aggiunta: " + possibleDestination.get(numero - 1).getAttractionName());
                    } else {
                        System.out.println("Scelta non valida.");
                    }

                    System.out.println("Destinazioni selezionate finora:");
                    for (Destination d : destinazioniSelezionate) {
                        System.out.println(d.toString());
                    }
                }


                System.out.println("Inserisci la categoria del viaggio (BUDGET, LUXURY, BACKPACKER,BACKPACKER):");
                String categoriaInput = sc.next().toUpperCase();
                Category categoria = Category.valueOf(categoriaInput);

                System.out.println("Inserisci l'ID del viaggio:");
                int id = sc.nextInt();

                System.out.println("Prezzo calcolato!");
                int prezzo = 0;
                for (Destination d : destinazioniSelezionate) {
                    prezzo += d.getPrezzo();
                }

                System.out.println("Inserisci la data di partenza (YYYY-MM-DD):");
                LocalDate dataPartenza = LocalDate.parse(sc.next());

                System.out.println("Inserisci la data di ritorno (YYYY-MM-DD):");
                LocalDate dataRitorno = LocalDate.parse(sc.next());

                System.out.println("Inserisci una descrizione del viaggio personalizzata:");
                sc.nextLine();
                String descrizione = sc.nextLine();


                Voyage nuovoVoyage = new Voyage(destinazioniSelezionate, categoria, id, prezzo, dataPartenza, dataRitorno, descrizione, destinazioniSelezionate.size());


                repository.add(nuovoVoyage);

                System.out.println("Pacchetto di viaggio creato con successo! Ti aspettiamo in agenzia per discutere e concretizzare un itinerario di viaggio!");
                break;


            default:
                System.out.println("Scelta non valida, inserire un numero da 1 a 7");
                break;
            }
        }
    }
}
