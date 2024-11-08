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

    public Pizza(){
        this.toppings=new ArrayList<>();
    }

    public Pizza(int cookingTime, String doughType, String oilType,String cheeseType,boolean hasTomatoSauce) {
        this.cookingTime = cookingTime;
        this.doughType = doughType;
        this.oilType = oilType;
        this.cheeseType=cheeseType;
        this.hasTomatoSauce=hasTomatoSauce;
        this.toppings=new ArrayList<>();
    }

    public void setHasTomatoSauce(boolean hasTomatoSauce) {
        this.hasTomatoSauce = hasTomatoSauce;
    }

    public void setCheeseType(String cheeseType) {
        this.cheeseType = cheeseType;
    }

    public void setOilType(String oilType) {
        this.oilType = oilType;
    }

    public void setDoughType(String doughType) {
        this.doughType = doughType;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public void addTopping(String topping){
        this.toppings.add(topping);
    }

    public int getCookingTime() {
        return cookingTime;
    }

    @Override
    public String toString() {
        return "PizzaLambda{" +
                "toppings=" + toppings +
                ", cookingTime=" + cookingTime +
                ", doughType='" + doughType + '\'' +
                ", oilType='" + oilType + '\'' +
                ", cheeseType='" + cheeseType + '\'' +
                ", hasTomatoSauce=" + hasTomatoSauce +
                '}';
    }
}
