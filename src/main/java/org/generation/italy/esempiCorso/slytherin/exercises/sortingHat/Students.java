package org.generation.italy.esempiCorso.slytherin.exercises.sortingHat;

import java.util.List;

public class Students {
    private List<Student> studentList;

    public Students(List<Student> studentList) {
        this.studentList = studentList;
    }
    public List<Student> getStudentList() {
        return studentList;
    }
    public String toString(){
        String temp = "";
        for (Student s : studentList){
            temp += s.toString();
        }
        return temp;
    }
}

