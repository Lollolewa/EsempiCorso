package org.generation.italy.esempiCorso.inheritance.game.characters;

import org.generation.italy.esempiCorso.inheritance.game.Character;
import org.generation.italy.esempiCorso.inheritance.game.Bot;

import java.time.LocalDate;

public class Barbarian extends org.generation.italy.esempiCorso.inheritance.game.Character {
    public Barbarian(String username, String name, String lastName, LocalDate doc, String password) {
        super(username, name, lastName, doc, password);
        //SET BARBARIAN STATS
        setHp(150);
        setStr(20);
        setDex(10);
        setIntel(5);
        setChr(5);
    }

    //BARBARIAN ULTIMATE - BERSERK
    @Override
    public int ultimate(Character x) {
        setStr(30);
        return getStr()+getDex()/2;
    }

    @Override
    public int ultimate(Bot x) {
        return 0;
    }

    //BASE ACTIONS
    @Override
    public String getCharacterClass() {
        return "You are a barbarian!";
    }

    @Override
    public int attack(Bot x) {
        return getStr()+getDex()/2;
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

