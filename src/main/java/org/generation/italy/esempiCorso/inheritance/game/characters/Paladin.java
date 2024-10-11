package org.generation.italy.esempiCorso.inheritance.game.characters;

import org.generation.italy.esempiCorso.inheritance.game.Character;

import java.time.LocalDate;

public class Paladin extends Character {

    public Paladin(String username, String name, String lastName, LocalDate doc, String password, boolean isLogged) {
        super(username, name, lastName, doc, password, isLogged);
    }

    //SET PALADIN STATS
    @Override
    public void setHp(int hp) {
        super.setHp(200);
    }

    @Override
    public void setStr(int str) {
        super.setStr(13);
    }

    @Override
    public void setDex(int dex) {
        super.setDex(13);
    }

    @Override
    public void setIntel(int intel) {
        super.setIntel(11);
    }

    @Override
    public void setChr(int chr) {
        super.setChr(17);
    }

    //PALADIN ULTIMATE - HEAL
    @Override
    public void ultimate(Character y) {
        int hp = getHp();
        hp += (int) ((getChr()+getIntel())*0.7);
        setHp(hp);
    }

    //BASE ACTIONS
    @Override
    public String getCharachterClass() {
        return "You are a paladin!";
    }

    @Override
    public int attack(Character x) {
        return getStr()+getChr()/2;
    }

    @Override
    public void defend(Character x) {
        int hp = getHp();
        int dmgTaken = ((attack(x)-getDex())/2);
        setHp(hp-dmgTaken);
    }

    @Override
    public boolean flee() {
        int randomIntInRange = (int) (Math.random() * .5);
        if(getHp()<=10 && randomIntInRange == 0){
            System.out.println("You're lucky, you managed to flee with only "+getHp()+"HP.");
            return true;

        }else {
            System.out.println("You chose to keep fighting until death!");
            return false;
        }
    }

}
