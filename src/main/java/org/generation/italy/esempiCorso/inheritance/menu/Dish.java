package org.generation.italy.esempiCorso.inheritance.menu;

public class Dish {

    private String name;
    private int carbs, proteins, fats, price;

    public Dish(String name, int carbs, int proteins, int fats, int price){

        this.name = name;
        this.carbs = carbs;
        this.proteins = proteins;
        this.fats = fats;
        this.price = price;

    }

    public String toString(){
        return "Il piatto " + name + " costa " +  price + "€";
    }

    public int getTotCalories(){
        return (carbs * 4) + (proteins * 4) + (fats * 9);
    }

    public int getPrice(){
        return price;
    }
}
