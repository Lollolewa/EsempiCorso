package org.generation.italy.travelAgency;
import java.util.Arrays;
import java.util.Scanner;

public class UserInterfaces {
    Scanner sc = new Scanner(System.in);
    private AbstractVoyageRepository repository = new VoyageRepository();
    String admin = "Password123";

    public void begin() {
        boolean condition = false;
        do {
            System.out.println("Cosa vuoi fare?\n"                              +
                            "1)Vedere i viaggi attivi\n"                        +
                            "2)Cercare un viaggio per nome\n"                   +
                            "3)Cercare un viaggio per parola\n"                 +
                            "4)Cercare un viaggio per categoria e durata\n"     +
                            "5)Esci dal menù\n"                                 +
                            "0)Admin"                                           );
            int answer = sc.nextInt();
            sc.nextLine();

            if (answer == 1) {
                System.out.println("Eccoti i viaggi attivi:");
                System.out.println(repository.findActiveVoyages().toString());
                condition = true;
            } else if (answer == 2) {
                System.out.println("Eccoti i viaggi in base al nome:");
                System.out.println("Inserisci il nome");
                String name = sc.nextLine();

                if (repository.findMyDestinationName(name).isEmpty()) {
                    System.out.println("Non abbiamo trovato nessuna offerta disponibile in base ai criteri di ricerca");
                    System.out.println("Vuoi fare una nuova ricerca? Rispondi si o no");
                    String yorn = sc.nextLine();
                    if(yorn.equalsIgnoreCase("no")){
                        condition = true;
                    }
                } else {
                    System.out.println(repository.findMyDestinationName(name).toString());
                    condition = true;
                }

            } else if (answer == 3) {
                System.out.println("Scrivi la parola");
                String word = sc.nextLine();
                if (repository.findActiveVoyagesByWord(word).isEmpty()) {
                    System.out.println("Non abbiamo trovato nessuna offerta disponibile in base ai criteri di ricerca");
                    System.out.println("Vuoi fare una nuova ricerca? Rispondi si o no");
                    String yorn = sc.nextLine();
                    if(yorn.equalsIgnoreCase("no")){
                        condition = true;
                    }
                } else {
                    System.out.println("Eccoti i viaggi in base alla tua parola:");
                    System.out.println(repository.findActiveVoyagesByWord(word).toString());
                    condition = true;
                }


            } else if (answer == 4) {
                System.out.println("Scegli una categoria tra LUXURY, COMFORT, BUDGET, BACKPACKER");
                Category category = Category.valueOf(sc.nextLine().toUpperCase());
                System.out.println("Scegli un numero di destinazioni");
                int duration = sc.nextInt();
                sc.nextLine();

                if (repository.findByCategoryAndDuration(category, duration).isEmpty()) {
                    System.out.println("Non abbiamo trovato nessuna offerta disponibile in base ai criteri di ricerca");
                    System.out.println("Vuoi fare una nuova ricerca? Rispondi si o no");
                    String yOrN = sc.nextLine();
                    if(yOrN.equalsIgnoreCase("no")){
                        condition = true;
                    }
                } else {
                    System.out.println(repository.findByCategoryAndDuration(category, duration));
                    condition = true;
                }
            } else if (answer == 5) {
                System.out.println("Sei uscito dal menù");
                condition = true;
            } else if (answer == 0) {
                System.out.println("Inserisci il codice per identificarti");
                String code = sc.nextLine();
                if(code.equals(admin)) {
                    System.out.println("Ti sei identificato. Cosa vuoi fare?\n" +
                                       "1)Creare una nuova offerta\n"           +
                                       "2)Cancellare un'offerta"              );
                    int adminAnswer = sc.nextInt();
                    sc.nextLine();

                    if (adminAnswer == 1) {
                        System.out.println("e");
                    }
                    else if (adminAnswer == 2) {
                        System.out.println("Quale offerta vuoi cancellare?");
                        System.out.println(repository.findActiveVoyages().toString());
                        System.out.println("Digita l'id dell'offerta che vuoi eliminare");
                        int deleteOffer = sc.nextInt();
                        sc.nextLine();
                        if(repository.findVoyagesById(deleteOffer).contains(deleteOffer)) {
                            System.out.println("Sei sicuro di voler cancellare l'offerta " + deleteOffer + "? Rispondi si o no");
                            String siONo = sc.nextLine();
                            if (siONo.equalsIgnoreCase("si")) {
                                repository.delete(deleteOffer);
                                System.out.println("Offerta cancellata con successo.");
                                condition = true;
                            } else {
                                System.out.println("Ritorno alla schermata principale.");

                            }
                        } else {
                            System.out.println("Id non presente nell'archivio.\n" +
                                                "Ritorno alla schermata principale.");
                            
                        }
                    }
                } else {
                    System.out.println("Codice errato, ritorno alla schermata principale.");
                }

            } else {
                System.out.println("Errore, riprova");
            }
        } while(!condition);
    }


}
