package org.generation.italy.esempiCorso.griffindor.eserciziCollection.MagicHatObj;

public class Student {
    private String name;  // Nome dello studente
    private String surname;  // Cognome dello studente
    private House preferredHouse;  // Casa preferita dallo studente (di tipo enum House)

    // Costruttore della classe Student
    public Student(String name, String surname, House preferredHouse) {
        this.name = name;  // Inizializza il nome con il valore passato
        this.surname = surname;  // Inizializza il cognome con il valore passato
        this.preferredHouse = preferredHouse;  // Inizializza la casa preferita con il valore passato
    }

    public String getName() {
        return name;  // Restituisce il nome dello studente
    }

    public String getSurname() {
        return surname;  // Restituisce il cognome dello studente
    }

    public House getPreferredHouse() {
        return preferredHouse;  // Restituisce la casa preferita dello studente
    }

    @Override
    public String toString() {
        // Restituisce una rappresentazione in stringa dello studente con nome, cognome e casa preferita
        return name + " " + surname + " (Preferred: " + preferredHouse + ")";
    }
}
