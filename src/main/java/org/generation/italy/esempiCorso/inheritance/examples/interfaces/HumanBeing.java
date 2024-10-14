package org.generation.italy.esempiCorso.inheritance.examples.interfaces;

public interface HumanBeing {
    int maxAge = 120;  //di default è una costante  static final
     void speak();  //visibilità sempre pubblica, lo sarà sempre poichè tutti i metodi di un interfaccia sono public,

    void eat();
    void work(int hours);
}
