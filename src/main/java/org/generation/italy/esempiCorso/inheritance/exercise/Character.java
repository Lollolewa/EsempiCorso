package org.generation.italy.esempiCorso.inheritance.exercise;

import java.time.LocalDate;
import java.util.Scanner;

public abstract class Character extends Player {
    protected String charClass;
    protected int hp, strength, intelligence, charisma, agility;

    public Character(String name, String surname, String userName, String password, boolean isLogged, LocalDate startDate, int hp, int strength, int intelligence, int charisma, int agility) {
        super(name, surname, userName, password, isLogged, startDate);
        this.charClass = charClass;
        this.hp = hp;
        this.strength = strength;
        this.intelligence = intelligence;
        this.charisma = charisma;
        this.agility = agility;
    }
    public void getCharacterClass(){
        Scanner sc = new Scanner(System.in);
        String classChoice = sc.nextLine();
        if (classChoice.equalsIgnoreCase("Amazon")) {
            charClass = "Amazon";
        }

    }
    public abstract void attack();
    public abstract void defend();
    public void flee(){
        System.out.println("Mi sto cagando addosso, aiutoooooo \nVaffanculo, ciao\nDatemi un water!!1!1");
    }
}
// La classe player viene estesa da una classe Character
// La classe char avrà interi per Punti vita, Forza, Intelligenza, Carisma, Agilità
// ed un metodo professione: getCharacterClass, che restituisce la professione del personaggio
// Il character avrà i metodi Attacca che prende in input un character(
// ed uno Difendi che prende in input un character (quello che mi sta attaccando)
// e Scappa che interrompe il combattimento