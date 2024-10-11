package org.generation.italy.esempiCorso.inheritance.exercise;

import java.time.LocalDate;

public abstract class Character extends Player{
    protected int puntiVita, forza, intelligenza, carisma, agilità;
    protected String nomeClasse;

    public Character(String nome, String cognome, String nomePersonaggio, String password, LocalDate dataIscrizione, boolean isLogged, boolean isDead, int puntiVita, int forza, int intelligenza, int carisma, int agilità) {
        super(nome, cognome, nomePersonaggio, password, dataIscrizione, isLogged, isDead);
        this.puntiVita = puntiVita;
        this.forza = forza;
        this.intelligenza = intelligenza;
        this.carisma = carisma;
        this.agilità = agilità;
        this.nomeClasse = nomeClasse;
        this.maxHP = maxHP;

    }

    public Character getCharacterClass(){

    }

    public abstract void attacca(Character c);

    public abstract void difendi(Character c);

    public abstract void flee();

}
