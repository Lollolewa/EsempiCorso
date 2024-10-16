package org.generation.italy.esempiCorso.inheritance.exercise;

import java.time.LocalDate;

public abstract class Character {
    protected double forza, intelligenza, carisma, agilita, puntiVita;
    protected String name;
    public Character(String nome, double forza, double intelligenza, double carisma, double agilita, double puntiVita) {
        this.name = name;
        this.forza = forza;
        this.intelligenza = intelligenza;
        this.carisma = carisma;
        this.agilita = agilita;
        this.puntiVita = puntiVita;

    }
    public abstract void attaccoSpeciale(Character target, Character attacker);
    public abstract void attaccalo(Character target, Character attacker);
    public abstract void difendimi(Character defender, Character enemy);
    public void scappa(){
        System.out.println(this.name + " Scappa");
    }
    public abstract String getCharacterClass();
    public String getName(){
        return name;
    }
}
//nome, cognome, nomePersonaggio, password, dataInizio, isLogged