package org.generation.italy.esempiCorso.inheritance.game;

import org.generation.italy.esempiCorso.inheritance.game.bots.AmazonBot;
import org.generation.italy.esempiCorso.inheritance.game.bots.Bot;
import org.generation.italy.esempiCorso.inheritance.game.bots.PaladinBot;
import org.generation.italy.esempiCorso.inheritance.game.characters.Character;
import org.generation.italy.esempiCorso.inheritance.game.characters.Mage;
import org.generation.italy.esempiCorso.inheritance.game.characters.Paladin;
import org.generation.italy.esempiCorso.inheritance.game.bots.MageBot;

import java.time.LocalDate;
import java.util.Scanner;

public class Arcade {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        org.generation.italy.esempiCorso.inheritance.game.characters.Character paladino = new Paladin("BobbyRocket", "Bobby", "Rocket", LocalDate.of(2020, 5, 2), "pippo");
        Character mago = new Mage("tommynasa", "Tommy", "nasa", LocalDate.of(2020, 5, 2), "pippo");

        Bot mageBot = new MageBot();
        Bot paladinBot = new PaladinBot();
        Bot amazonBot = new AmazonBot();

        System.out.println(mago.attack(amazonBot));
        System.out.println(amazonBot.defend(mago));
        System.out.println(amazonBot.attack(mago));
        System.out.println(mago.defend(amazonBot));

        System.out.println(amazonBot.ultimate(mago));

        System.out.println(mago.getHp());
        System.out.println(paladinBot.ultimate(mago));
        System.out.println(mago.getHp());


//        System.out.println(paladino.attack(mageBot));
//        System.out.println(mageBot.defend(paladino));
//
//        System.out.println(mageBot.attack(paladino));
//        System.out.println(paladino.defend(mageBot));
//        System.out.println(paladino.ultimate(paladino));
//        System.out.println(mageBot.ultimate(paladino));
//        System.out.println(mageBot.ultimate(paladino));
//        System.out.println(paladino.defend(mageBot));
//
//
//        System.out.println(paladino.getHp());
//        System.out.println(mageBot.getHp());








    }
}
