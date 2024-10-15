package org.generation.italy.esempiCorso.inheritance.exercise;

import java.time.LocalDate;

public class Rogue extends Character{
    public Rogue(String nome, double forza, double intelligenza, double carisma, double agilita, double puntiVita) {
        super(nome, forza, intelligenza, carisma, agilita, puntiVita);
    }

    @Override
    public void attaccoSpeciale(Character target, Character attacker){
        if(attacker.agilita>55){
            double nuovaForza = attacker.forza*0.2;
            target.puntiVita -= nuovaForza;
        } else {
            double nuovaInt = attacker.agilita*0.2;
            target.puntiVita -= attacker.forza;
        }
    }

    @Override
    public void attaccalo(Character target, Character attacker) {
    target.puntiVita -= attacker.forza;
        double nuovaInt = attacker.agilita*0.06;
        attacker.agilita = nuovaInt;
    }

    @Override
    public void difendimi(Character defender, Character enemy) {
        defender.puntiVita -= enemy.forza;
        double nuovaInt = defender.agilita*0.06;
        defender.agilita = nuovaInt;
    }
    @Override
    public String getCharacterClass() {
        return this.getClass().getSimpleName();
    }
}
