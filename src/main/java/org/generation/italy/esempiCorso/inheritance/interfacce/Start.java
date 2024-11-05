package org.generation.italy.esempiCorso.inheritance.interfacce;

import javax.naming.ServiceUnavailableException;
import java.util.Arrays;

public class Start {
    public static void main(String[] args) {

        Persona p = new Persona();
        System.out.println(Persona.maxAge);
        //non posso assegnare un valore a una variabile static
        CanFly s = new Supereroe();//polimorfismo
        //s può accedere soltato ai metodi canFly non a quelli di Supereroe
        CanFly q = new Aereo();
        s.faiAcrobazie();
        Supereroe w = new Supereroe();
        w.qualcosa();
    }
}
