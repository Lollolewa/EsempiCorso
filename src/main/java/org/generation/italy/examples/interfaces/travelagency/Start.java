package org.generation.italy.examples.interfaces.travelagency;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main (String[] args){
//        UserInterface ui = new UserInterface();
//        ui.begin();
        Destination places1 = new Destination("Parigi","Famosa per la torre e il mondiale 2006","Hotel baguette",
                       5, List.of("Mangiare lumache","Visitare notre Dame"),List.of("McDonald", "BurgerKing"));
        Destination places2 = new Destination("Roma","Famosa per il Colosseo e la carbonara","Hotel Negrone",
                5, List.of("PickPocket!!!!","Visitare gli zingari"),List.of("McDonald", "BurgerKing"));
        Voyage povero = new Voyage(List.of(places1),Category.BUDGET, 123456, 500, LocalDate.of(2024,11,3),
                        LocalDate.of(2024,11,8));
        Voyage ricco= new Voyage(List.of(places1,places2),Category.LUXURY,654321,1000,LocalDate.of(2024,11,3),LocalDate.of(2024,11,13));
       VoyageRepository ciao = new VoyageRepository;
    }
}
