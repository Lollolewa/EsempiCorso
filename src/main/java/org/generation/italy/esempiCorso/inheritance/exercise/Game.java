package org.generation.italy.esempiCorso.inheritance.exercise;

import java.time.LocalDate;

public class Game {

    public static void main(String[] args){
        LocalDate giorno = LocalDate.of(2022, 10, 10);
        Player p = new Paladin("Mario", "Lone", "ziocannone", "ddd333", giorno, false, 20, 5, 4, 3, 2);
        Player p2 = new Mage("Mago", "One", "bombone", "222sss", giorno, false, 20, 2, 6, 5, 2);



    }

    public void fight(Player p, Player p1){
        boolean fleeFlag = false;
        do{
            p.attack();
            p1.attack();
            p.defend();
            p1.defend();
        }while(!p.isDead && !p1.isDead && !fleeFlag);
    }
}
