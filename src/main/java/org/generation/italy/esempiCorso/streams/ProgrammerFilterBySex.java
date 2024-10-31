package org.generation.italy.esempiCorso.streams;

import java.util.function.Predicate;

public class ProgrammerFilterBySex implements Predicate<Programmer> {
    @Override
    public boolean test(Programmer programmer) {
//        if(programmer.isMale()){
//            return false;
//        }
//        return true;
        return !programmer.isMale();
    }
}
