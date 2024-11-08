package org.generation.italy.esempiCorso.designPatterns.template;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private List<String> toppings;
    private int cookingTime;
    private String doughType;
    private String oilType;
    private String cheeseType;
    private boolean hasTomatoSauce;

    public Pizza(int cookingTime, String doughType, String oilType) {
        this.cookingTime = cookingTime;
        this.doughType = doughType;
        this.oilType = oilType;
        this.toppings = new ArrayList<>();
    }
    public Pizza(){
        this.toppings = new ArrayList<>();
    }

    public int getCookingTime() {
        return cookingTime;
    }
    public String getDoughType() {
        return doughType;
    }
    public String getOilType() {
        return oilType;
    }
    public String getCheeseType() {
        return cheeseType;
    }
    public boolean isHasTomatoSauce() {
        return hasTomatoSauce;
    }

    public void setCheeseType(String cheeseType) {
        this.cheeseType = cheeseType;
    }
    public void setHasTomatoSauce(boolean hasTomatoSauce) {
        this.hasTomatoSauce = hasTomatoSauce;
    }
    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }
    public void setOilType(String oilType) {
        this.oilType = oilType;
    }
    public void setDoughType(String doughType) {
        this.doughType = doughType;
    }

    public void addToppings(String topping){
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
