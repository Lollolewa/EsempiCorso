package org.generation.italy.esempiCorso.inheritance.hufflePuff.eserciziCollection;

public class Main {
    public static void main(String[] args) {
        Archivio archivio = new Archivio();

        Villa v1 = new Villa(150, 8, true);
        Villa v2 = new Villa(300, 12, false);
        Appartamento a1 = new Appartamento(80, 3, 50);
        Appartamento a2 = new Appartamento(120, 4, 40);

        archivio.aggiungiVilla(v1);
        archivio.aggiungiVilla(v2);
        archivio.aggiungiAppartamento(a1);
        archivio.aggiungiAppartamento(a2);

        double mediaCosti = archivio.mediaCosti(100);
        System.out.println("La media dei costi per le case con superficie > 100 è: " + mediaCosti);
    }
}
