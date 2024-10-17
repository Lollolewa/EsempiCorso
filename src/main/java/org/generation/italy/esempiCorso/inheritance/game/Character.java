package org.generation.italy.esempiCorso.inheritance.game;

import java.net.PasswordAuthentication;
import java.time.LocalDate;

public abstract class Character extends Player{

    //STATS
    private int str, intel, dex, hp, chr;

    public Character(String username, String name, String lastName, LocalDate doc, PasswordAuthentication password, boolean isLogged, int str, int intel, int dex, int hp, int chr) {
        super(username, name, lastName, doc, password, isLogged);
        this.str = str;
        this.intel = intel;
        this.dex = dex;
        this.hp = hp;
        this.chr = chr;
    }

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


    public abstract void getCharachterClass();

    public abstract void attack();

    public abstract void defend();

    public abstract void flee();

    public abstract void ultimate();

}
