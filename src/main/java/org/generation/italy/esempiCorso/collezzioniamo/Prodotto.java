package org.generation.italy.esempiCorso.collezzioniamo;

public class Prodotto {
    String descrizione;
    int prezzo;

    public Prodotto(String descrizione, int prezzo) {
        this.descrizione = descrizione;
        this.prezzo = prezzo;
    }


    /**
     * questa sintassi la usiamo per creare dei commetni che, una volta richiamato il metodo di una funzione di una classe
     * possiamo leggere nello specifico quello che va;
     */
    public int inutile() {
        return 0;
    }
}