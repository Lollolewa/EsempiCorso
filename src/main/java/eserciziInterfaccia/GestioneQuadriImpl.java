package eserciziInterfaccia;

import java.util.ArrayList;
import java.util.List;

public class GestioneQuadriImpl implements gestioneQuadri{

    private List<OperaArte> opere;
    public GestioneQuadriImpl(){
        this.opere = new ArrayList<>();
    }


    @Override
    public void aggiungi(OperaArte op) {
        opere.add(op);
    }

    @Override
    public void rimuovi(OperaArte op) {
        opere.remove(op);
    }

    @Override
    public OperaArte cercaPerNome(String nome) {
        for(OperaArte op : opere){
            if(op.getNome().equals(nome)){
                System.out.println("Il quadro che stai cercando è " + op.toString()) ;
                return op;
            }
        }
        System.out.println("Nessun quadro trovato con il nome: " + nome);
        return null;
    }

    @Override
    public OperaArte cercaPerAnno(int anno) {
        for(OperaArte op : opere){
            if(op.anno == anno){
                System.out.println("Trovato quadro del " + anno + ": " + op);
                return op;
            }
        }
        System.out.println("Nessun quadro trovato per l'anno: " + anno);
        return null;
    }
}
