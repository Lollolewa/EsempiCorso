package org.generation.italy.esempiCorso.inheritance.game;

import java.time.LocalDate;

public abstract class Character extends Player{

    public Character(String username, String name, String lastName, LocalDate doc, String password, boolean isLogged) {
        super(username, name, lastName, doc, password, isLogged);
    }

    //STATS
    private int str, intel, dex, hp, chr;

    //GETTERS
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

    //SETTERS
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


    public abstract String getCharachterClass();

    public abstract int attack(Character x);

    public abstract void defend(Character x);

    public abstract boolean flee();

    public abstract void ultimate(Character y);

}
