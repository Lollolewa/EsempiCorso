package org.generation.italy.esempiCorso.inheritance.game.characters;

import org.generation.italy.esempiCorso.inheritance.game.Character;

import java.time.LocalDate;

public class Mage extends Character {

    public Mage(String username, String name, String lastName, LocalDate doc, String password) {
        super(username, name, lastName, doc, password);

        //SET MAGE STATS
        setHp(100);
        setStr(8);
        setDex(9);
        setIntel(20);
        setChr(10);
    }

    //MAGE ULTIMATE - FIREBALL
    @Override
    public int ultimate(Character x) {
        int hp = getHp();
        hp -= (int) getIntel()*4;
        setHp(hp);
        return getHp();
    }

    //BASE ACTIONS
    @Override
    public String getCharacterClass() {
        return "You are a mage!";
    }

    @Override
    public int attack(Character x) {
        return getIntel()+getChr()/2;
    }

    @Override
    public int defend(Character x) {
        int hp = getHp();
        int dmgTaken = ((attack(x)-getDex())/2);
        setHp(hp-dmgTaken);
        return getHp();
    }

    @Override
    public boolean flee() {
        int randomIntInRange = (int) (Math.random() * .7);
        if(getHp()<=10 && randomIntInRange == 0){
            System.out.println("You're lucky, you managed to flee with only "+getHp()+"HP.");
            return true;

        }else {
            System.out.println("You chose to keep fighting until death!");
            return false;
        }
    }
}
