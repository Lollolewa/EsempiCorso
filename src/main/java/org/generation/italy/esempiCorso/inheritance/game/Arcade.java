package org.generation.italy.esempiCorso.inheritance.game;

import org.generation.italy.esempiCorso.inheritance.game.bots.AmazonBot;
import org.generation.italy.esempiCorso.inheritance.game.bots.PaladinBot;
import org.generation.italy.esempiCorso.inheritance.game.characters.Barbarian;
import org.generation.italy.esempiCorso.inheritance.game.characters.Mage;
import org.generation.italy.esempiCorso.inheritance.game.characters.Paladin;
import org.generation.italy.esempiCorso.inheritance.game.bots.MageBot;

import java.time.LocalDate;
import java.util.Scanner;

public class Arcade {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Character paladino = new Paladin("BobbyRocket", "Bobby", "Rocket", LocalDate.of(2020, 5, 2), "pippo");
        Character mago = new Mage("tommynasa", "Tommy", "nasa", LocalDate.of(2020, 5, 2), "pippo");
        Character barbaro = new Barbarian("BobbyRocket", "Bobby", "Rocket", LocalDate.of(2020, 5, 2), "pippo");

        Bot mageBot = new MageBot();
        Bot paladinBot = new PaladinBot();
        Bot amazonBot = new AmazonBot();

    }
}
