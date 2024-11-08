package org.generation.italy.esempiCorso.designPatterns.template;

import java.util.List;
import java.util.Optional;

public abstract class PizzaChef { //questo metodo concreto può chiamare i metodi astratti sotto
    public Pizza cookPizza(){
        System.out.println("Accendiamo il forno!");
        System.out.println("Mettiamo la legna!");
        String dough = chooseDough();
        Pizza p = new Pizza();
        p.setDoughType(dough);
        System.out.println("Impasto la farina!");
        System.out.println("Metto il cazzo nell'impasto!");
        List<String> toppings = getToppings();
        p.setCheeseType("Mozzarella");
        p.setHasTomatoSauce(chooseTomato());
        toppings.stream().forEach(t -> {
            p.addTopping(t);
            System.out.println("Aggiungo " + t);
        });
        p.setCookingTime(calculateCookingTime());
        System.out.println("Sto cuocendo la pizza per " + p.getCookingTime() + "!");
        Optional<String> oil = chooseOil();
        p.setOilType(oil.orElse("Nessun olio!"));
        System.out.println("Aggiungo " + oil.orElse("Nessun olio!") + "!");
        System.out.println("La pizza è servita");
        return p;
    }

    public abstract Optional<String> chooseOil();
    public abstract int calculateCookingTime();
    public abstract boolean chooseTomato();
    public abstract List<String> getToppings();
    public abstract String chooseDough();
}
