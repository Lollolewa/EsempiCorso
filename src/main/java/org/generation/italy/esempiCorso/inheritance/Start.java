package org.generation.italy.esempiCorso.inheritance;

import org.generation.italy.esempiCorso.inheritance.geometria.Rettangolo;
import org.generation.italy.esempiCorso.inheritance.geometria.Triangolo;
import org.generation.italy.esempiCorso.inheritance.school.Teacher;

public class Start {
    public static void main(String[] args){
       Teacher teacher = new Teacher("Riccardo","Audano",18, "programmazione", 18);
       System.out.println(teacher.toString()); //tutti gli oggetti creati derivano dalla super classe object
        Triangolo triangolo = new Triangolo(10, 10);
        Rettangolo rettangolo = new Rettangolo(5,10);
        System.out.println(triangolo.calcolaArea());
        System.out.println(rettangolo.calcolaArea());
    }
}
