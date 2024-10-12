package org.generation.italy.esempiCorso.inheritance.game.bots;

import org.generation.italy.esempiCorso.inheritance.game.characters.Character;

public abstract class Bot {

    //BOT STATS
    private int botLevel;
    private int str;
    private int intel;
    private int dex;
    private int hp;
    private int chr;

    //SETTERS
    public void setBotLevel(int botLevel) {
        this.botLevel = botLevel;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public void setIntel(int intel) {
        this.intel = intel;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setChr(int chr) {
        this.chr = chr;
    }

    //GETTERS
    public int getBotLevel() {
        return botLevel;
    }

    public int getStr() {
        return str;
    }

    public int getIntel() {
        return intel;
    }

    public int getDex() {
        return dex;
    }

    public int getHp() {
        return hp;
    }

    public int getChr() {
        return chr;
    }

    //ABSTRACT BOT METHODS
    public abstract String getBotClass();

    public abstract int attack(Character x);

    public abstract int defend(Character x);

    public abstract boolean flee();

    public abstract int ultimate(Character x);

    public abstract int ultimate(Bot y);

}
