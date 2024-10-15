package org.generation.italy.esempiCorso.inheritance.exercise;

import java.time.LocalDate;
import java.util.Random;

public class Mage extends Character{
    int counter = 1;
    public Mage(String nome, String cognome, String nomePersonaggio, String password ) {
        super(nome, cognome, nomePersonaggio, password,10,35,15,20,200);

    }

    public void throwFireBall(Character x){
        x.puntiVita -= this.intelligenza*2;
        System.out.println("Ho usato abilita");
    }

    @Override
    public void abilitaSpeciale(Character x) {
        Random rand = new Random();
        int n = rand.nextInt(100);
        n = n+1;
        if(n%2==0){
            throwFireBall(x);
        }   else{
            counter++;
        }
        if(counter==5){
            throwFireBall(x);
            counter = 1;
        }
    }

    @Override
    public void attaccalo(Character x) {
        Random rand = new Random();
        int n = rand.nextInt(50);
        if(n>x.carisma) {
            this.danni = this.intelligenza;
        }else {
            this.danni = 0;
        }
    }

    @Override
    public void difendimi(Character y) {
        this.puntiVita -= y.danni*0.2;
    }

    @Override
    public String getCharacterClass() {
        return this.getClass().getSimpleName();
    }
}
    // il mago parte con int 50, se mettiamo ogni volta che si difende guadagna 5% di int,
    // atk spec che se ha piu di 55 di int attacco fa piu danni