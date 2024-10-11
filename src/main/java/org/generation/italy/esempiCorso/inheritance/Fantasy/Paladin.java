package org.generation.italy.esempiCorso.inheritance.Fantasy;

import java.time.LocalDate;

public class Paladin extends Character{
    public Paladin(boolean isLogged, LocalDate dataInizio, String password, String nomePersonaggio, String cognome, String nome, int forza, int puntivita, int agilita, int carisma, int intelligenza) {
        super(isLogged, dataInizio, password, nomePersonaggio, cognome, nome, forza, puntivita, agilita, carisma, intelligenza);
    }
    @Override
    public void attaccalo(Character x) {
        x.puntiVita -= forza;
    }
    @Override
    public void difendimi(Character y) {
        //Paladin p = new Paladin();
        //Paladin p2 = new Paladin();
        //p2.difendimi(p); // Io.difendimi(da chi);
        this.puntiVita -= (y.forza/2); // todo
        System.out.println();
    }

    @Override
    public void attacca(Character x) {

    }

    public void heal(){
        puntiVita +=10;
    }
}

