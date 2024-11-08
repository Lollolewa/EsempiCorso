package org.generation.italy.esempiCorso.designPatterns.template;

import java.util.List;
import java.util.Optional;

public class PizzaQuattroStagioniChef extends PizzaChef{
    @Override
    public Optional<String> chooseOil() {
        return Optional.empty();
    }

    @Override
    public int calculateCookingTime() {
        return 15;
    }

    @Override
    public boolean chooseTomato() {
        return false;
    }

    @Override
    public List<String> getToppings() {
        return List.of("Carciofini", "Olive", "Prosciutto", "Funghi");
    }

    @Override
    public String chooseDough() {
        return "Farina integrale";
    }
}
