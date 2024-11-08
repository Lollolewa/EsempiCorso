package org.generation.italy.esempiCorso.designPatterns.template;

import java.util.List;
import java.util.Optional;

public class PizzaMarinaraChef extends PizzaChef{

    @Override
    public List<String> getToppings() {
        return List.of("acciughe", "capperi", "olive");
    }
    @Override
    public String chooseDough() {
        return "white flour";
    }
    @Override
    public boolean chooseTomato() {
        return true;
    }
    @Override
    public String chooseCheese() {
        return "nessuno";
    }
    @Override
    public int calculateCookingTime() {
        return 13;
    }
    @Override
    public Optional<String> chooseOil() {
        return Optional.of("olio piccante");
    }
    @Override
    public void addToppings(List<String> toppings) {    }
}
