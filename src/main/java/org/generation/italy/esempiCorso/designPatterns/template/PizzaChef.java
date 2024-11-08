package org.generation.italy.esempiCorso.designPatterns.template;

import java.util.List;
import java.util.Optional;

public abstract class PizzaChef {
    public Pizza cookPizza(){ //un metodo concreto può chiamare un metodo astratto
        //algoritmo scritto una volta sola ma implementato ogni volta in modo diverso
        System.out.println("accendiamo il forno");
        System.out.println("mettiamo la legna");
        String dough = chooseDough();
        Pizza p = new Pizza();
        p.setDoughType(dough);
        System.out.println("impasto la farina");
        List<String> toppings = getToppings();
        p.setCheeseType("mozzarella");
        p.setHasTomatoSauce(chooseTomato());
        toppings.forEach(t->{
            p.addTopping(t);
            System.out.println("aggiungo " + t);
        });
        p.setCookingTime(calculateCookingTime());
        System.out.println("sto cuocendo la pizza per " + p.getCookingTime());
        Optional<String> oil = chooseOil();
        p.setOilType(oil.orElse("nessun olio"));
        System.out.println("infine aggiungo " + oil.orElse("nessun olio"));
        //se l'olio è presente lo stampa, altrimenti manda la stringa
        System.out.println("la pizza è servita");
        return p;
    }
    //isolo le parti che variano nei metodi astratti per poterle sostituire facilmente
    public abstract Optional<String> chooseOil();

    public abstract int calculateCookingTime();

    public abstract boolean chooseTomato();

    public abstract List<String> getToppings();

    public abstract String chooseDough();

}
