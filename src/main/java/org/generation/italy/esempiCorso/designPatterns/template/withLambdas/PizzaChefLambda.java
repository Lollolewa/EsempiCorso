package org.generation.italy.esempiCorso.designPatterns.template.withLambdas;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class PizzaChefLambda {
    public PizzaLambda cookPizza(Supplier<String> doughChooser, Supplier<List<String>> toppingsGenerator,
                                 Supplier<String> cheeseChooser, Supplier<Boolean> hasTomatoSauce, Supplier<Integer> timeCalculator,
                                 Supplier<Optional<String>> oilChooser){
        PizzaLambda p = new PizzaLambda();
        System.out.println("mettiamo la legna");
        System.out.println("accendiamo il forno");
        p.setDoughType(doughChooser.get());
        System.out.println("impasto la farina");
        List<String> toppings = toppingsGenerator.get();
        p.setCheeseType(cheeseChooser.get());
        p.setHasTomatoSauce(hasTomatoSauce.get());
        toppings.forEach(t -> {
            p.addToppings(t);
            System.out.println("aggiungo " + t + ",");
        });
        p.setCookingTime(timeCalculator.get());
        System.out.println("sto cuocendo la pizza per " + p.getCookingTime() + "minuti");
        p.setOilType(oilChooser.get().orElse("nada!"));
        System.out.println("infine aggiungo " + oilChooser.get().orElse("nessun olio"));
        System.out.println("la pizza è servita");
        return p;
    }
}
