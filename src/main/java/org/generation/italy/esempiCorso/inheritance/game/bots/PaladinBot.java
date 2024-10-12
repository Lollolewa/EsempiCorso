package org.generation.italy.esempiCorso.inheritance.game.bots;

import org.generation.italy.esempiCorso.inheritance.game.characters.Character;

public class PaladinBot extends Bot {

    public PaladinBot() {
        //SET PALADIN BOT STATS
        setBotLevel(1);
        setHp(200);
        setStr(13);
        setDex(13);
        setIntel(11);
        setChr(17);
    }

    //PALADIN ULTIMATE - HEAL
    @Override
    public int ultimate(Bot y) {
        int hp = getHp();
        hp += (int) ((getChr()+getIntel())*0.7);
        setHp(hp);
        return getHp();
    }
    @Override
    public int ultimate(Character x) {
        return 0;
    }

    //BASE ACTIONS
    @Override
    public String getBotClass() {
        return "You are a bot paladin!";
    }

    @Override
    public int attack(Character x) {
        return getStr()+getChr()/2;
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
        int randomIntInRange = (int) (Math.random() * .5);
        if(getHp()<=10 && randomIntInRange == 0){
            System.out.println("The enemy managed to escape with only "+getHp()+"HP.");
            return true;

        }else {
            return false;
        }
    }

}

