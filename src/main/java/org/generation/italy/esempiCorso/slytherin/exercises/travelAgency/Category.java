package org.generation.italy.esempiCorso.slytherin.exercises.travelAgency;

public enum Category {
    luxury, comfort, budget, backpacker;

    public static Category fromInteger(int n){
        return values()[n-1];
    }
}
