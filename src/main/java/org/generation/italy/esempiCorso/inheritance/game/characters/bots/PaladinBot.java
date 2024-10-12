package org.generation.italy.esempiCorso.inheritance.game.characters.bots;

import org.generation.italy.esempiCorso.inheritance.game.Character;
import org.generation.italy.esempiCorso.inheritance.game.characters.Paladin;

import java.time.LocalDate;

public class PaladinBot extends Paladin {

    public PaladinBot() {
        //SET PALADIN STATS
        setHp(200);
        setStr(13);
        setDex(13);
        setIntel(11);
        setChr(17);
    }

    //PALADIN ULTIMATE - HEAL
    @Override
    public int ultimate(org.generation.italy.esempiCorso.inheritance.game.Character y) {
        int hp = getHp();
        hp += (int) ((getChr()+getIntel())*0.7);
        setHp(hp);
        return getHp();
    }

    //BASE ACTIONS
    @Override
    public String getCharacterClass() {
        return "You are a paladin!";
    }

    @Override
    public int attack(org.generation.italy.esempiCorso.inheritance.game.Character x) {
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
            System.out.println("You're lucky, you managed to flee with only "+getHp()+"HP.");
            return true;

        }else {
            System.out.println("You chose to keep fighting until death!");
            return false;
        }
    }

}

