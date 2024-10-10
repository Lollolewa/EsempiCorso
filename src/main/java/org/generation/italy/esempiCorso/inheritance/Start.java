package org.generation.italy.esempiCorso.inheritance;

import org.generation.italy.esempiCorso.inheritance.school.Teacher;

public class Start {
    public static void main(String[] args){
        //System.out.println("testing github");
        //System.out.println("Aggiunto da Alessia");
        //System.out.println("Branch di mirko");
        Teacher teacher = new Teacher("Riccardo", "Audano", 18, "Programmazione", 18);
        //teacher.toString()  //tutti gli oggetti che creiamo derivano da una SUPERCLASSEMADRESUPREMA che deriva dalla classe Object.
                            // tutti gli oggetti è come se avessero quindi extends Object

        System.out.println(teacher.toString());
    }
}
