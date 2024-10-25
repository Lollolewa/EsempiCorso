package org.generation.italy.travelAgency;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInterfaces {
    static Scanner sc = new Scanner(System.in);
    private static AbstractVoyageRepository repository = new VoyageRepository();
    String admin = "Password123";
    boolean condition = false;

    public void begin() {

        do {
            System.out.println("Cosa vuoi fare?\n" +
                    "1)Vedere i viaggi attivi\n" +
                    "2)Cercare un viaggio per nome\n" +
                    "3)Cercare un viaggio per parola\n" +
                    "4)Cercare un viaggio per categoria e durata\n" +
                    "5)Esci dal menù\n" +
                    "0)Admin");
            int answer = sc.nextInt();
            sc.nextLine();

            if (answer == 1) {
                showActiveOffers();
            } else if (answer == 2) {
                showDestinationsByName();
            } else if (answer == 3) {
                showVoyagesByWord();
            } else if (answer == 4) {
                showVgsByCategoryAndDestinations();
            } else if (answer == 5) {
                System.out.println("Sei uscito dal menù");
                condition = true;
            } else if (answer == 0) {
                System.out.println("Inserisci il codice per identificarti");
                String code = sc.nextLine();
                if (code.equals(admin)) {
                    System.out.println("Ti sei identificato. Cosa vuoi fare?\n" +
                                        "1)Creare una nuova offerta\n" +
                                        "2)Cancellare un'offerta");
                    int adminAnswer = sc.nextInt();
                    sc.nextLine();

                    if (adminAnswer == 1) {
                        creatingOffer();


                    } else if (adminAnswer == 2) {
                        deletingOffer();
                    }
                } else {
                    System.out.println("Codice errato, ritorno alla schermata principale.");
                }

            } else {
                System.out.println("Errore, riprova");
            }
        } while (!condition) ;
    }

    public void showActiveOffers () {
        System.out.println("Eccoti i viaggi attivi:");
        System.out.println(repository.findActiveVoyages().toString());
        condition = true;
    }

    public void showDestinationsByName () {
        System.out.println("Eccoti i viaggi in base al nome:");
        System.out.println("Inserisci il nome");
        String name = sc.nextLine();

        if (repository.findMyDestinationName(name).isEmpty()) {
            System.out.println("Non abbiamo trovato nessuna offerta disponibile in base ai criteri di ricerca");
            System.out.println("Vuoi fare una nuova ricerca? Rispondi si o no");
            String yorn = sc.nextLine();
            if (yorn.equalsIgnoreCase("no")) {
                condition = true;
            }
        } else {
            System.out.println(repository.findMyDestinationName(name).toString());
            condition = true;
        }
    }




    public void showVoyagesByWord() {
        System.out.println("Scrivi la parola");
        String word = sc.nextLine();
        if (repository.findActiveVoyagesByWord(word).isEmpty()) {
            System.out.println("Non abbiamo trovato nessuna offerta disponibile in base ai criteri di ricerca");
            System.out.println("Vuoi fare una nuova ricerca? Rispondi si o no");
            String yorn = sc.nextLine();
            if (yorn.equalsIgnoreCase("no")) {
                condition = true;
            }
        } else {
            System.out.println("Eccoti i viaggi in base alla tua parola:");
            System.out.println(repository.findActiveVoyagesByWord(word).toString());
            condition = true;
        }
    }

    public void showVgsByCategoryAndDestinations() {
        System.out.println("Scegli una categoria tra LUXURY, COMFORT, BUDGET, BACKPACKER");
        Category category = Category.valueOf(sc.nextLine().toUpperCase());
        System.out.println("Scegli un numero di destinazioni");
        int duration = sc.nextInt();
        sc.nextLine();

        if (repository.findByCategoryAndDuration(category, duration).isEmpty()) {
            System.out.println("Non abbiamo trovato nessuna offerta disponibile in base ai criteri di ricerca");
            System.out.println("Vuoi fare una nuova ricerca? Rispondi si o no");
            String yOrN = sc.nextLine();
            if (yOrN.equalsIgnoreCase("no")) {
                condition = true;
            }
        } else {
            System.out.println(repository.findByCategoryAndDuration(category, duration));
            condition = true;
        }
    }

    public void deletingOffer() {
        System.out.println("Quale offerta vuoi cancellare?");
        System.out.println(repository.findActiveVoyages().toString());
        System.out.println("Digita l'id dell'offerta che vuoi eliminare");
        int deleteOffer = sc.nextInt();
        sc.nextLine();
        if (repository.findVoyagesById(deleteOffer).contains(deleteOffer)) {
            System.out.println("Sei sicuro di voler cancellare l'offerta " + deleteOffer + "? Rispondi si o no");
            String siONo = sc.nextLine();
            if (siONo.equalsIgnoreCase("si")) {
                repository.delete(deleteOffer);
                System.out.println("Offerta cancellata con successo.");

            } else {
                System.out.println("Ritorno alla schermata principale.");

            }
        } else {
            System.out.println("Id non presente nell'archivio.\n" +
                    "Ritorno alla schermata principale.");

        }
    }


    public Destination creatingDestination() {
        boolean canContinue = false;

        System.out.println("Scegli il nome della destinazione");
        String name = sc.nextLine();
        System.out.println("Inserisci una descrizione riassuntiva del viaggio");
        String description = sc.nextLine();
        System.out.println("Inserisci il nome dell'hotel");
        String hotelName = sc.nextLine();
        System.out.println("Inserisci il numero di giorni di soggiorno");
        int daysSpent = sc.nextInt();
        sc.nextLine();
        System.out.println("Vuoi aggiungere delle attività da consigliare? Rispondi si o no");
        String answ = sc.nextLine();
        List<String> suggestedActivities = new ArrayList<>();
        if (answ.equalsIgnoreCase("si")) {
            takeSuggestedActivities(suggestedActivities);
        }
        System.out.println("Vuoi aggiungere dei ristoranti da consigliare? Rispondi si o no");
        String answ1 = sc.nextLine();
        List<String> suggestedRestaurants = new ArrayList<>();
        if (answ.equalsIgnoreCase("si")) {
            takeSuggestedRestaurants(suggestedRestaurants);
        }
        Destination d = new Destination(name, description, hotelName, daysSpent, suggestedActivities,
                suggestedRestaurants);
        System.out.println("Il tuo viaggio è pronto, ecco un riepilogo\n\n" + d.toString());
        return d;
    }
    public void creatingOffer() {
        boolean condition = false;
        List<Destination> destinations = new ArrayList<>();
        do {
            System.out.println("Crea il viaggio da inserire nel pacchetto");
            destinations.add(creatingDestination());
            System.out.println("Vuoi creare un altro viaggio? Rispondi si o no");
            String answer = sc.nextLine();
            if(answer.equalsIgnoreCase("no")) {
                condition = true;
            }
        } while (!condition);
        System.out.println("Prepariamo il pacchetto di viaggi");
        System.out.println("Inserisci l'id del pacchetto\nTieni presente gli id già presenti, eccoteli!");
        System.out.println(repository.showAllID());
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Inserisci il prezzo del pacchetto");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.println("Inserisci la data di partenza (Formato yyyy-mm-dd");
        LocalDate startDate =

        Voyage v = new Voyage(id, price, startDate, endDate, category, destinations);



    }

    public void takeSuggestedActivities(List<String> suggestedActivities) {
        boolean condition2 = false;
        while (!condition2) {
            System.out.println("Inserisci un'attività consigliata");
            String activity = "";
            activity = sc.nextLine();
            suggestedActivities.add(activity);
            System.out.println("Attività aggiunta.\nVuoi aggiungere un'altra attività? Rispondi si o no");
            boolean condition3 = false;
            do {
                String yorn = sc.nextLine();
                if (yorn.equalsIgnoreCase("no")) {
                    condition2 = true;
                } else if (yorn.equalsIgnoreCase("si")) {
                    condition3 = true;
                } else {
                    System.out.println("Risposta non valida.\nVuoi aggiungere un'altra attività? Rispondi si o no\" ");

                }
            } while(!condition3);
        }
    }

    public void takeSuggestedRestaurants(List<String> suggestedRestaurants) {
        boolean condition2 = false;
        while (!condition2) {
            System.out.println("Inserisci un ristorante consigliato");
            String activity = "";
            activity = sc.nextLine();
            suggestedRestaurants.add(activity);
            System.out.println("Attività aggiunta.\nVuoi aggiungere un altro ristorante? Rispondi si o no");
            boolean condition3 = false;
            do {
                String yorn = sc.nextLine();
                if (yorn.equalsIgnoreCase("no")) {
                    condition2 = true;
                } else if (yorn.equalsIgnoreCase("si")) {
                    condition3 = true;
                } else {
                    System.out.println("Risposta non valida.\nVuoi aggiungere un altro ristorante? Rispondi si o no\" ");

                }
            } while(!condition3);
        }
    }
}