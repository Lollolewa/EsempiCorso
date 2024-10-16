package org.generation.italy.esempiCorso.hufflePuff.eserciziCollection;

import java.util.ArrayList;
import java.util.List;

public class Archivio  {
    List<Villa> listaVille = new ArrayList<>();
    List<Appartamento> listaAppartamenti = new ArrayList<>();

    public Archivio(List<Villa> listaVille, List<Appartamento> listaAppartamenti) {
        this.listaVille = listaVille;
        this.listaAppartamenti = listaAppartamenti;
    }

    public Archivio() {

    }

    public void aggiungiVilla(Villa villa){
        listaVille.add(villa);
    }

    public void aggiungiAppartamento(Appartamento appartamento) {
        listaAppartamenti.add(appartamento);
    }

    public int mediaCosti(int n){
            int sommaCosti = 0;
            int conteggio = 0;
            for(Villa villa : listaVille) {
                if (villa.superficie > n) {
                    sommaCosti += villa.costoCasa();
                    conteggio++;
                }
            }
            for (Appartamento appartamento : listaAppartamenti){
                if (appartamento.superficie > n){
                    sommaCosti+= appartamento.costoCasa();
                    conteggio++;
                }
            }

        return conteggio > 0 ? sommaCosti / conteggio : 0;
    }

}




