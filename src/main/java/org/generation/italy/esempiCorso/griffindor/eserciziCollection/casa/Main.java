package org.generation.italy.esempiCorso.griffindor.eserciziCollection.casa;

public class Main {
    public static void main(String[] args) {

        Archivio archivio = new Archivio();
        archivio.aggiungiVilla(new Villa(170, 5, false));
        archivio.aggiungiVilla(new Villa(250, 10, true));
        archivio.aggiungiAppartamento(new Appartamento(70, 3, 100));
        archivio.aggiungiAppartamento(new Appartamento(150, 4, 100));

    double mediaCosti = archivio.mediaCosti(100);
    System.out.println("La media dei costi degli appartamenti con 100mq è: " + mediaCosti);
    }
}
