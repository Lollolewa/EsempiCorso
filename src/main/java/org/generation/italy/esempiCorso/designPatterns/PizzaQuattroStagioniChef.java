package org.generation.italy.esempiCorso.designPatterns;

import java.util.List;
import java.util.Optional;

public class PizzaQuattroStagioniChef extends PizzaChef{
    @Override
    public Optional<String> chooseOil() {
        return Optional.of("olio di oliva");
    }

    @Override
    public int calculateCoockingTime() {
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
