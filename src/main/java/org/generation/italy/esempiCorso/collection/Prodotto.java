package org.generation.italy.esempiCorso.collection;

public class Prodotto {

    protected String descrizione;
    protected int costo;

    public Prodotto(String descrizione, int costo) {
        this.descrizione = descrizione;
        this.costo = costo;
    }


    /**
     * ciao a tutti
     * @return
     */
    public static String acaso(){
        return "ciao";
    }
}
