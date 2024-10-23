package org.generation.italy.esempiCorso.interfacce;

public class Aereo implements CanFly{
    @Override
    public boolean fly() {
        System.out.println("L'aereo può volare");
        return true;
    }
}
