package org.generation.italy.esempiCorso.inheritance;

import org.generation.italy.esempiCorso.inheritance.school.Employee;
import org.generation.italy.esempiCorso.inheritance.school.Personnel;
import org.generation.italy.esempiCorso.inheritance.school.Teacher;

public class Start {
    public static void main(String[] args){
        Teacher t = new Teacher("Pippo", "Pippo", 25, 1500, 13, "Informatica", 12); //tutti gli oggetti creati derivano dalla super classe object, ereditiamo in automatico certi metodi
        Personnel p = new Personnel("Peppe", "Peppe", 28, 1500, 13, "Amministratore", 1600);
        System.out.println(p);
        System.out.println(t);
    }
}
