package org.generation.italy.esempiCorso.inheritance;

import org.generation.italy.esempiCorso.inheritance.school.Teacher;

public class Start {
    public static void main(String[] args){
        Teacher teacher = new Teacher("Riccardo", "Audano", 25, "programmazione", 18);
        System.out.println(teacher.toString()); //tutti gli oggetti che creiamo derivano da una superclasse suprema (la classe Object)


    }
}
