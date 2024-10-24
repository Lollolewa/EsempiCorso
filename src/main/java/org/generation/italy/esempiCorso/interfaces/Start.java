package org.generation.italy.esempiCorso.interfaces;

public class Start {
    public static void main(String[] args){
        HumanBeing hb = new Accountant();
        hb.speak();
        Accountant ac = new Accountant();
        inviteForDinner(ac);
        Superhero sh = new Superhero();
        inviteForDinner(sh);
    }
    public static void inviteForDinner(HumanBeing h){
        h.speak();
        h.eat();
    }
}
