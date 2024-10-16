package org.generation.italy.esempiCorso.Slytherin.eserciziCollection.OperaDArte;

public class Main {
    public static void main(String[] args){
        OperaDArte q1 = new Quadro("titolo", "artista", 6,6);
        OperaDArte q2 = new Quadro("titolo", "artista2", 6,6);
        OperaDArte s1 = new Scultura("titolo", "artista2", 6,6, 2);

        System.out.println(q1.printingombro());

        System.out.println(q1.confronta(q1,q2));

        Collezione c = new Collezione();
        c.inserire(q1);
        c.inserire(q2);
        c.inserire(s1);

        c.stampa();
    }
}
