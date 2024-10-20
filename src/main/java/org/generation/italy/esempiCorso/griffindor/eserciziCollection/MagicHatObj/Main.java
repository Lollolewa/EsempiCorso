package org.generation.italy.esempiCorso.griffindor.eserciziCollection.MagicHatObj;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crea una lista di studenti, ognuno con nome, cognome e casa preferita (House)
        List<Student> students = Arrays.asList(
                new Student("Marco", "Falconetti", House.Hufflepuff),
                new Student("Mirko", "Risuleo", House.Hufflepuff),
                new Student("Alessia", "Pallavera", House.Ravenclaw),
                new Student("Eleonora", "Siciliano", House.Gryffindor),
                new Student("Myriam", "Massa", House.Ravenclaw),
                new Student("Pamela", "Milanese", House.Slytherin),
                new Student("Ejran", "Mustafoski", House.Gryffindor),
                new Student("Andrea", "Macellaro", House.Hufflepuff),
                new Student("Alessandro", "Massa", House.Ravenclaw),
                new Student("Alessandro", "Stelitano", House.Ravenclaw),
                new Student("Pietro", "Marinari", House.Hufflepuff),
                new Student("Stefano", "Puro", House.Gryffindor),
                new Student("Lucrezia", "Lauri", House.Ravenclaw),
                new Student("Mario", "Peccio", House.Slytherin),
                new Student("Lorenzo", "Masci", House.Gryffindor),
                new Student("Danilo", "Vulpiani", House.Hufflepuff),
                new Student("Carlotta", "Pisano", House.Ravenclaw),
                new Student("Ilies", "Chikhaoui", House.Slytherin),
                new Student("Samuele", "Celletti", House.Gryffindor),
                new Student("Gabriele", "Sabatini", House.Hufflepuff),
                new Student("Joshua", "Castellani", House.Slytherin),
                new Student("Lorenzo", "Salvatori", House.Gryffindor),
                new Student("Luca", "Galimberti", House.Ravenclaw),
                new Student("Matteo", "Fratti", House.Hufflepuff),
                new Student("Salvatore", "Tavella", House.Hufflepuff)
        );

        // Crea un'istanza della classe MagicHat passando la lista di studenti
        MagicHat magicHat = new MagicHat(students);

        // Assegna gli studenti alle case
        magicHat.assignStudents();

        // Stampa i risultati finali
        System.out.println("\nRisultati finali:");
        for (HouseGroup houseGroup : magicHat.getHouseGroups()) {  // Per ogni gruppo di case
            System.out.println(houseGroup);  // Stampa il nome della casa e il numero di studenti assegnati
            for (Student student : houseGroup.getStudents()) {  // Per ogni studente in quel gruppo di case
                System.out.println("  - " + student);  // Stampa i dettagli dello studente
            }
            System.out.println();  // Stampa una riga vuota per separare i gruppi
        }
    }
}