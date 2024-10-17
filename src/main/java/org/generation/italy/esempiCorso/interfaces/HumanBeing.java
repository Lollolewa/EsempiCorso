package org.generation.italy.esempiCorso.interfaces;

 interface  HumanBeing {
  public static final int maxAge = 120;
   //default public static final
    //final = costante
    //static =
    public abstract void speak();
     //visibilita' sempre public_ sottotinteso, idem abstract
    //no metodi privati

    public abstract void eat();
    public abstract void work(int hours);

}
