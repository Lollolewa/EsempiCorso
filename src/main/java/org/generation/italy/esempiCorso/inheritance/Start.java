package org.generation.italy.esempiCorso.inheritance;

import org.generation.italy.esempiCorso.inheritance.school.Teacher;

public class Start {
    public static void main(String[] args){
       Teacher teacher = new Teacher("Riccardo", "Audano", 18, "programmazione", 18);
       System.out.println(teacher.toString());
    }
}
