package org.generation.italy.esempiCorso.inheritance.Fantasy;

import java.time.LocalDate;

public class Rogue extends Character{
    public Rogue(String nome, String cognome, String nomePersonaggio, String password,
                 LocalDate dataInizio, boolean isLogged, boolean dies, boolean runsAway,
                 double forza, double intelligenza, double carisma, double agilita,
                 double puntiVita, String name) {
        super(nome, cognome, nomePersonaggio, password, dataInizio, isLogged, dies, runsAway, forza, intelligenza, carisma, agilita, puntiVita, name);
    }

    @Override
    public void attaccoSpeciale(Character target, Character attacker){
        if(attacker.agilita>55){
            System.out.println(nomePersonaggio + " usa l'attacco speciale Steal maxato!");
            double nuovaForza = attacker.forza*0.2;
            target.puntiVita -= nuovaForza;
        } else {
            System.out.println(nomePersonaggio + " usa l'attacco speciale Steal!");
            double nuovaInt = attacker.agilita*0.2;
            target.puntiVita -= attacker.forza;
        }
    }

    @Override
    public void attaccalo(Character target, Character attacker) {
        System.out.println(nomePersonaggio + " attacca!");
        target.puntiVita -= attacker.forza;
        double nuovaInt = attacker.agilita*0.06;
        attacker.agilita = nuovaInt;
    }

    @Override
    public void difendimi(Character defender, Character enemy) {
        System.out.println(nomePersonaggio + " si difende!");
        delay();
        double beforeAttack = defender.puntiVita;
        double enemysStrength = enemy.forza;
        defender.puntiVita -= enemy.forza;
        System.out.println(enemy.nomePersonaggio + " ha tolto " + enemysStrength + " su " + beforeAttack + " punti vita di " + defender.nomePersonaggio + ".");
        //incrementa la sua agilità ogni volta che si difende
        double nuovaInt = defender.agilita*0.06;
        defender.agilita = nuovaInt;
        System.out.println(nomePersonaggio + " incrementa la sua agilità di " + nuovaInt);
    }
    public static void delay () {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
