package org.generation.italy.esempiCorso.inheritance.exercise;

import java.time.LocalDate;
import java.util.Random;

public class Amazon extends Character{
    public Amazon(String nome, String cognome, String nomePersonaggio, String password ) {
        super(nome, cognome, nomePersonaggio, password,30,10,20,20,220);

    }

    public void castrate(Character x){
        x.puntiVita += this.carisma*1.5;
    }


    @Override
    public void abilitaSpeciale(Character x) {

    }

    @Override
    public void attaccalo(Character x) {
        Random rand = new Random();
        int n = rand.nextInt(50);
        if(n>x.carisma) {
            this.danni = this.carisma;
        }else {
            this.danni = 0;
        }
    }

    @Override
    public void difendimi(Character y) {
        this.puntiVita -= y.danni*0.6;
    }

    @Override
    public String getCharacterClass() {
        return this.getClass().getSimpleName();
    }
}
