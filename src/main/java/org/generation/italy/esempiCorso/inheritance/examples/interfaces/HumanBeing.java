package org.generation.italy.esempiCorso.inheritance.examples.interfaces;

public interface HumanBeing {
    int maxAge = 120; //ciò che capisce il compilatore è " public static final int max age", ovvero questo valore sarà static e una costante;
    void speak(); //tutti i metodi di un interfaccia sono public e devono essere abstract; quindi non facciamo "public abstract void speak" perchè sarebbe ridondante, è cosi e basta.
    void eat();
    void work(int hours); //possiamo metterci tutti i metodi astratti che vogliamo;
}
