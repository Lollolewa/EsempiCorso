package org.generation.italy.esempiCorso.interfaces.travelAgency;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private AbstractVoyageRepository repository = new VoyagerRepository();
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void printVoyages(){
        System.out.println(repository.toString());
    }

    public void findVoyages() {
        System.out.println("Vuoi cercare i viaggi attivi?");
        String answer = sc.nextLine();
        if (answer.equalsIgnoreCase("si")){
            System.out.println("Viaggi attivi:\n===============================\n");
            System.out.println(repository.findActiveVoyages().toString());
        } else if (answer.equalsIgnoreCase("no")){
            System.out.println("Vuoi cercare i viaggi per nome, parola chiave o per categoria e durata? Rispondi con 'nome', 'parola chiave' o 'categoria e durata'");
            String answer1 = sc.nextLine();
            if (answer1.equalsIgnoreCase("nome")) {
                System.out.println("Inserisci il nome che vuoi ricercare");
                String nameAnswer = sc.nextLine();
                System.out.println(repository.findByDestinationName(nameAnswer).toString());
            } else if (answer1.equalsIgnoreCase("parola chiave")) {
                System.out.println("Inserisci la parola chiave che vuoi ricercare");
                String keyWordAnswer = sc.nextLine();
                System.out.println(repository.findActiveVoyagesByKeyWord(keyWordAnswer).toString());
            } else if (answer1.equalsIgnoreCase("durata") || answer1.equalsIgnoreCase("categoria") || answer1.equalsIgnoreCase("categoria e durata")) {
                System.out.println("Inserisci il numero di tappe che vuoi ricercare\n(La ricerca darà come risultato tutti i viaggi con un numero di destinazioni maggiore o uguale a quello che inserisci");
                int durationAnswer = sc.nextInt();
                sc.nextLine();
                boolean boo = false;
                while (!boo) {
                    System.out.println("Inserisci la categoria che vuoi ricercare, scegli tra luxury, comfort, economy, business, backpacker");
                    String categoryAnswer = sc.nextLine();
                    for (Category c : Category.values()) {
                        if (categoryAnswer.equalsIgnoreCase(c.name())) {
                            System.out.println(repository.findByCategoryAndDuration(c, durationAnswer).toString());
                            boo = true;
                        }
                    }
                }
                if (!boo) {
                    System.out.println("Nessuno viaggio trovato, ricontrolla i dati inseriti!");
                }
            }
        }
    }

    public Destination createNewDestination(){
        System.out.println("Dove vuoi andare?");
        String name = sc.nextLine();
        System.out.println("Descrivi la destinazione");
        String description = sc.nextLine();
        System.out.println("Inserisci la sistemazione");
        String accomadation = sc.nextLine();
        System.out.println("Inserisci il numero dei giorni da trascorrere nella destinazione " + name);
        int daysNum = sc.nextInt();
        sc.nextLine();
        String answer = "";
        List<String> suggestedActivities = new ArrayList<>();
        do {
            System.out.println("vuoi inserire una nuova attività consigliata?");
            answer = sc.nextLine();
            if (answer.equalsIgnoreCase("si")) {
                System.out.println("Inserisci l'attivita che vuoi aggiungere");
                suggestedActivities.add(sc.nextLine());
            } else if (answer.equalsIgnoreCase("no")) {

            } else {
                System.out.println("risposta non valida");
            }
        } while (!answer.equalsIgnoreCase("no"));

        String answer1 = "";
        List<String> suggestedResturants = new ArrayList<>();
        do {
            System.out.println("vuoi inserire un nuovo ristorante consigliato?");
            answer1 = sc.nextLine();
            if (answer1.equalsIgnoreCase("si")) {
                System.out.println("Inserisci l'attivita che vuoi aggiungere");
                suggestedResturants.add(sc.nextLine());
            } else if (answer1.equalsIgnoreCase("no")) {

            } else {
                System.out.println("risposta non valida");
            }
        } while (!answer1.equalsIgnoreCase("no"));
        Destination d = new Destination(name, description, accomadation, daysNum, suggestedActivities, suggestedResturants);
        return d;
    }
    public void createNewVoyage(){
        List<Destination> destinationList = new ArrayList<>();
        System.out.println("Quante destinazioni vuoi aggiungere?");
        int index = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i< index; i++){
            System.out.println("Destinazione n: " + (i + 1));
            destinationList.add(createNewDestination());
        }
        System.out.println("Inserici il prezzo");
        double price = sc.nextDouble();
        sc.nextLine();
        LocalDate startDate = null;
        boolean startDateValid = false;
        System.out.println("Inserisci la data di inizio viaggio (formato --> dd/MM/yyyy)");
        try {
            startDate = LocalDate.parse(sc.nextLine(), formatter);
            startDateValid = true;
        } catch (DateTimeParseException e) {
            System.out.println("Formato errato :<");
        }
        LocalDate endDate = null;
        boolean endDateValid = false;
        System.out.println("Inserisci la data di fine viaggio (formato --> dd/MM/yyyy)");
        try {
            endDate = LocalDate.parse(sc.nextLine(), formatter);
            endDateValid = true;
        } catch (DateTimeParseException e) {
            System.out.println("Formato errato :<");
        }
        Category category = Category.LUXURY;
        boolean boo = false;
        while (!boo) {
            System.out.println("Inserisci la categoria del viaggio (scegli tra luxury, comfort, economy, business, backpacker)");
            String categoryAnswer = sc.nextLine();
            for (Category c : Category.values()) {
                if (categoryAnswer.equalsIgnoreCase(c.name())) {
                    category = c;
                    boo = true;
                }
            }
        }
        System.out.println("risposta non valida");
        repository.create(new Voyage(destinationList, idCreator(price), price, startDate, endDate, category));
    }
    public void removeVoyage(){
        System.out.println("Inserisci l'id del viaggio che vuoi rimuovere");
        int temp = sc.nextInt();
        sc.nextLine();
        if(repository.delete(temp)){}
        else {
            System.out.println("l'id non corrisponde a nessun viaggio");
        }
    }

    public void begin(){
        int answer;
        do {
            System.out.println("Cosa vuoi fare?\n================================\n1. Mostrare tutti i viaggi \n" +
                    "2. Cercare viaggi\n3. Aggiungere un viaggio\n4. Rimuovere un viaggio\n" +
                    "5. Esci\nPer favore rispondi con un numero da 1 a 5 :>");
            answer = sc.nextInt();
            sc.nextLine();
            if (answer == 1) {
                printVoyages();
            } else if (answer == 2) {
                findVoyages();
            } else if(answer == 3) {
                createNewVoyage();
            } else if (answer == 4) {
                removeVoyage();
            } else if (answer == 5) {

            } else {
                System.out.println("risposta non valida");
            }
        } while (answer != 5);
    }
    public static int idCreator(double d) {
        double temp = Math.random() * d;
        return (int) Math.round(temp);
    }
}
