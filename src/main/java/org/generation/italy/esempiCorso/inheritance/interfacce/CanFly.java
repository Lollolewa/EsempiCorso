package org.generation.italy.esempiCorso.inheritance.interfacce;

public interface CanFly {
    //tipo astratto, detto contratto perchè costringe le classi che lo implementano a fare l'override di tutti i suoi metodi
    //tutti i metodi sono public e abstract
    boolean fly();

    //da java8 le interfacce possono avere anche variabili
    //di default sono public e static e final
    //static = non si riferisce all'oggetto ma alla classe

    int maxHeight = 1000;

    default void faiAcrobazie(){
        System.out.println("acrobazio");
    }

    default void qualcosa (){
        System.out.println("faccio qualcosa");
    }
}
