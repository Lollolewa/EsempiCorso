package org.generation.italy.esempiCorso.designPatterns;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private List<String> toppings;
    private int coockingTime;
    private String doughTipe;
    private String oilType;
    private String cheeseType;
    private boolean hasTomatoSauce;

    public Pizza(){
        this.toppings = new ArrayList<>();

    }

    public int getCoockingTime() {
        return coockingTime;
    }


    public Pizza(int coockingTime, String doughTipe, String oilType, boolean hasTomatoSauce) {
        this.coockingTime = coockingTime;
        this.doughTipe = doughTipe;
        this.oilType = oilType;
        this.hasTomatoSauce = hasTomatoSauce;
        this.toppings = new ArrayList<>();
    }

    public void setCoockingTime(int coockingTime) {
        this.coockingTime = coockingTime;
    }

    public void setDoughTipe(String doughTipe) {
        this.doughTipe = doughTipe;
    }

    public void setOilType(String oilType) {
        this.oilType = oilType;
    }

    public void setCheeseType(String cheeseType) {
        this.cheeseType = cheeseType;
    }

    public void setHasTomatoSauce(boolean hasTomatoSauce) {
        this.hasTomatoSauce = hasTomatoSauce;
    }
    public void addTopping(String topping){
        this.toppings.add(topping);
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "toppings=" + toppings +
                ", coockingTime=" + coockingTime +
                ", doughTipe='" + doughTipe + '\'' +
                ", oilType='" + oilType + '\'' +
                ", cheeseType='" + cheeseType + '\'' +
                ", hasTomatoSauce=" + hasTomatoSauce +
                '}';
    }
}
