package org.generation.italy.esempiCorso.inheritance.Fantasy;

import java.time.LocalDate;

public class Mage extends Character{
    public Mage(String nome, String cognome, String nomePersonaggio, String password, LocalDate dataInizio,
                boolean isLogged, boolean dies, boolean runsAway, double forza, double intelligenza,
                double carisma, double agilita, double puntiVita, String name) {
        super(nome, cognome, nomePersonaggio, password, dataInizio, isLogged, dies, runsAway, forza, intelligenza, carisma, agilita, puntiVita, name);
    }

    @Override
    public void attaccoSpeciale(Character target, Character attacker){
        if(attacker.intelligenza>55){
            System.out.println(nomePersonaggio + " usa l'attacco speciale Throw Fireball maxato!");
            double nuovaForza = attacker.forza*0.2;
            target.puntiVita -= nuovaForza;
        } else {
            System.out.println(nomePersonaggio + " usa l'attacco speciale Throw Fireball!");
            target.puntiVita -= attacker.forza*0.1;
        }

    }

    @Override
    public void attaccalo(Character target, Character attacker) {
        System.out.println(nomePersonaggio + " attacca!");
        target.puntiVita -= attacker.forza;
    }

    @Override
    public void difendimi(Character defender, Character enemy) {
        System.out.println(nomePersonaggio + " si difende!");
        delay();
        double beforeAttack = defender.puntiVita;
        double enemysStrength = enemy.forza;
        defender.puntiVita -= enemy.forza;
        System.out.println(enemy.nomePersonaggio + " ha tolto " + enemysStrength + " su " + beforeAttack + " punti vita di " + defender.nomePersonaggio + ".");
        //incrementa la sua intelligenza ogni volta che si difende
        double nuovaInt = defender.intelligenza*0.05;
        defender.intelligenza = nuovaInt;
        System.out.println(nomePersonaggio + " incrementa la sua intelligenza di " + nuovaInt);
    }
    public static void delay () {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
    // il mago parte con int 50, se mettiamo ogni volta che si difende guadagna 5% di int,
    // atk spec che se ha piu di 55 di int attacco fa piu danni