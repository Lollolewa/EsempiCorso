package org.generation.italy.esempiCorso.slytherin.exercises.rubrica;

public class Start {
    public static void main(String[] args) {
        Contatto c1 = new Contatto("Mario", "Mario", "234857437856");
        Contatto c2 = new Contatto("Luigi", "Luigi", "234857437");
        Contatto c3 = new Contatto("Cane", "Bello", "223455856");
        Contatto c4 = new Contatto("Gatto", "Pazzo", "26587945");

        Rubrica r = new Rubrica();

        r.aggiungiContatto("Wano", "Pano", "324656754");
        r.aggiungiContatto("Luigi", "Luigi", "234857437");
        r.aggiungiContatto("Cane", "Bello", "223455856");
        r.aggiungiContatto("Gatto", "Pazzo", "26587945");

        System.out.println(r.toString());
    }
}
