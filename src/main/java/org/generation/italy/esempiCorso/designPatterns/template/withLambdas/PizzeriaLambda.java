package org.generation.italy.esempiCorso.designPatterns.template.withLambdas;

import java.util.List;
import java.util.Optional;

public class PizzeriaLambda {
    public static void main(String[] args){
        PizzaChefLambda pzl = new PizzaChefLambda();
        PizzaLambda pl = pzl.cookPizza(
                ()->"farina kamut",
                ()-> List.of("salsiccia","funghi"),
                ()->"mozzarella di bufala",
                ()->true,
                ()->20,
                ()-> Optional.of("olio piccante")
        ); //non devo creare una classe per ogni pizza ma faccio tutto attraverso le lambda
        //dipende da quanti metodi ci sono

        System.out.println(pl);

    }
}
