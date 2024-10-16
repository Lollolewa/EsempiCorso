package org.generation.italy.esempiCorso.inheritance.exercise;

import java.time.LocalDate;

public class Mage extends Character{
    public Mage(String nome, double forza, double intelligenza, double carisma, double agilita, double puntiVita) {
        super(nome, forza, intelligenza, carisma, agilita, puntiVita);
    }

    @Override
    public void attaccoSpeciale(Character target, Character attacker){
        if(attacker.intelligenza>55){
            double nuovaForza = attacker.forza*0.2;
            target.puntiVita -= nuovaForza;
        } else {
            target.puntiVita -= attacker.forza;
        }

    }

    @Override
    public void attaccalo(Character target, Character attacker) {
        target.puntiVita -= attacker.forza;

    }

    @Override
    public void difendimi(Character defender, Character enemy) {
        defender.puntiVita -= enemy.forza;
        double nuovaInt = defender.intelligenza*0.05;
        defender.intelligenza = nuovaInt;
    }
    @Override
    public String getCharacterClass() {
        return this.getClass().getSimpleName();
    }
}
    // il mago parte con int 50, se mettiamo ogni volta che si difende guadagna 5% di int,
    // atk spec che se ha piu di 55 di int attacco fa piu danni