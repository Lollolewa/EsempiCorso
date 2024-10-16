package org.generation.italy.esempiCorso.inheritance.exercise;

import java.time.LocalDate;

public class Barbarian extends Character{
    public Barbarian(String nome, double forza, double intelligenza, double carisma, double agilita, double puntiVita) {
        super(nome, forza, intelligenza, carisma, agilita, puntiVita);
    }

    @Override
    public void attaccoSpeciale(Character target, Character attacker){
        target.puntiVita -= attacker.forza*2;
        attacker.puntiVita = attacker.puntiVita*0.2;
    }

    @Override
    public void attaccalo(Character target, Character attacker) {
        target.puntiVita -= attacker.forza;
    }

    @Override
    public void difendimi(Character defender, Character enemy) {
        defender.puntiVita -= defender.forza;
    }
    @Override
    public String getCharacterClass() {
        return this.getClass().getSimpleName();
    }
}
