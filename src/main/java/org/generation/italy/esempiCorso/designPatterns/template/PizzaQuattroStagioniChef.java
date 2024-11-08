package org.generation.italy.esempiCorso.designPatterns.template;

import java.util.List;
import java.util.Optional;

public class PizzaQuattroStagioniChef extends PizzaChef {

    @Override
    public List<String> getToppings() {
        return List.of("carciofini", "olive", "prosciutto", "funghi");
    }
    @Override
    public String chooseDough() {
        return "wholemeal flour";
    }
    @Override
    public boolean chooseTomato() {
        return false;
    }
    @Override
    public String chooseCheese() {
        return "mozzarella";
    }
    @Override
    public int calculateCookingTime() {
        return 15;
    }
    @Override
    public Optional<String> chooseOil() {
        return Optional.empty();
    }
    @Override
    public void addToppings(List<String> toppings) {

    }
}
