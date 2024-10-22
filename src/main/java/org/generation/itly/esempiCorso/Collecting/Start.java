package org.generation.itly.esempiCorso.Collecting;

import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main (String[] args){
        String[] names = new String[10];
        names[0] = "Pippo";

        List<String> classNames = new ArrayList<String>();
        classNames.add("mhanz");
        classNames.add("Valavula");
        for(String s : classNames){
            System.out.println(s);
        }

    }
}
