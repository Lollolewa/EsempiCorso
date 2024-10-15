package org.generation.italy.esempiCorso.inheritance.exercise;

import java.time.LocalDate;
import java.util.Random;

public class Rogue extends Character{
    public Rogue(String nome, String cognome, String nomePersonaggio, String password ) {
        super(nome, cognome, nomePersonaggio, password,15,20,25,35,180);

    }

    public void steal(Character x){
        x.puntiVita -= this.agilita*1.5;
        this.puntiVita += this.agilita*1.5;
    }


    @Override
    public void abilitaSpeciale(Character x) {

    }

    @Override
    public void attaccalo(Character x) {
        Random rand = new Random();
        int n = rand.nextInt(50);
        if(n>x.carisma) {
            this.danni = this.agilita;
        }else {
            this.danni = 0;
        }
    }

    @Override
    public void difendimi(Character y) {
        this.puntiVita -= y.danni*0.4;
    }

    @Override
    public String getCharacterClass() {
        return this.getClass().getSimpleName();
    }
}
