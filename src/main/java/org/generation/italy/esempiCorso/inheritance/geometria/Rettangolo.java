package org.generation.italy.esempiCorso.inheritance.geometria;

public class Rettangolo extends Forma{
//se non invochiamo il costruttore della classe esplicitamente il compilatore inserisce
    //un invocazione al costruttore di default della classe madre
    public Rettangolo(int altezza ,int base) {
        super( altezza, base);

    }
    @Override
    public int calcolaArea(){
        return base*altezza;

    }




}
