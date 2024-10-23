package org.generation.italy.esempiCorso.griffindor.eserciziCollection.MagicHatObj;

import java.util.*;

public class MagicHat {
    private final Random random = new Random();  // Crea un'istanza della classe Random per generare numeri casuali
    private final int NUM_HOUSES = House.values().length;  // Numero totale delle case, ottenuto contando gli elementi dell'enum House
    private final List<HouseGroup> houseGroups;  // Lista che conterrà i gruppi di case (HouseGroup)
    private final List<Student> students;  // Lista di studenti da assegnare alle case

    public MagicHat(List<Student> students) {
        this.students = new ArrayList<>(students);  // Copia la lista di studenti passata come parametro
        this.houseGroups = new ArrayList<>();  // Inizializza la lista di gruppi di case

        for (House house : House.values()) {  // Itera su tutte le case definite nell'enum House
            houseGroups.add(new HouseGroup(house));  // Aggiunge un nuovo gruppo di case per ogni casa nell'enum
        }
    }

    public void assignStudents() {
        for (Student student : students) {  // Per ogni studente nella lista degli studenti
            assignStudent(student);  // Assegna lo studente a una casa chiamando il metodo assignStudent
        }
    }

    private void assignStudent(Student student) {
        boolean assigned = false;  // Variabile per controllare se lo studente è stato assegnato

        while (!assigned) {  // Continua finché lo studente non viene assegnato
            int houseIndex = random.nextInt(NUM_HOUSES);  // Genera un indice casuale per selezionare una casa
            HouseGroup houseGroup = houseGroups.get(houseIndex);  // Ottiene il gruppo di case corrispondente all'indice casuale

            // Verifica se la casa corrente è quella preferita dallo studente o se un booleano casuale è true
            if (houseGroup.getHouse() == student.getPreferredHouse() || random.nextBoolean()) {
                int smallestHouseSize = getSmallestHouseSize();  // Ottiene la dimensione della casa più piccola attualmente

                // Assegna lo studente se la dimensione della casa corrente è minore o uguale alla più piccola
                if (houseGroup.getStudents().size() <= smallestHouseSize) {
                    houseGroup.addStudent(student);  // Aggiunge lo studente alla casa
                    assigned = true;  // Imposta assigned su true per uscire dal ciclo
                    System.out.println("Studente " + student.getName() + " " + student.getSurname() + " assegnato alla casa " + houseGroup.getHouse());  // Stampa il messaggio di assegnazione
                }
            }
        }
    }

    private int getSmallestHouseSize() {
        int minSize = Integer.MAX_VALUE;  // Inizializza la dimensione minima al massimo valore intero
        for (HouseGroup houseGroup : houseGroups) {  // Itera su tutti i gruppi di case
            int currentSize = houseGroup.getStudents().size();  // Ottiene la dimensione della lista degli studenti per la casa corrente
            if (currentSize < minSize) {  // Se la dimensione corrente è minore della dimensione minima
                minSize = currentSize;  // Aggiorna la dimensione minima
            }
        }
        return minSize;  // Restituisce la dimensione minima
    }

    public List<HouseGroup> getHouseGroups() {
        return new ArrayList<>(houseGroups);  // Restituisce una nuova lista contenente tutti i gruppi di case
    }
}
