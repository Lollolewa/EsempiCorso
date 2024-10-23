package org.generation.italy.esempiCorso.griffindor.eserciziCollection.arte;

import java.util.Arrays;
import java.util.List;

public class Collezione {
    protected String nome;
    protected String luogo;
    protected List<OperaDArte> opere;

    public void aggiungiOpera(OperaDArte opera) {
        opere.add(opera);
    }
    public void stampaCollezione(String nome, String luogo, List<OperaDArte> opere){
        System.out.println("Nome collezione: " + nome);
        System.out.println("Luogo: " + luogo);
        opere.forEach(System.out::println);
    }

    private boolean isSameDimensioniBis(OperaDArte a, OperaDArte b){
        return a.calculateDimensioni() == b.calculateDimensioni();
    }

    public void compareToStringBis(OperaDArte a, OperaDArte b){
        if(isSameDimensioniBis(a,b))
            System.out.println("Le opere " + a.titolo + " e " + b.titolo + " hanno le stesse dimensioni.");
        else
            System.out.println("Le opere " + a.titolo + " e " + b.titolo + " non hanno le stesse dimensioni.");
    }
}

