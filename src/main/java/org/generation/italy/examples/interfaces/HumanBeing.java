package org.generation.italy.examples.interfaces;

public interface HumanBeing {
    static final int maxAge = 120;
     //default static final
      void speak();
    // visibilita sempre public - sottointeso
    // no metodi privati

    void eat();
    void work(int hours);

}
