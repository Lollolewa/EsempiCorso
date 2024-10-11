package org.generation.italy.esempiCorso.inheritance.exercise;

import java.time.LocalDate;
import java.util.Scanner;

public class GameMaster {
    public static void main(String[] args) {
        Player p1 = new Player();
        playerCreation(p1);
        System.out.println(p1.toString());
    }

    public static void playerCreation(Player p){
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci nome");
        p.name = sc.nextLine();
        System.out.println("Inserisci cognome");
        p.surname = sc.nextLine();
        System.out.println("Inserisci username");
        p.userName = sc.nextLine();
        System.out.println("Inserisci password");
        p.password = sc.nextLine();
        p.isLogged = false;
        System.out.println("Inserisci la data di oggi");
        p.startDate = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
        sc.nextLine();
    }

    public static Character getCharacterClass(Player p){
        Scanner sc = new Scanner(System.in);
        String classChoice;
        do {
            System.out.println("Che classe scegli?");
            classChoice = sc.nextLine();
            if (classChoice.equalsIgnoreCase("Amazon")) {
                Amazon ama = new Amazon(p.name, p.surname, p.userName, p.password, p.isLogged, p.startDate, 5, 3, 7, 8, 2);
                return  ama;
            } else if (classChoice.equalsIgnoreCase("Barbarian")) {
                Barbarian bar = new Barbarian(p.name, p.surname, p.userName, p.password, p.isLogged, p.startDate, 5, 3, 7, 8, 2);
                return bar;
            } else if (classChoice.equalsIgnoreCase("Mage")) {
                Mage mag = new Mage(p.name, p.surname, p.userName, p.password, p.isLogged, p.startDate, 5, 3, 7, 8, 2);
                return mag;
            } else if (classChoice.equalsIgnoreCase("Paladin")) {
                Paladin pal = new Paladin(p.name, p.surname, p.userName, p.password, p.isLogged, p.startDate, 5, 3, 7, 8, 2);
                return pal;
            } else if (classChoice.equalsIgnoreCase("Rogue")) {
                Rogue rog = new Rogue(p.name, p.surname, p.userName, p.password, p.isLogged, p.startDate, 5, 3, 7, 8, 2);
                return rog;
            } else {
                System.out.println("risposta non valida");
            }
        } while (!classChoice.equalsIgnoreCase("Amazon") && !classChoice.equalsIgnoreCase("Barbarian") && !classChoice.equalsIgnoreCase("Mage") && !classChoice.equalsIgnoreCase("Paladin") && !classChoice.equalsIgnoreCase("Rogue"));

    }
}
