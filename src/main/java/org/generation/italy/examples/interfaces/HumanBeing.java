package org.generation.italy.examples.interfaces;

public interface HumanBeing {
    //in un'interfaccia non posso mettere metodi privati , tutti i metodi sono public e abstract . sia public che abstract sono di default
    static final int maxAge = 120;
    // anche static e final sono di default, potevo scrivere anche solo int maxAge .


    void speak();
    void eat();
    void work(int hours);

}
