package org.generation.italy.esempiCorso.inheritance.exercise;

import java.time.LocalDate;

public class Paladin extends Character {

    public Paladin(String nome,  double forza, double intelligenza, double carisma, double agilita, double puntiVita ) {
        super(nome, forza, intelligenza, carisma, agilita, puntiVita);

    }

    @Override
    public void attaccoSpeciale(Character target, Character attacker){
        target.puntiVita += target.puntiVita*0.3;
    }

    @Override
    public void attaccalo(Character target, Character attacker) {
        target.puntiVita -= attacker.forza;
    }

    @Override
    public void difendimi(Character defender, Character enemy) {
        defender.puntiVita -= enemy.forza*0.7;
    }

    @Override
    public String getCharacterClass() {
        return this.getClass().getSimpleName();
    }
}
