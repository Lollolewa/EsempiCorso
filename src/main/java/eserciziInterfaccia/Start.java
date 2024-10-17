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

        GestioneQuadriImpl quadri = new GestioneQuadriImpl();

        Quadro op = new Quadro("primo","io",2024,4000,true);
        Quadro op1 = new Quadro("secondo","tu",2014,4000,false);

        quadri.aggiungi(op);
        quadri.aggiungi(op1);
//        quadri.cercaPerAnno(2010);
        quadri.cercaPerNome("primo");
//        System.out.println(op.toString());
    }
}
