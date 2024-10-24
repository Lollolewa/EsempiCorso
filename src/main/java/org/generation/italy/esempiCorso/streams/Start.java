package org.generation.italy.esempiCorso.streams;

import java.util.List;

public class Start {
    public static void main(String[] args){
        var pr = new ProgrammerRepository();
        pr.printProgrammersByLanguages();
        List<Programmer> result = pr.findFemales();
        for(Programmer p : result){
            p.addLanguage("ruby");
        }
    }
}
