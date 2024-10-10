package org.generation.italy.esempiCorso.inheritance.geometria;

public class Forma {
       protected int base, altezza;
       public Forma(){
           super();
       }

        public Forma (int base, int altezza){
           super();
           this.base = base;
           this.altezza = altezza;
        }
        public int calcolaArea(){
            return 0;
    }
        //public String toString(){
          //  return "" + base + altezza;
        //}
}
