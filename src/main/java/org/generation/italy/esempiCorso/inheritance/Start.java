package org.generation.italy.esempiCorso.inheritance;

import org.generation.italy.esempiCorso.inheritance.school.Teacher;

public class Start {
    public static void main(String[] args){

        Teacher teacher = new Teacher("Michael", "Johnson", 35,"Math",9);

        System.out.println(teacher.toString());

    }

}
