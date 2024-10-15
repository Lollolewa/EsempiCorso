package org.generation.italy.esempiCorso.collezioniamo;

public class Prodotto {
    String nome;
    int costo;

    public Prodotto(String nome, int costo) {
        this.nome = nome;
        this.costo = costo;
    }

    public String aCaso() {
        return "ciao";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != Prodotto.class) { // reference nulla o se la classe non è Prodotto
            return false;
        }
        Prodotto other = (Prodotto) o; // copia REFERENCE non oggetto
        if (this.nome == null) { // Se il nome di un prodotto e' nullo
            if (other.nome == null) {
                return costo == other.costo;
            }
            return false; // se sono qui il nome non è nullo
        } // il metodo equals che chiamo è quello delle stringhe non dei prodotti
        return this.nome.equals(other.nome) && this.costo == other.costo; // controllo che nome non è nullo per non farci equals sopra
    }

//    @Override
//    public int hashCode() { // CASO DEGENERE performance O(N)
//        return 1; // tutti gli oggetti vanno nello stesso secchiello..il metodo di set è inutile
//    }
    @Override
    public int hashCode() {
        return nome != null ? (nome.hashCode() + 1) + costo : 1;
    }

}
