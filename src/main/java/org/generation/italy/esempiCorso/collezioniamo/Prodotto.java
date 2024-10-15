package org.generation.italy.esempiCorso.collezioniamo;

public class Prodotto {
    String nome;
    int costo;

    public Prodotto(String nome, int costo) {
        this.nome = nome;
        this.costo = costo;
    }


    /**
     * prova per far vedere
     * come funziona la descrizione di un metodo
     * stile javadoc
     * @return
     */
    public String descrizioneJavadoc() {
        return "ciao";
    }
}
