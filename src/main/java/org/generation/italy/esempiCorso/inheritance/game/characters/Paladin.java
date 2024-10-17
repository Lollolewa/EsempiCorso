package org.generation.italy.esempiCorso.inheritance.game.characters;

import org.generation.italy.esempiCorso.inheritance.game.Character;

import java.net.PasswordAuthentication;
import java.time.LocalDate;

public class Paladin extends Character {

    public Paladin(String username, String name, String lastName, LocalDate doc, PasswordAuthentication password, boolean isLogged, int str, int intel, int dex, int hp, int chr) {
        super(username, name, lastName, doc, password, isLogged, str, intel, dex, hp, chr);
    }

    //SET PALADIN STATS
    @Override
    public void setHp(int hp) {
        super.setHp(200);
    }

    @Override
    public void setStr(int str) {
        super.setStr(13);
    }

    @Override
    public void setDex(int dex) {
        super.setDex(10);
    }

    @Override
    public void setIntel(int intel) {
        super.setIntel(11);
    }

    @Override
    public void setChr(int chr) {
        super.setChr(17);
    }

    //ULTIMATE
    @Override
    public void ultimate() {
        int hp = getHp();
        hp += (getChr()+getIntel())*0.7;
        setHp(hp);
    }

    //BASE ACTIONS
    @Override
    public void getCharachterClass() {

    }

    @Override
    public void attack() {
        int dmg = getStr()+getChr()/2;
    }

    @Override
    public void defend() {

    }

    @Override
    public void flee() {

    }


}
