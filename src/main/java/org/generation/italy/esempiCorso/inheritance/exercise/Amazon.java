package org.generation.italy.esempiCorso.inheritance.exercise;

import java.time.LocalDate;

public class Amazon extends Character{
    public Amazon(String nome, double forza, double intelligenza, double carisma, double agilita, double puntiVita) {
        super(nome, forza, intelligenza, carisma, agilita, puntiVita);
    }

    @Override
    public void attaccoSpeciale(Character target, Character attacker){
        if(target.equals("Paladin") || target.equals("Barbarian")){
            double danno = attacker.forza*(attacker.carisma*0.6);
            target.puntiVita -= danno;
        } else {
            double danno = attacker.forza*(attacker.carisma*0.2);
            target.puntiVita -= danno;
        }
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
