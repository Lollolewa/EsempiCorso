package org.generation.italy.esempiCorso.griffindor.eserciziCollection.travelAgency;

public enum Category {
    luxury, comfort, budget, backpacker;

    public static Category fromInteger(int n){
        return values()[n-1];
    }
}
