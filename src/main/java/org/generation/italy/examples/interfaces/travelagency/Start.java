package org.generation.italy.examples.interfaces.travelagency;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String[] args) {

        UserInterface ui = new UserInterface();

        ui.begin();
        List<String> advisedActivity = new ArrayList<>();
        advisedActivity.add("Torre Eiffel");


        List<String> advisedRestaurant = new ArrayList<>();
        advisedRestaurant.add("asafsadhgsdhf");


        Destination parigi = new Destination("Parigi", "città bella", "Hotel", 10, advisedActivity, advisedRestaurant);

        List<Destination> meteTuristiche = new ArrayList<>();
        meteTuristiche.add(parigi);

        Voyage pippo = new Voyage(meteTuristiche,10215452, 1000, LocalDate.of(2024, 10, 18), LocalDate.of(2024,12,11), Category.LUXURY);

        System.out.println(pippo);
        System.out.println(advisedActivity.get(0));

    }

}

