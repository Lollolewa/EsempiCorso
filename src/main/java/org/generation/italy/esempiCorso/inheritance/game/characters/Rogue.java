package org.generation.italy.esempiCorso.inheritance.game.characters;

import org.generation.italy.esempiCorso.inheritance.game.Bot;
import org.generation.italy.esempiCorso.inheritance.game.Character;

import java.time.LocalDate;

public class Rogue extends Character {

    public Rogue(String username, String name, String lastName, LocalDate doc, String password) {
        super(username, name, lastName, doc, password);
        //SET ROGUE STATS
        setHp(110);
        setStr(9);
        setDex(17);
        setIntel(18);
        setChr(9);
    }

    //ROGUE ULTIMATE - STEAL
    @Override
    public int ultimate(Bot x) {
        int stealStr = x.getStr() - 3;
        x.setStr(stealStr);
        return getStr() - stealStr;
    }
    @Override
    public int ultimate(Character x) {
        return 0;
    }

    //BASE ACTIONS
    @Override
    public String getCharacterClass() {
        return "You are a rogue!";
    }

    @Override
    public int attack(Bot x) {
        return getDex()+getChr()/2;
    }

    @Override
    public int defend(Bot x) {
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
