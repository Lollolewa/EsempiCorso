package org.generation.italy.esempiCorso.ripassoInterfacce;

import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String[] args){
        Persona p = new Persona();
        //Persona.maxAge=10;
        System.out.println(Persona.maxAge);
        //non posso assegnare un valora a una variabile static
        CanFly s = new Supereroe(); //polimorfismo
        //s può accedere soltanto ai metodi canFly non a quelli di Supereroe

        CanFly q = new Aereo();
        s.faiAcrobazie();
        Supereroe w = new Supereroe();
        w.qualcosa();
        CanFly[] sipuofare = {s,w,q};
        List<CanFly> cheneso = new ArrayList<>();
        cheneso.add(s);
        cheneso.add(w);
        cheneso.add(q);
        cheneso.add(new Aereo());

        //List<CanFly,CanEat> = fuori di testa
        System.out.println(sipuofare);
    }
}
