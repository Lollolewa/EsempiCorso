package org.generation.italy.esempiCorso.inheritance.game.characters;

import org.generation.italy.esempiCorso.inheritance.game.Character;

import java.net.PasswordAuthentication;
import java.time.LocalDate;

public class Mage extends Character {

    public Mage(String username, String name, String lastName, LocalDate doc, String password, boolean isLogged, int str, int intel, int dex, int hp, int chr) {
        super(username, name, lastName, doc, password, isLogged);
    }

    //SET MAGE STATS
    @Override
    public void setHp(int hp) {
        super.setHp(100);
    }

    @Override
    public void setStr(int str) {
        super.setStr(8);
    }

    @Override
    public void setDex(int dex) {
        super.setDex(9);
    }

    @Override
    public void setIntel(int intel) {
        super.setIntel(20);
    }

    @Override
    public void setChr(int chr) {
        super.setChr(10);
    }

    //MAGE ULTIMATE - FIREBALL
    @Override
    public void ultimate(Character x) {
        int hp = getHp();
        hp -= (int) getIntel()*4;
        setHp(hp);
    }

    //BASE ACTIONS
    @Override
    public String getCharachterClass() {
        return "You are a mage!";
    }

    @Override
    public int attack(Character x) {
        return getIntel()+getChr()/2;
    }

    @Override
    public void defend(Character x) {
        int hp = getHp();
        int dmgTaken = ((attack(x)-getDex())/2);
        setHp(hp-dmgTaken);
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
