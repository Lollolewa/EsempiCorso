package esercizioInterfacciaGestioneBiblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    List<Risorsa> resources;

    //costruttore per inizializzare la lista
    public Biblioteca(){
        resources = new ArrayList<>();
    }
    void addResource(Risorsa r){
        resources.add(r);
    };
    void showAvailableResources(){
        System.out.println("Risorse disponibili : \n");
        for (Risorsa resource : resources){
            if (resource.isAvailable()){
                System.out.println(resource.getTitle());
            }
        }
    }
    public void lendResource(String title) {
        for (Risorsa resource : resources) {
            if (resource.getTitle().equals(title)) {
                if (resource.isAvailable()) { // Controlla se la risorsa è disponibile
                    resource.lend(); // Presta la risorsa
                    System.out.println("La risorsa " + title + " è stata prestata.");
                } else {
                    System.out.println("La risorsa " + title + " non è disponibile, I'm sorry.");
                }
                return; // Esce dal metodo dopo aver trovato ciò che cercavi
            }
        }
        System.out.println("Risorsa " + title + " non trovata nell'archivio.");
    }
}
