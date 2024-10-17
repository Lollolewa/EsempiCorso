package org.generation.italy.esempiCorso.interfaces.travelAgency;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private AbstractVoyageRepository repository = new VoyagerRepository();
    Scanner sc = new Scanner(System.in);

    public void printVoyages(){
        repository.toString();
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
                System.out.println("Inserisci la categoria che vuoi ricercare, scegli tra luxury, comfort, economy, business, backpacker");
                String categoryAnswer = sc.nextLine();
                System.out.println("Inserisci la durata che vuoi ricercare");
                int durationAnswer = sc.nextInt();
                sc.nextLine();
                boolean boo = false;
                for (Category c : Category.values()) {
                    if(categoryAnswer.equalsIgnoreCase(c.name())){
                        System.out.println(repository.findByCategoryAndDuration(c, durationAnswer));
                        boo = true;
                    }
                }
                if (!boo) {
                    System.out.println("Categoria non appropiata");
                }
            }
        }
    }

    public void createNewVoyage(){
        System.out.println("non c'ho voglia");

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
            } else if (answer == 4) {
                removeVoyage();
            } else if (answer == 5) {

            } else {
                System.out.println("risposta non valida");
            }
        } while (answer != 5);
    }
}
