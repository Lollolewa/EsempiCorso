package org.generation.italy.esempiCorso.inheritance.game;

import org.generation.italy.esempiCorso.inheritance.game.characters.Mage;
import org.generation.italy.esempiCorso.inheritance.game.characters.Paladin;
import org.generation.italy.esempiCorso.inheritance.game.characters.bots.MageBot;
import org.generation.italy.esempiCorso.inheritance.game.characters.bots.PaladinBot;

import java.time.LocalDate;
import java.util.Scanner;

public class Arcade {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        Character paladino = new Paladin("BobbyRocket", "Bobby", "Rocket", LocalDate.of(2020, 5, 2), "pippo");
        Character mago = new Mage("tommynasa", "Tommy", "nasa", LocalDate.of(2020, 5, 2), "pippo");
        Character bot = new MageBot();
        Character botp = new PaladinBot();

//        System.out.println(paladino.getCharacterClass());
//
//        System.out.println(mago.attack(paladino));
//        System.out.println(paladino.defend(mago));
//        System.out.println(mago.ultimate(paladino));
//        System.out.println(mago.ultimate(paladino));
//
//        System.out.println(paladino.getHp());
//        System.out.println(mago.getHp());
//
//        paladino.login();
//        paladino.logout();
        System.out.println(bot.getCharacterClass());

        System.out.println(bot.attack(botp));


        System.out.println(bot.getHp());
        System.out.println(botp.getHp());








    }
}
