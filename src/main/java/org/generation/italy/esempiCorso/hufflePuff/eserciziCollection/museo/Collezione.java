package org.generation.italy.esempiCorso.hufflePuff.eserciziCollection.museo;

import java.sql.SQLOutput;
import java.util.List;

public class Collezione {
    private String nome, luogo;
    private List<OperaDArte> opereDArte;

    public Collezione(List<OperaDArte> opereDArte, String luogo, String nome) {
        this.opereDArte = opereDArte;
        this.luogo = luogo;
        this.nome = nome;
    }

    public void inserisciOpera(OperaDArte o) {
        opereDArte.add(o);
    }

    public void stampaCollezione() {
        System.out.printf("%s, %s%n", nome, luogo);
        for (OperaDArte opera : opereDArte){
            System.out.println(opera);
        }
    }
}
