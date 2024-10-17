package org.generation.italy.esempiCorso.inheritance.example.interfaces;

public interface HumanBeing {
    static final int maxAge = 120;
    //posso anche dire int maxAge ma il compilatore capisce quello sopra
    //public abstract void speak();
    //interfaccia = è un nuovo tipo di dato che contiene costanti statiche e metodi statici
    // da java 8 metodi statici e metodi default
    //ereditarietà multipla non voglio avere dalle due classi due metodi con stesso nome e funzione

    // le classi implementano le interfacce, deve dare implementazione a tutte le funzioni astratte dell'interfaccia
    // si dice infatti che l'interfaccia è un CONTRATTO
    //interfaccia non ha variabili
    //obbliga le classi concrete che la implementano a fare l'override dei metodi dell'interfaccia
    //static =
    void speak();
    //visibilità sempre public e abstract = sottinteso
    //no metodi privati

    void eat();
    void work(int hours);
}
