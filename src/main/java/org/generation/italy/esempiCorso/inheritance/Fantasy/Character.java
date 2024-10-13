package org.generation.italy.esempiCorso.inheritance.Fantasy;

import java.time.LocalDate;

public abstract class Character extends Player{
    protected double forza, intelligenza, carisma, agilita, puntiVita;
    protected String name;
    protected boolean dies, runsAway, hasWon;
    private Character character;

    public Character(String nome, String cognome, String nomePersonaggio, String password,
                     LocalDate dataInizio, boolean isLogged, boolean dies, boolean runsAway,
                     double forza, double intelligenza, double carisma, double agilita,
                     double puntiVita, String name, boolean hasWon) {
        super(nome, cognome, nomePersonaggio, password, dataInizio, isLogged);
        this.forza = forza;
        this.intelligenza = intelligenza;
        this.carisma = carisma;
        this.agilita = agilita;
        this.puntiVita = puntiVita;
        this.name = name;
        this.dies = dies;
        this.runsAway = runsAway;
        this.hasWon = hasWon;
    }
    public abstract void attaccoSpeciale(Character target, Character attacker);
    public abstract void attaccalo(Character target, Character attacker);
    public abstract void difendimi(Character defender, Character enemy);
    public abstract void hasWon(Character character, Character enemy);
    public void scappa(){
        System.out.println(nomePersonaggio + " Scappa");
        runsAway = true;
    }
    public boolean isDead() {
        if(puntiVita <= 0) {
            System.out.println(nomePersonaggio + " è morto.");
            dies = true;
        } else {
            dies = false;
        }
        return dies;
    }
}
//nome, cognome, nomePersonaggio, password, dataInizio, isLogged