package org.generation.italy.esempiCorso.inheritance.game.bots;

import org.generation.italy.esempiCorso.inheritance.game.characters.Character;

public class MageBot extends Bot{

    public MageBot() {
        //SET MAGE BOT STATS
        setBotLevel(1);
        setHp(100);
        setStr(8);
        setDex(9);
        setIntel(20);
        setChr(10);
    }

    //MAGE ULTIMATE - FIREBALL
    @Override
    public int ultimate(Character x) {
        int hp = x.getHp();
        hp -= getIntel()*4;
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
        return "You are a bot mage!";
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
