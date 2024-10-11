package org.generation.italy.esempiCorso.inheritance.game;

import org.generation.italy.esempiCorso.inheritance.game.characters.Mage;
import org.generation.italy.esempiCorso.inheritance.game.characters.Paladin;

import java.time.LocalDate;
import java.util.Scanner;

public class Arcade {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        Character p1 = new Paladin("BobbyRocket", "Bobby", "Rocket", LocalDate.of(2020, 5, 2), "pippo");
        Character p2 = new Mage("tommynasa", "Tommy", "nasa", LocalDate.of(2020, 5, 2), "pippo");


        System.out.println(p1.getCharacterClass());

        System.out.println(p2.attack(p1));

        System.out.println(p1.defend(p2));

        System.out.println(p1.ultimate(p1));




//        p1.login();
        p1.logout();








    }
}
