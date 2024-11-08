package org.generation.italy.esempiCorso.designPatterns.template;

import java.util.List;
import java.util.Optional;

public class PizzaMarinaraChef extends PizzaChef{

    @Override
    public Optional<String> chooseOil() {
        return Optional.of("Olio piccante");
    }

    @Override
    public int calculateCookingTime() {
        return 15;
    }

    @Override
    public boolean chooseTomato() {
        return true;
    }

    @Override
    public List<String> getToppings() {
        return List.of("Acciughe", "Capperi");
    }

    @Override
    public String chooseDough() {
        return "Farina 0";
    }
}
