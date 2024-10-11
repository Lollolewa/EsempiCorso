package org.generation.italy.esempiCorso.inheritance.exercise;

import java.time.LocalDate;
import java.util.Random;

public class Rogue extends Character {

    public Rogue(String nome, String cognome, String nomePersonaggio, String password, LocalDate dataIscrizione, boolean isLogged, int puntiVita,
                  int forza, int intelligenza, int carisma, int agilità, String nomeClasse, boolean isDefending, int maxHP, int riduzioneDanno){
        super(nome, cognome, nomePersonaggio, password, dataIscrizione, isLogged, puntiVita, forza, intelligenza, carisma, agilità, nomeClasse, false,
                maxHP, 0);
    }

    @Override
    public String getCharacterClass() {
        return this.nomeClasse;
    }


    @Override
    public void Attacca(Character nemico) {
        if(nemico.isDefending){
            nemico.puntiVita -= (this.forza - riduzioneDanno)/2;
            nemico.isDefending = false;
        }
        else{
            nemico.puntiVita -= this.forza;
        }
    }

    @Override
    public void Difendi() {
        this.isDefending = true;
    }

    @Override
    public boolean Scappa() {
        int x = (int)(Math.random()*19);
        if(x >= 16){
            return true;
        }
        return false;
    }

    public void steal(Character nemico){
        if(nemico.isDefending){
            nemico.puntiVita -= (int)(forza*0.8) / 2;
            nemico.isDefending = false;
        }
        else{
            nemico.puntiVita -= (int)forza*0.8;
        }
        double x = (Math.random());
        if(x <= 0.45){
            nemico.riduzioneDanno = 5;
        }
    }
}