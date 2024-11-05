package org.generation.italy.esempiCorso.eserciziAI.Veicoli;

public class Moto extends Veicolo implements VeicoloMotorizzato{
    public Moto(String name, String model, int yearOfBorn, int maxVelocity){
        super(model, name, yearOfBorn, maxVelocity);
    }
    @Override
    public void accelerate(){
        int newMaxV = getMaxVelocity() + 150;
        System.out.println("sto impennando, la mia velocità adesso è " + newMaxV);
    }
}
