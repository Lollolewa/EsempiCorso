package org.generation.italy.esempiCorso.MagicHatOOP;

import java.util.HashSet;
import java.util.Set;

public enum Houses {
    HUFFLEPUFF, GRYFFINDOR, SLYTHERIN, RAVENCLAW;
    private Set<Studente> students = new HashSet<>();
    private static int maxStudent;
    public static void setMaxStudent(int max){
        maxStudent=max;
    }
    public int add(Studente s){
        students.add(s);
        return students.size();
    }
    @Override
    public String toString(){
        return students.toString();
    }

}
