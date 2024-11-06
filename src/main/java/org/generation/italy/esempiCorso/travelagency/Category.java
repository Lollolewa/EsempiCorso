package org.generation.italy.esempiCorso.travelagency;

public enum Category {
    luxury, comfort, budget, backpacker;

    public String toString(Category c){
        return c.toString();
    }
    public static Category fromInteger(int n){
        return values()[n-1];
    }
}
