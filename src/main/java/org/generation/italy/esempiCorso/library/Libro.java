package org.generation.italy.esempiCorso.library;

public class Libro {

    private String titolo, autore;
    private int annoPubblicazione;
    private boolean isDisponibile;

    public Libro(String titolo, String autore, int annoPubblicazione, boolean isDisponibile){
        this.titolo = titolo;
        this.autore = autore;
        this.annoPubblicazione = annoPubblicazione;
        this.isDisponibile = isDisponibile;
    }

    public boolean isDisponibile(){
        return isDisponibile;
    }

    public void setIsDisponibile(boolean isDisponibile){
        this.isDisponibile = isDisponibile;
    }

    public String getTitolo(){
        return titolo;
    }

    public String getAutore(){
        return autore;
    }


    public String toString(){
        return "Autore: " + autore + "\n"
                + "Titolo: " + titolo + "\n"
                + "Anno di pubblicazione: " + annoPubblicazione + "\n"
                + "Il libro è disponibile? " + isDisponibile;
    }
}
