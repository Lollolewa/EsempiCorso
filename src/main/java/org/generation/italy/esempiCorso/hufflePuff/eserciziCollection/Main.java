package org.generation.italy.esempiCorso.hufflePuff.eserciziCollection;

public class Main {
    public static void main(String[] args) {


        Archivio archivio = new Archivio();

        archivio.aggiungiVilla(new Villa(150,10,true));
        archivio.aggiungiVilla(new Villa(170,10,false));

        archivio.aggiungiAppartamento(new Appartamento(150,10,2));
        archivio.aggiungiAppartamento(new Appartamento(150,10,6));

        int mediaCosti = archivio.mediaCosti(160);
        System.out.println("Media costi delle case e " + mediaCosti);

    }
}