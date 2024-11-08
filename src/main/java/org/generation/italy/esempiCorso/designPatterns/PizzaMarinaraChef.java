package org.generation.italy.esempiCorso.designPatterns;

import java.util.List;
import java.util.Optional;

public class PizzaMarinaraChef extends PizzaChef{
    @Override
    public Optional<String> chooseOil() {
        return Optional.of("olio piccante");
    }

    @Override
    public int calculateCoockingTime() {
        return 20;
    }

    @Override
    public boolean chooseTomato() {
        return true;
    }

    @Override
    public List<String> getToppings() {
        return List.of("acciughe","capperi");
    }

    @Override
    public String chooseDough() {
        return "farina bianca";
    }
}
