package org.generation.italy.esempiCorso.inheritance;

import org.generation.italy.esempiCorso.inheritance.school.Teacher;

public class Start {
    public static void main(String[] args){
        Teacher t = new Teacher("Pippo", "Pippo", 25, "informatica", 22);
        t.toString(); //tutti gli oggetti creati derivano dalla super classe object, ereditiamo in automatico certi metodi
        System.out.println(t);
    }
}
