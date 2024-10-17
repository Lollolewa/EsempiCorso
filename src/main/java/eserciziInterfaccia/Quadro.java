package eserciziInterfaccia;

public class Quadro extends OperaArte{
    protected String nome, autore;
    protected int anno, costo;
    protected boolean corniceCostosa;
    public Quadro(String nome, String autore, int anno, int costo, boolean corniceCostosa){
        super(nome, autore, anno, costo);
        this.corniceCostosa = corniceCostosa;
    }

}
