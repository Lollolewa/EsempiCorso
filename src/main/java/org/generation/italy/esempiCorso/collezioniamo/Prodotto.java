package org.generation.italy.esempiCorso.collezioniamo;

public class Prodotto {
    String nome;
    int costo;

    public Prodotto(String nome, int costo) {
        this.nome = nome;
        this.costo = costo;
    }

    /**questo è un bellissimo metodo
     *
     *
     */
    public String aCaso(){
        return "ciao";
    }

    @Override
    public boolean equals(Object o){
        if(o == null || o.getClass() != Prodotto.class){
            return false;
        }
        Prodotto other = (Prodotto) o;
        if(this.nome == null){
            if(other.nome == null){
                return costo == other.costo;
            }
            return false;
        }
        return this.nome.equals(other.nome) && (this.costo == other.costo);
    }
}
