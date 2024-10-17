package eserciziInterfaccia;

import java.util.ArrayList;
import java.util.List;

public class Quadro extends OperaArte {
    protected boolean corniceCostosa;
    public Quadro(String nome, String autore, int anno, int costo, boolean corniceCostosa){
        super(nome, autore, anno, costo);
        this.corniceCostosa = corniceCostosa;
    }

    @Override
    public String toString(){
        return "Il nome del quadro è: " + nome + "\nL'autore è: " + autore + "\nAnno: " + anno + "\nCosto: " + costo + "\nCornice costosa: " + corniceCostosa;

    }
}
