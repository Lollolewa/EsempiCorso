package org.generation.italy.travelAgency;
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

                        System.out.println(repository.showAllID());

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

    public void creatingOffer() {
        System.out.println("Scegli il nome della destinazione");
        String name = sc.nextLine();
        System.out.println("Inserisci una descrizione riassuntiva del viaggio");
        String description = sc.nextLine();
        System.out.println("Inserisci il nome dell'hotel");
        String hotelName = sc.nextLine();
        System.out.println("Inserisci il numero di giorni di soggiorno");
        int daysSpent = sc.nextInt();
        sc.nextLine();
        System.out.println("Inserisci una serie di attività consigliate");
        String lista;
        Destination d = new Destination(name, description,
                hotelName, daysSpent, List.of("Visita al Colosseo", "Cena a Trastevere"),
                List.of("Neo Patacca", "Il Ragno D'oro"));
    }

}