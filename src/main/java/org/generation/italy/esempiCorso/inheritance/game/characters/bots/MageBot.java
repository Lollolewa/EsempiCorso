package org.generation.italy.esempiCorso.inheritance.game.characters.bots;

import org.generation.italy.esempiCorso.inheritance.game.Character;
import org.generation.italy.esempiCorso.inheritance.game.characters.Mage;

import java.time.LocalDate;

public class MageBot extends Mage{

    public MageBot() {
        //SET MAGE BOT STATS
        setHp(100);
        setStr(8);
        setDex(9);
        setIntel(20);
        setChr(10);
    }

    //MAGE ULTIMATE - FIREBALL
    @Override
    public int ultimate(org.generation.italy.esempiCorso.inheritance.game.Character x) {
        int hp = x.getHp();
        hp -= getIntel()*4;
        int dmg = x.getHp()-hp;
        x.setHp(hp);
        return dmg;
    }

    //BASE ACTIONS
    @Override
    public String getCharacterClass() {
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
            System.out.println("You're lucky, you managed to flee with only "+getHp()+"HP.");
            return true;

        }else {
            System.out.println("You chose to keep fighting until death!");
            return false;
        }
    }
}
