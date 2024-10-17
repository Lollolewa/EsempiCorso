package eserciziInterfaccia;
// Crare un'interfaccia gestione quadri, questa interfaccia dovrà avere i seguenti metodi astratti:
// - aggiungi -rimuovi -cercaPerNome -cercaPerAnno
// Una classe Quadro , che avrà : nome,  int anno, autore, int costo, boolean corniceCostosa
// La classe quadro dovrà estendere operaArte, la classe OperaArte sarà astratta e avrà le seguenti proprietà : nome, anno, autore, costo
// Nella classe start avrò una lista di opere d'arte, dove inseriamo opere d'arte e avere la possibiltà di chimare i metodi sopra citati

import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String[] args) {
        List<OperaArte> opere = new ArrayList<>();
        opere.add(new Quadro("David", "Donatello", 1999, 2000, true));
        System.out.println(opere);

    }
}