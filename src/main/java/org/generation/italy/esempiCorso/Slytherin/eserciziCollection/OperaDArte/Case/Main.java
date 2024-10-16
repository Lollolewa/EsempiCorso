package org.generation.italy.esempiCorso.Slytherin.eserciziCollection.OperaDArte.Case;

public class Main {
    public static void main(String[] args) {
        Appartamento a1 = new Appartamento(40, 6, 4);
        Appartamento a2 = new Appartamento(60, 9, 6);
        Appartamento a3 = new Appartamento(25, 5, 3);
        Appartamento a4 = new Appartamento(70, 2, 5);
        Appartamento a5 = new Appartamento(38, 7, 8);

        Villa v1 = new Villa(50, 5, true);
        Villa v2 = new Villa(55, 2, false);
        Villa v3 = new Villa(60, 8, false);
        Villa v4 = new Villa(40, 6, true);
        Villa v5 = new Villa(20, 5, false);

        Archivio a = new Archivio();
        a.inserire(a1);
        a.inserire(a2);
        a.inserire(a3);
        a.inserire(a4);
        a.inserire(a5);

        a.inserire(v1);
        a.inserire(v2);
        a.inserire(v3);
        a.inserire(v4);
        a.inserire(v5);

        System.out.println("La media del costo degli appartamenti è: " + a.ApartmentAvarageValue(50));
        System.out.println("La media del costo delle ville è: " + a.VilleAvarageValue(50));
    }
}
