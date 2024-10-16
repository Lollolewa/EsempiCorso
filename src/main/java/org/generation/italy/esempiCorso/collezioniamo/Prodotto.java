package org.generation.italy.esempiCorso.collezioniamo;

public class Prodotto {
    String nome;
    int costo;

    public Prodotto(String nome, int costo) {
        this.nome = nome;
        this.costo = costo;
    }
    @Override
    public boolean equals (Object obj) {
        if (obj == null || obj.getClass() != Prodotto.class) {
            return false;
        }
        Prodotto other = (Prodotto)obj;
        if (this.nome == null) {
            if(other.nome == null) {
                return costo == other.costo;
            }
        }
        return this.nome.equals(other.nome) && this.costo == other.costo;
    }
}
