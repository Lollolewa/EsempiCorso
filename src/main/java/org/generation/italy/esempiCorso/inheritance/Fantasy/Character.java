package org.generation.italy.esempiCorso.inheritance.Fantasy;

import java.time.LocalDate;

public abstract class Character extends Player{
    protected int forza, intelligenza, carisma, agilita, puntiVita;

    public Character(boolean isLogged, LocalDate dataInizio, String password, String nomePersonaggio, String cognome, String nome, int forza, int puntiVita, int agilita, int carisma, int intelligenza) {
        super(isLogged, dataInizio, password, nomePersonaggio, cognome, nome);
        this.forza = forza;
        this.puntiVita = puntiVita;
        this.agilita = agilita;
        this.carisma = carisma;
        this.intelligenza = intelligenza;
    }
    public abstract void attaccalo(Character x);
    public abstract void difendimi(Character y);
    public void scappa(){
        System.out.println(this.nomePersonaggio + "scappa.");
    }

    public abstract void attacca(Character x);
}
