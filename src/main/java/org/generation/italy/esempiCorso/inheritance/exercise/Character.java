package org.generation.italy.esempiCorso.inheritance.exercise;

import java.time.LocalDate;

public abstract class Character extends Player{
    protected double forza, intelligenza, carisma, agilita, puntiVita;
    protected String name;
    public double danni;
    public Character(String nome, String cognome, String nomePersonaggio, String password, double forza, double intelligenza, double carisma, double agilita, double puntiVita) {
        super(nome,cognome,nomePersonaggio,password);
        this.forza = forza;
        this.intelligenza = intelligenza;
        this.carisma = carisma;
        this.agilita = agilita;
        this.puntiVita = puntiVita;
    }
    public abstract void abilitaSpeciale(Character x);
    public abstract void attaccalo(Character x);
    public abstract void difendimi(Character y);
    public void scappa(){
        System.out.println(this.name + " Scappa");
    }
    public abstract String getCharacterClass();
    public String getName(){
        return name;
    }
    public boolean isDead(){
        return this.puntiVita<=0;
    }
}
//nome, cognome, nomePersonaggio, password, dataInizio, isLogged