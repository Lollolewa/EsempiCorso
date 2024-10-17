package eserciziInterfaccia;

import java.util.ArrayList;
import java.util.List;

public class Quadro extends OperaArte {
    protected String nome, autore;
    protected int anno, costo;
    protected boolean corniceCostosa;
    public Quadro(String nome, String autore, int anno, int costo, boolean corniceCostosa){
        super(nome, autore, anno, costo);
        this.corniceCostosa = corniceCostosa;
    }
    List<OperaArte> opere = new ArrayList<>();

    @Override
    public void aggiungi(OperaArte op) {
        opere.add(op);
    }

    @Override
    public void rimuovi(OperaArte op) {

    }

    @Override
    public OperaArte cercaPerNome(String nome) {
        for (OperaArte op : opere) {
            if (op.getNome().equals(nome)){

            }
        } return null;
    }

    @Override
    public OperaArte cercaPerAnno(int anno) {
        for (OperaArte op : opere){
            if (op.getAnno() == anno){
                return op;
            }
        } return null;
    }
}