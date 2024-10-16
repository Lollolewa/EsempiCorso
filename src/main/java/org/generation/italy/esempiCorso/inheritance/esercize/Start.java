package org.generation.italy.esempiCorso.inheritance.esercize;

import org.generation.italy.esempiCorso.inheritance.school.Personnel;
import org.generation.italy.esempiCorso.inheritance.school.Teacher;

public class Start {
    public static void main(String[] args){
       Teacher teacher = new Teacher("Riccardo","Audano",18, "Programmazione", 18, 3500, 14);
       System.out.println(teacher); //tutti gli oggetti creati derivano dalla super classe object

        Personnel personnel = new Personnel("Vik", "Shn", 24, 2000, 13, "Insegnante", 500);
        System.out.println(personnel);

    }
}