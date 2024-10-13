package org.generation.italy.esempiCorso.inheritance.game.bots;

import org.generation.italy.esempiCorso.inheritance.game.characters.Amazon;
import org.generation.italy.esempiCorso.inheritance.game.characters.Character;

import java.time.LocalDate;

public class AmazonBot extends Bot {

    public AmazonBot() {
        setBotLevel(1);
        setHp(120);
        setStr(9);
        setDex(18);
        setIntel(14);
        setChr(20);
    }

    //AMAZON ULTIMATE - CASTRATION
    @Override
    public int ultimate(Character x) {
        int hp = x.getHp();
        hp = 0;
        int dmg = x.getHp()-hp;
        x.setHp(hp);
        return dmg;
    }

    @Override
    public int ultimate(Bot y) {
        return 0;
    }

    //BASE ACTIONS
    @Override
    public String getBotClass() {
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


