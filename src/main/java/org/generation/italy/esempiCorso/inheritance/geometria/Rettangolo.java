package org.generation.italy.esempiCorso.inheritance.geometria;

public class Rettangolo extends Forma{
    public Rettangolo(int base, int altezza){
        //se non invochiamo il costruttore della classe esplicitamente, il compilatore inserisce un invocazione al costruttore di default della classe madre
       //this.base = base;
       //this.altezza = altezza; NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
        super(base, altezza);
    }
    @Override
    public int calcolaArea(){
        return base * altezza;
    }
}
