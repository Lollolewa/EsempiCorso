package org.generation.italy.esempiCorso.inheritance.exercise;

import java.time.LocalDate;

public class Barbarian extends Character {
    public Barbarian(String name, String surname, String userName, String password, boolean isLogged, LocalDate startDate, int hp, int strength, int intelligence, int charisma, int agility) {
        super(name, surname, userName, password, isLogged, startDate, hp, strength, intelligence, charisma, agility);
    }
}
