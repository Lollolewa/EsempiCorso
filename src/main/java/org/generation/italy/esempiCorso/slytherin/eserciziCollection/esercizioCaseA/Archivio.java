package org.generation.italy.esempiCorso.slytherin.eserciziCollection.esercizioCaseA;

import java.util.ArrayList;
import java.util.List;

public class Archivio {

    // inizializzazione delle liste di Villa e Appartamento di tipo ArrayList
    // le liste contengono varie ville e vari appartamenti
    // ogni elemento della lista corrisponderà a un oggetto di tipo Villa o Appartamento
    protected List<Villa> ville = new ArrayList<>();
    protected List<Appartamento> appartamenti = new ArrayList<>();

    public Archivio(List<Villa> ville, List<Appartamento> appartamenti){

        this.ville = ville;
        this.appartamenti = appartamenti;
    }


    public int mediaCosti(int superficieMinima){

        int countCase = 0; // mantiene in memoria quante case con superfice > della supMinima trovata
        int sommaPrezzo = 0; // mantiene in memoria il prezzo delle case superfice > della supMinima trovata

        // per ogni appartamento della lista appartamenti aggiorna il contatore delle case che rispettano la
        // condizione e somma il loro prezzo
        // quindi manterrà in memoria la somma del prezzo e il numero delle case in memoria per il calcolo della media
        for(Appartamento appartamento : appartamenti){
            if(appartamento.superficie > superficieMinima){
                countCase++;
                sommaPrezzo += appartamento.costoCasa();
            }
        }

        for(Villa villa : ville){
            if(villa.superficie > superficieMinima){
                countCase ++;
                sommaPrezzo += villa.costoCasa();
            }
        }
        // se ho trovato 3 case compatibili countCase = 3
        // e sommaprezzo sarà uguale alla somma dei prezzi delle tre case
        // e poi fa la media
        return sommaPrezzo/countCase;
    }
}
