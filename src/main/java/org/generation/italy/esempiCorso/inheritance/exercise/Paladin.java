package org.generation.italy.esempiCorso.inheritance.exercise;

import java.time.LocalDate;
import java.util.Random;

public class Paladin extends Character {
    int counter = 1;
    public Paladin(String nome, String cognome, String nomePersonaggio, String password ) {
        super(nome, cognome, nomePersonaggio, password,30,15,10,10,250);

    }

    public void heal(){
        this.puntiVita += 20;
        System.out.println(" Ho usato heal ");
    }


    @Override
    public void abilitaSpeciale( Character x) {
        Random rand = new Random();
        int n = rand.nextInt(100);
        n = n+1;
        if(n%2==0){
            heal();
        }   else{
            counter++;
        }
        if(counter==5){
            heal();
            counter = 1;
        }
    }

    @Override
    public void attaccalo(Character x) {
        Random rand = new Random();
        int n = rand.nextInt(50);
        if(n>x.agilita) {
            this.danni = this.forza;
        }else {
            this.danni = 0;
        }
    }

    @Override
    public void difendimi(Character y) {

        this.puntiVita -= y.danni*0.7;
    }

    @Override
    public String getCharacterClass() {
        return this.getClass().getSimpleName();
    }
}
