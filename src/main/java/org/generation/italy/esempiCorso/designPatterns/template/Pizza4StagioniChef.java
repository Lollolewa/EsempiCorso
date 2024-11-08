package org.generation.italy.esempiCorso.designPatterns.template;

import java.util.List;
import java.util.Optional;

public class Pizza4StagioniChef extends PizzaChef{

    @Override
    public Optional<String> chooseOil() {
        return Optional.of("olio d'oliva");
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
        return List.of("carciofini","olive","prosciutto","funghi");
    }

    @Override
    public String chooseDough() {
        return "farina integrale";
    }

}
