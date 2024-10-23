package org.generation.italy.esempiCorso.collezioniamo;

import java.util.ArrayList;
import java.util.List;

public class Prodotto {
    String nome;
    int costo;

    public Prodotto(String nome, int costo) {
        this.nome = nome;
        this.costo = costo;


    }
    @Override
    public boolean equals(Object o){
        System.out.println("Ho chiamato equals");
        if(o == null || o.getClass() != Prodotto.class){
            return false;
       }
        Prodotto other = (Prodotto) o;
        if(this.nome == null ){
            if( other.nome == null){
                   return costo == other.costo;
            }
           return false;
        }
       return this.nome.equals(other.nome) && (this.costo == other.costo);
    }
    public String aCaso(){
        return"ciao";
    }
    @Override
    public int hashCode(){
        System.out.println("Ho chiamato hasCode");
        return(nome != null ? nome.hashCode() : 1 ) + costo;
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
