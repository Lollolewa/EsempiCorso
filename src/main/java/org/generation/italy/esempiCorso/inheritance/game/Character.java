package org.generation.italy.esempiCorso.inheritance.game;

import java.time.LocalDate;

public abstract class Character extends Player{

    //STATS
    private int str;
    private int intel;
    private int dex;
    private int hp;
    private int chr;

    public Character(String username, String name, String lastName, LocalDate doc, String password) {
        super(username, name, lastName, doc, password);
    }

    //BOT CONSTRUCTOR
    public Character(){
    }

    //SETTERS
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



    public abstract String getCharacterClass();

    public abstract int attack(Character x);

    public abstract int defend(Character x);

    public abstract boolean flee();

    public abstract int ultimate(Character y);

}
