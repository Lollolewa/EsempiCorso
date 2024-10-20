package org.generation.italy.esempiCorso.collezioniamo;

import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;

class Prodotto {
    private String nome;
    private int costo;

    public Prodotto(String nome, int costo) {
        this.nome = nome;
        this.costo = costo;
    }
    public int getCosto() {
        return costo;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Ho chiamato equals");
        if(obj == null || obj.getClass() != Prodotto.class){
            return false;
        }
        Prodotto other= (Prodotto)obj;
        if(this.nome == null){
            if(other.nome == null){
                return costo== other.costo;
            }
            return false;
        }
        return this.nome.equals(other.nome) && (this.costo== other.costo);
    }
    @Override
    public int hashCode() {
        System.out.println("Ho chiamato hashCode");
        return (nome != null? nome.hashCode() : 1) + costo;
    }
}