package org.generation.italy.esempiCorso.collezioniamo;

public class Prodotto {
    String nome;
    int costo;

    public Prodotto(String nome, int costo) {
        this.nome=nome;
        this.costo=costo;
    }

    /**
     *questo è un metodo bellissimo per stampare ciao
     * @return
     */
    public String aCaso(){
        return "ciao";
    }
}
