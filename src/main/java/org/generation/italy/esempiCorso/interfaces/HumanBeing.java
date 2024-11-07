package org.generation.italy.esempiCorso.interfaces;

public interface HumanBeing {
    int maxAge = 120; //public static final int maxAge, ha public, static e final di default

    void speak();
    //in un'interfaccia public e abstract sono di default, hanno visibilità sempre pubblica e sono sempre abstract

    void eat();
    void work();

    void work(int hours);
}
