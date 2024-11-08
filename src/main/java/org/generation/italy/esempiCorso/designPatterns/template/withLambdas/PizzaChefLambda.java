package org.generation.italy.esempiCorso.designPatterns.template.withLambdas;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class PizzaChefLambda {
    public PizzaLambda cookPizza(Supplier<String> doughChooser,
                                 Supplier<List<String>> toppingGenerator,
                                 Supplier<String> cheeseChooser,
                                 Supplier<Boolean> hasTomato,
                                 Supplier<Integer> timestamp,
                                 Supplier<Optional<String>> oilChoose){
        System.out.println("accendiamo il forno");
        System.out.println("mettiamo la legna");
        PizzaLambda p = new PizzaLambda();
        p.setDoughTipe(doughChooser.get());
        System.out.println("Impasto la farina");
        List<String> toppings = toppingGenerator.get();
        p.setCheeseType(cheeseChooser.get());
        p.setHasTomatoSauce(hasTomato.get());
        toppings.forEach(t->{p.addTopping(t);
        System.out.println("Aggiungo " + t);
        });
        p.setCoockingTime(timestamp.get());
        System.out.println("sto cuocendo la pizza per " + p.getCoockingTime() + " minuti");

        String oil = oilChoose.get().orElse("nessuno olio");
        p.setOilType(oil);
        System.out.println("aggiungo " + oil);
        System.out.println("La pizza è pronta");
        return p;





    }
}
