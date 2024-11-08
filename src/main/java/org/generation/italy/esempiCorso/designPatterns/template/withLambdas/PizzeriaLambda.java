package org.generation.italy.esempiCorso.designPatterns.template.withLambdas;

import java.util.List;
import java.util.Optional;

public class PizzeriaLambda {
    public static void main(String[] args) {
       PizzaChefLambda pz = new PizzaChefLambda();
       PizzaLambda pizza = pz.cookPizza(
               ()-> "farina kamut",
               ()-> List.of("salsicce","funghi"),
               ()-> "Mozzarella di bufala",
               ()-> true,
               ()-> 20,
               ()-> Optional.of("olio piccante")
       );
        System.out.println(pizza);

    }
}
