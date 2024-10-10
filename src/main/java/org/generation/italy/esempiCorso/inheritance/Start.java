package org.generation.italy.esempiCorso.inheritance;

import org.generation.italy.esempiCorso.inheritance.school.Teacher;

public class Start {
    public static void main(String[] args){
        Teacher t = new Teacher("Riccardo", "Audano", 25, "Programmazione", 5);
        System.out.println(t.toString());
    }
}