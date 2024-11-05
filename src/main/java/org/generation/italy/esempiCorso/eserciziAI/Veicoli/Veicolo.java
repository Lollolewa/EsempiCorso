package org.generation.italy.esempiCorso.eserciziAI.Veicoli;

import java.util.ArrayList;
import java.util.List;

public abstract class Veicolo {
    private String model, name;
    private int yearOfBorn, maxVelocity;

    public Veicolo(String model, String name, int yearOfBorn, int maxVelocity) {
        this.model = model;
        this.name = name;
        this.yearOfBorn = yearOfBorn;
        this.maxVelocity = maxVelocity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfBorn() {
        return yearOfBorn;
    }

    public void setYearOfBorn(int yearOfBorn) {
        this.yearOfBorn = yearOfBorn;
    }

    public int getMaxVelocity() {
        return maxVelocity;
    }

    public void setMaxVelocity(int maxVelocity) {
        this.maxVelocity = maxVelocity;
    }

    public String toString() {
        return String.format("il veicolo %s e' un modello %s dell' anno %s che ha come velocita massima %s.", name, model, yearOfBorn, maxVelocity);
    }
}