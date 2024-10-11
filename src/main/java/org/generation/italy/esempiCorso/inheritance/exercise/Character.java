package org.generation.italy.esempiCorso.inheritance.exercise;

import java.time.LocalDate;

public abstract class Character extends Player {
    protected String nomeClasse;
    protected final int maxHP;
    protected int puntiVita, forza, intelligenza, carisma, agilità;
    protected boolean isDefending;
    protected int riduzioneDanno;

    public Character(String nome, String cognome, String nomePersonaggio, String password, LocalDate dataIscrizione, boolean isLogged, int puntiVita,
    int forza, int intelligenza, int carisma, int agilità, String nomeClasse, boolean isDefending, int maxHP, int riduzioneDanno){
        super(nome, cognome, nomePersonaggio, password, dataIscrizione, isLogged);
        this.puntiVita = puntiVita;
        this.forza = forza;
        this.intelligenza = intelligenza;
        this.carisma = carisma;
        this.agilità = agilità;
        this.nomeClasse = nomeClasse;
        this.isDefending = isDefending;
        this.maxHP = maxHP;
        this.riduzioneDanno = riduzioneDanno;
    }

    public abstract String getCharacterClass();

    public abstract void Attacca(Character nemico);

    public abstract void Difendi();

    public abstract boolean Scappa();
}