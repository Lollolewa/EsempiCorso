package org.generation.italy.esempiCorso.designPatterns.template.withLambdas;

import java.util.List;
import java.util.Optional;

public class PizzeriaLambda {
    public static void main(String[] args) {
        PizzaChefLambda pzL = new PizzaChefLambda();
        PizzaLambda pL = pzL.cookPizza(
                () -> "kamut",
                () -> List.of("salsiccia", "funghi"),
                () -> "mozzarella",
                () -> true,
                () -> 15,
                () -> Optional.of("olio piccante"));
        System.out.println(pL);
    }
}
