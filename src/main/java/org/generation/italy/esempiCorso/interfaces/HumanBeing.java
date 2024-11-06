package org.generation.italy.esempiCorso.interfaces;

public interface HumanBeing {
    //l'interfaccia è un CONTRATTO perchè obbliga le classi concrete che la implementano a fare l'override dei metodi dell'interfaccia
    //l'interfaccia serve a fare polimorfismo
    int maxAge = 120;
    //public static final di default
    //public visibilita' di base per le interfacce, non package come per tutte le classi
    //final = costante
    //keyword static = dipende dalla classe, non dall'oggetto
    void speak();
    //visibilità sempre public sottinteso, idem abstract
    //no metodi privati
    void eat();
    void work(int hours);


    /*la relazione che esiste tra classe e interfacce è l'implementazione
    le interfacce sono un nuovo tipo di dato, in cui posso mettere soltanto classi statiche e metodi astratti
    class extends otherClass
    class implements interface*/
}
