package org.generation.italy.esempiCorso.travelagency;

import java.util.List;

public class Destination {
    private String nomeAttrazione, descrizione, nomeHotel;
    private int numGiorni;
    private List<String> attivita;
    private List<String> ristorante;

    public Destination(String nomeAttrazione, List<String> ristorante, String descrizione, String nomeHotel, int numGiorni, List<String> attivita) {
        this.nomeAttrazione = nomeAttrazione;
        this.ristorante = ristorante;
        this.descrizione = descrizione;
        this.nomeHotel = nomeHotel;
        this.numGiorni = numGiorni;
        this.attivita = attivita;
    }

    public String getNomeAttrazione() {
        return nomeAttrazione;
    }

    public void setNomeAttrazione(String nomeAttrazione) {
        this.nomeAttrazione = nomeAttrazione;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getNomeHotel() {
        return nomeHotel;
    }

    public void setNomeHotel(String nomeHotel) {
        this.nomeHotel = nomeHotel;
    }

    public int getNumGiorni() {
        return numGiorni;
    }

    public void setNumGiorni(int numGiorni) {
        this.numGiorni = numGiorni;
    }

    public List<String> getAttivita() {
        return attivita;
    }

    public void setAttivita(List<String> attivita) {
        this.attivita = attivita;
    }

    public List<String> getRistorante() {
        return ristorante;
    }

    public void setRistorante(List<String> ristorante) {
        this.ristorante = ristorante;
    }
    @Override
    public String toString(){
        return String.format("Nome attrazione: %s \n Lista di ristoranti: %s \n Descrizione: %s \n Pernottamento presso: %s \n Numero giorni: %s \n Lista attivita: %s", nomeAttrazione, ristorante, descrizione, nomeHotel, nomeAttrazione, attivita);
    }
}