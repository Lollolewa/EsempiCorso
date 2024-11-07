package org.generation.italy.esempiCorso.MagicHatOOP;

public class Studente {
    private String name,surname, preferredHouse;

    public Studente(String name, String surname, String preferenza) {
        this.name = name;
        this.surname = surname;
        this.preferredHouse = preferenza;
    }
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getPreferredHouse(){
        return preferredHouse;
    }
    public String toString(){
        return String.format("Nome: %s %s Preferenza: %s", name,surname, preferredHouse);
    }


}
