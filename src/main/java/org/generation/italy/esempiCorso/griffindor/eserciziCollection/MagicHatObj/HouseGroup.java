package org.generation.italy.esempiCorso.griffindor.eserciziCollection.MagicHatObj;

import java.util.ArrayList;
import java.util.List;

public class HouseGroup {
    private House house;  // Riferimento a una casa (House)
    private List<Student> students;  // Lista degli studenti assegnati a questa casa

    // Costruttore della classe HouseGroup
    public HouseGroup(House house) {
        this.house = house;  // Inizializza la casa con il valore passato al costruttore
        this.students = new ArrayList<>();  // Inizializza una lista vuota per gli studenti
    }

    public House getHouse() {
        return house;  // Restituisce la casa associata a questo gruppo
    }

    public List<Student> getStudents() {
        return students;  // Restituisce la lista degli studenti assegnati alla casa
    }

    public void addStudent(Student student) {
        students.add(student);  // Aggiunge uno studente alla lista degli studenti di questa casa
    }

    @Override
    public String toString() {
        // Restituisce una stringa che rappresenta la casa e il numero di studenti in essa
        return house + " - Students: " + students.size();
    }
}
