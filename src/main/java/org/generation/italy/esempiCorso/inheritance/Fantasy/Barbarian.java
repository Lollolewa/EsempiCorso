package org.generation.italy.esempiCorso.inheritance.Fantasy;

import java.time.LocalDate;

public class Barbarian extends Character{
    public Barbarian(String nome, String cognome, String nomePersonaggio, String password, LocalDate dataInizio,
                     boolean isLogged, boolean dies, boolean runsAway, double forza, double intelligenza, double carisma,
                     double agilita, double puntiVita, String name) {
        super(nome, cognome, nomePersonaggio, password, dataInizio, isLogged, dies, runsAway, forza, intelligenza, carisma, agilita, puntiVita, name);
    }

    @Override
    public void attaccoSpeciale(Character target, Character attacker){
        System.out.println(nomePersonaggio + " usa l'attacco speciale Berserk!");
        target.puntiVita -= attacker.forza*2;
        attacker.puntiVita = attacker.puntiVita*0.2;
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
        defender.puntiVita -= defender.forza;
        System.out.println(enemy.nomePersonaggio + " ha tolto " + enemysStrength + " su " + beforeAttack + " punti vita rimasti a " + defender.nomePersonaggio + ".");
    }
    public static void delay () {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
