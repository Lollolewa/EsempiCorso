package org.generation.italy.esempiCorso.designPatterns.template;


import java.util.List;
import java.util.Optional;

public abstract class PizzaChef {

    public Pizza cookPizza(){
        Pizza p = new Pizza();
        System.out.println("mettiamo la legna");
        System.out.println("accendiamo il forno");
        String dough = chooseDough();
        p.setDoughType(dough);
        System.out.println("impasto la farina");
        List<String> toppings = getToppings();
        toppings.forEach(t -> {
            p.addToppings(t);
            System.out.println("aggiungo " + t + ",");
        });
        p.setCheeseType(chooseCheese());
        p.setHasTomatoSauce(chooseTomato());
        p.setCookingTime(calculateCookingTime());
        System.out.println("sto cuocendo la pizza per " + p.getCookingTime());
        Optional<String> oil = chooseOil();
        p.setOilType(oil.orElse("nessun olio"));
        System.out.println("infine aggiungo " + oil.orElse("nessun olio"));
        System.out.println("la pizza è servita");
        return p;
    }

    public abstract List<String> getToppings();
    public abstract String chooseDough();
    public abstract boolean chooseTomato();
    public abstract String chooseCheese();
    public abstract int calculateCookingTime();
    public abstract Optional<String> chooseOil();


    public abstract void addToppings(List<String> toppings);
}
