package org.generation.italy.esempiCorso.slytherin.eserciziCollection.esercizioCase;

public class Main {
    public static void main(String[] args) {
        Archivio archivio = new Archivio();

        Villa villa1 = new Villa(200, 8, true);
        Villa villa2 = new Villa(300, 12, false);
        Appartamento app1 = new Appartamento(120, 3, 8);
        Appartamento app2 = new Appartamento(80, 2, 5);

        archivio.aggiungiVilla(villa1);
        archivio.aggiungiVilla(villa2);
        archivio.aggiungiAppartamento(app1);
        archivio.aggiungiAppartamento(app2);

        System.out.println("Media dei costi per case con superficie maggiore di 100: " + archivio.mediaCosti(100));
    }
}