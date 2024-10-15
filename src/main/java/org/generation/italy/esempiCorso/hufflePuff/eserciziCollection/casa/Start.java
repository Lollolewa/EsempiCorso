package org.generation.italy.esempiCorso.hufflePuff.eserciziCollection.casa;

public class Start {
    public static void main(String[] args) {
        Archivio archivio = new Archivio();

        Villa villa1 = new Villa(300, 15, true);
        Villa villa2 = new Villa(100, 8, false);
        Villa villa3 = new Villa(150, 10, false);

        Appartamento app1 = new Appartamento(90, 8, 3);
        Appartamento app2 = new Appartamento(90, 8, 5);
        Appartamento app3 = new Appartamento(90, 8, 9);

        archivio.getVille().add(villa1);
        archivio.getVille().add(villa2);
        archivio.getVille().add(villa3);
        archivio.getAppartamenti().add(app1);
        archivio.getAppartamenti().add(app2);
        archivio.getAppartamenti().add(app3);

        System.out.println(archivio.mediaCosti(100));
    }
}
