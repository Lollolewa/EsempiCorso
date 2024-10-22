package interfacce.esercizio;

public class Quadro extends OpereDArte{
    boolean corniceCostosa;
    public Quadro(String nome, String autore, int anno, double costo, boolean corniceCostosa) {
        super(nome, autore, anno, costo);
        this.corniceCostosa = corniceCostosa;
    }
    public boolean isCorniceCostosa() {
        return corniceCostosa;
    }
}
