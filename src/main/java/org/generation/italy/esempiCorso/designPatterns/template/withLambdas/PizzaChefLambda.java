package org.generation.italy.esempiCorso.designPatterns.template.withLambdas;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class PizzaChefLambda {
    public PizzaLambda cookPizza(Supplier<String> doughChooser,
                                 Supplier<List<String>> toppingGenerator,
                                 Supplier<String> cheeseChooser,
                                 Supplier<Boolean> hasTomato,
                                 Supplier<Integer> timeChooser,
                                 Supplier<Optional<String>> oilChooser
                        ){ //Supplier = interfaccia funzionale che rappresenta un fornitore di risultati, ha soltanto il metodo get()
                          //voglio implementare con lambda e non con ereditarietà

        System.out.println("accendiamo il forno");
        System.out.println("mettiamo la legna");
        PizzaLambda p = new PizzaLambda();
        //serve un'interfaccia funzionale per ogni step
        p.setDoughType(doughChooser.get());
        System.out.println("impasto la farina");
        List<String> toppings = toppingGenerator.get();
        p.setCheeseType(cheeseChooser.get());
        p.setHasTomatoSauce(hasTomato.get());
        toppings.forEach(t->{
            p.addTopping(t);
            System.out.println("aggiungo " + t);
        });
        p.setCookingTime(timeChooser.get());
        System.out.println("sto cuocendo la pizza per " + p.getCookingTime());
        String oil = oilChooser.get().orElse("nessun olio");
        p.setOilType(oil);
        System.out.println("infine aggiungo " + oil);
        System.out.println("la pizza è servita");
        return p;

       //livello"sticazzi" la programmazione con jdbc è macchinosa, quindi vogliamo farlo attraverso template,
        // serie di metodi che vengono implementati diversamente
    }
}
