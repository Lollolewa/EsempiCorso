package org.generation.italy.esempiCorso.interfacce;

public interface CanFly { // obbliga chi la implementa a scrivere il metodo fly().
    boolean fly(); // di base sono public e abstract.
    int maxHeight= 12500; //
    default void doAcrobatics(){
        System.out.println("Acrobatic fly");
    }
    default void canFlyFast(){
        System.out.println("Puo volare velocemente");
    }
}
