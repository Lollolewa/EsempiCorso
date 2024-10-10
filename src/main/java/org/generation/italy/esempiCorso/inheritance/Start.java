package org.generation.italy.esempiCorso.inheritance;

import org.generation.italy.esempiCorso.inheritance.school.Personnel;
import org.generation.italy.esempiCorso.inheritance.school.Teacher;

public class Start {
    public static void main(String[] args){
        Teacher teacher = new Teacher("Riccardo", "Audano", 18, "programmazione", 18, 10, 3500);
        System.out.println(teacher);

        Personnel personnel = new Personnel("Vik", "Shn", 24, 2000, 13, "Insegnante", 500);
        System.out.println(personnel);

    }
}
