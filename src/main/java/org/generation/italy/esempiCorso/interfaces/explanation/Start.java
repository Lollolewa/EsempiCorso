package org.generation.italy.esempiCorso.interfaces.explanation;

import org.generation.italy.esempiCorso.utilities.StringUtilities;

public class Start {
    public static void main(String[] args) {
        //.StringUtilities st = new StringUtilities();
        String result = StringUtilities.invert("ciao");
        HumanBeing hb = new Accountant();
        hb.speak();
        Accountant ac = new Accountant();
        inviteForDinner(ac);
        SuperHero sh = new SuperHero();
        inviteForDinner(sh);

    }
    public static void inviteForDinner(HumanBeing h){
        h.speak();
        h.eat();

    }
}
