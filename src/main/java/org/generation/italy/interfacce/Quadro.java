package org.generation.italy.interfacce;

public class Quadro extends OperaDarte {

    public boolean corniceCostosa;

    public Quadro(String nome, String autore, int anno, double costo, boolean corniceCostosa) {
        super(nome, autore, anno, costo);
        this.corniceCostosa = corniceCostosa;
    }
    public boolean hasCorniceCostosa(){
        return corniceCostosa;
    }
}
/*classe quadro estende operaDarte con proprieta boolean cornice costosa*/
