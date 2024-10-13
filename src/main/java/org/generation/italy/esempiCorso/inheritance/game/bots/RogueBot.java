package org.generation.italy.esempiCorso.inheritance.game.bots;

import org.generation.italy.esempiCorso.inheritance.game.Bot;
import org.generation.italy.esempiCorso.inheritance.game.Character;

public class RogueBot extends Bot {

    public RogueBot() {
        setBotLevel(1);
        setHp(110);
        setStr(9);
        setDex(17);
        setIntel(18);
        setChr(9);
    }

    //ROGUE ULTIMATE - STEAL
    @Override
    public int ultimate(Character x) {
        int stealStr = x.getStr() - 3;
        x.setStr(stealStr);
        return getStr() - stealStr;
    }
    @Override
    public int ultimate(Bot x) {
        return 0;
    }

    //BASE ACTIONS
    @Override
    public String getBotClass() {
        return "You are an rogue Bot!";
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
