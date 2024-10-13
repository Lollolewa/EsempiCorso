package org.generation.italy.esempiCorso.inheritance.game.characters;

import org.generation.italy.esempiCorso.inheritance.game.Character;
import org.generation.italy.esempiCorso.inheritance.game.Bot;

import java.time.LocalDate;

public class Amazon extends org.generation.italy.esempiCorso.inheritance.game.Character {

    public Amazon(String username, String name, String lastName, LocalDate doc, String password) {
        super(username, name, lastName, doc, password);
        //SET AMAZON STATS
        setHp(120);
        setStr(9);
        setDex(18);
        setIntel(14);
        setChr(20);
    }

    //AMAZON ULTIMATE - CASTRATION
    @Override
    public int ultimate(Bot x) {
        int dmg = 0;
        if (x != x) {
            int hp = x.getHp();
            hp = 0;
            dmg = x.getHp()-hp;
            x.setHp(hp);
            return dmg;
        } else {
            return dmg;
        }

    }
    @Override
    public int ultimate(Character x) {
        return 0;
    }

    //BASE ACTIONS
    @Override
    public String getCharacterClass() {
        return "You are an amazon!";
    }

    @Override
    public int attack(Bot x) {
        return getIntel()+getChr()/2;
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


