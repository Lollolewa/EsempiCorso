package org.generation.italy.esempiCorso.interfaces.travelAgency;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private AbstractVoyageRepository repository = new VoyagerRepository();
    Scanner sc = new Scanner(System.in);

    public void printVoyages(List<Voyage> voyagesList) {
        System.out.println("Vuoi cercare i viaggi attivi?");
        String answer = sc.nextLine();
        if (answer.equalsIgnoreCase("si")){
            System.out.println("Viaggi attivi:\n===============================\n");
            System.out.println(repository.findActiveVoyages().toString());
        } else {
            System.out.println("Vuoi cercare i viaggi per nome, parola chiave o per categoria e durata? Rispondi con 'nome', 'parola chiave' o 'categoria e durata'");
            if (answer.equalsIgnoreCase("nome")) {
                System.out.println("Inserisci il nome che vuoi ricercare");
                String nameAnswer = sc.nextLine();
                System.out.println(repository.findByDestinationName(nameAnswer).toString());
            } else if (answer.equalsIgnoreCase("parola chiave")) {
                System.out.println("Inserisci la parola chiave che vuoi ricercare");
                String keyWordAnswer = sc.nextLine();
                System.out.println(repository.findActiveVoyagesByKeyWord(keyWordAnswer).toString());
            } else if (answer.equalsIgnoreCase("durata") || answer.equalsIgnoreCase("categoria") || answer.equalsIgnoreCase("categoria e durata")) {
                System.out.println("Inserisci la categoria che vuoi ricercare, scegli tra luxury, comfort, economy, business, backpacker");
                String categoryAnswer = sc.nextLine();
                System.out.println("Inserisci la durata che vuoi ricercare");
                String durationAnswer = sc.nextLine();

            }
        }

    }

    public void createNewVoyage(){
        System.out.println("");

    }

    public void begin(){

    }
}
