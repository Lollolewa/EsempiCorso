package org.generation.italy.esempiCorso.designPatterns;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public abstract class PizzaChef {
    public  Pizza cookPizza(){ //un metodo concreto può chiamare un metodo astratto
        System.out.println("Accendiamo il forno");
        System.out.println("Mettiamo la legna");
        String dough = chooseDough();
        Pizza p = new Pizza();
        p.setDoughTipe(dough);
        System.out.println("Impasto la " + dough);
        List<String> topping = getToppings();

        p.setCheeseType("Mozzarella");
        p.setHasTomatoSauce(chooseTomato());
        topping.forEach(t->{
            p.addTopping(t);
            System.out.println("Aggiungo " + t);
        });
        p.setCoockingTime(calculateCoockingTime());
        System.out.println("Sto cuocendo la pizza per " + p.getCoockingTime() + " minuti");
        Optional<String> oil = chooseOil();
        p.setOilType(oil.orElse("nessun olio"));
        System.out.println("Aggiungo " + oil.orElse("nessuno olio"));
        System.out.println("La pizza è servita");
        return p;
    }

    public  abstract Optional<String> chooseOil();

    public abstract int calculateCoockingTime();

    public abstract boolean chooseTomato();

    public abstract List<String> getToppings();

    public abstract String chooseDough();


}
