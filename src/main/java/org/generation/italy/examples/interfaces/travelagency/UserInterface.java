package org.generation.italy.examples.interfaces.travelagency;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private AbstractVoyageRepository repository = new VoyageRepository();
    private Scanner sc = new Scanner(System.in);
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

        while (true){
            System.out.println("Selezionare un numero da 1 a 7 per: \n1) Guarda tutti i bundle di viaggi al momento \n2) Cerca un viaggio in base alla destinazione desiderata " +
                        "\n3) Cerca viaggi attivi tramite attività o località di interesse \n4) Trova il tuo viaggio in base alla data \n5) Cancella un pacchetto tramite ID " +
                        "\n6)Trova il tuo viaggio in base al numero di destinazioni \n7)Creare un pacchetto personalizzato \n0)Termina e chiudi" );
            scelta = sc.nextInt();
            sc.nextLine();
        switch(scelta) {
            case 0:
                System.exit(0);
            case 1:
                printVoyages(repository.findActiveBundles());
                break;
            case 2:
                System.out.println("Inserisci una localita': ");
                var viaggi = repository.findByDestinationName(sc.nextLine());
                printVoyages(viaggi);
                break;
            case 3:
                System.out.println("Inserisci una parola chiave per trovare un viaggio: ");
                var viaggi2 = repository.findActiveVoyagesByWord(sc.nextLine());
                printVoyages(viaggi2);
                break;
            case 4:
                int n= getInt("Inserisci la durata del viaggio");
                Category target = getCategory();
                var viaggi3 = repository.findByCategoriesAndDuration(target,n);
                printVoyages(viaggi3);
                break;
            case 5:
                repository.delete(getInt("Insrisci iD del viaggio che voi cancellare: "));
                break;
            case 6:
                System.out.println(("inserisci il numero di destinazioni minimo che vuoi nel tuo pacchetto"));
                int m = sc.nextInt();
                var viaggi4 = repository.findVoyageByNumberOfDestination(m);
                printVoyages(viaggi4);
                break;
            case 7:
                System.out.println("Ecco le liste delle destinazioni disponibili; poi creare il tuo pacchetto di viaggio personale aggiungendo una destinazione alla volta fino ad un massimo di 3 destinazioni! Stai attento alle date!");
                List<Destination> destinazioniSelezionate = new ArrayList<>();
                for (int i = 0; i < possibleDestination.size(); i++) {
                    System.out.println((i + 1) + ". " + possibleDestination.get(i).toString());
                }

                while (destinazioniSelezionate.size() < 3) {

                    int numero = getInt("Inserisci il numero della destinazione da aggiungere (o 0 per terminare):");

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
                Category categoria = getCategory();

                int id = getInt("Inserisci l'ID del viaggio personalizzato per memorizzare il tuo pacchetto:");


                System.out.println("Prezzo calcolato!");
                int prezzo = 0;
                for (Destination d : destinazioniSelezionate) {
                    prezzo += d.getPrezzo();
                }

                System.out.println("Inserisci la data di partenza (YYYY-MM-DD):");
                LocalDate dataPartenza = LocalDate.parse(sc.nextLine());

                System.out.println("Inserisci la data di ritorno (YYYY-MM-DD):");
                LocalDate dataRitorno = LocalDate.parse(sc.nextLine());

                System.out.println("Inserisci una descrizione del viaggio personalizzata affinché possa racchiudere al meglio la tua esperienza di viaggio ideale:");
                String descrizione = sc.nextLine();


                Voyage nuovoVoyage = new Voyage(destinazioniSelezionate, categoria, id, prezzo, dataPartenza, dataRitorno, descrizione, destinazioniSelezionate.size());


                repository.add(nuovoVoyage);

                System.out.println("Pacchetto di viaggio creato con successo! Ti aspettiamo in agenzia per discutere e concretizzare un itinerario di viaggio! Grazie per aver scelto il RAZZO!");
                break;


            default:
                System.out.println("Scelta non valida, inserire un numero da 1 a 7");
                break;
            }
        }
    }
    public void printVoyages(Collection<Voyage> viaggi){
        for (Voyage t : viaggi) {
            System.out.println("Pacchetto di viaggio ID: " + t.getId());
            for (Destination location : t.getDestinations()) {
                System.out.println(location);
            }
            System.out.println();
        }
    }
    private Category getCategory(){
        System.out.print("Inserisci la categoria del viaggio (BUDGET, LUXURY, BACKPACKER,BACKPACKER):");
        String line = sc.nextLine().toUpperCase();
        return Category.valueOf(line);
    }
    private int getInt(String prompt){
        System.out.println(prompt + ":");
        int n = sc.nextInt();
        sc.nextLine();
        return n;
    }
}
