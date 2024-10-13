package org.generation.italy.esempiCorso.inheritance.game.bots;

import org.generation.italy.esempiCorso.inheritance.game.Bot;
import org.generation.italy.esempiCorso.inheritance.game.Character;

public class BarbarianBot extends Bot {

    public BarbarianBot() {
        setHp(150);
        setStr(20);
        setDex(10);
        setIntel(5);
        setChr(5);
    }

    //BARBARIAN ULTIMATE - BERSERK
    @Override
    public int ultimate(Bot x) {
        setStr(30);
        return getStr()+getDex()/2;
    }

    @Override
    public int ultimate(Character x) {
        return 0;
    }

    //BASE ACTIONS
    @Override
    public String getBotClass() {
        return "You are an amazon Bot!";
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
            System.out.println("The enemy managed to escape with only "+getHp()+"HP.");
            return true;

        }else {
            return false;
        }
    }
}
