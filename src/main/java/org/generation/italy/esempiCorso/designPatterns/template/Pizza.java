package org.generation.italy.esempiCorso.designPatterns.template;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private List<String> toppings;
    private int cookingTime;
    private String doughType, oilType, cheeseType;
    private boolean hasTomatoSauce;

    public Pizza(int cookingTime, String doughType, String oilType, String cheeseType, boolean hasTomatoSauce) {
        this.cookingTime = cookingTime;
        this.doughType = doughType;
        this.oilType = oilType;
        this.cheeseType = cheeseType;
        this.toppings = new ArrayList<>();
        this.hasTomatoSauce = false;
    }

    public Pizza() {
        this.toppings = new ArrayList<>();
    }

    public List<String> getToppings() {
        return toppings;
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public String getDoughType() {
        return doughType;
    }

    public void setDoughType(String doughType) {
        this.doughType = doughType;
    }

    public String getOilType() {
        return oilType;
    }

    public void setOilType(String oilType) {
        this.oilType = oilType;
    }

    public String getCheeseType() {
        return cheeseType;
    }

    public void setCheeseType(String cheeseType) {
        this.cheeseType = cheeseType;
    }

    public boolean isHasTomatoSauce() {
        return hasTomatoSauce;
    }

    public void setHasTomatoSauce(boolean hasTomatoSauce) {
        this.hasTomatoSauce = hasTomatoSauce;
    }

    public void addTopping(String topping) {
        this.toppings.add(topping);
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "toppings=" + toppings +
                ", cookingTime=" + cookingTime +
                ", doughType='" + doughType + '\'' +
                ", oilType='" + oilType + '\'' +
                ", cheeseType='" + cheeseType + '\'' +
                ", hasTomatoSauce=" + hasTomatoSauce +
                '}';
    }
}
