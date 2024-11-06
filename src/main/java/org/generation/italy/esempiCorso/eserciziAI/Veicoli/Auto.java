package org.generation.italy.esempiCorso.eserciziAI.Veicoli;

import jdk.jfr.Percentage;

public class Auto extends Veicolo implements VeicoloMotorizzato{

    public Auto(String model, String name, int yearOfBorn, int maxVelocity) {
        super(model, name, yearOfBorn, maxVelocity);
    }
    @Override
    public void accelerate(){
        int newMaxV = getMaxVelocity() + 100;
        System.out.println("sto su due ruote, la mia velocità adesso è " + newMaxV);
    }
}