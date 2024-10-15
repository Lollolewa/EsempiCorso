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

    //aggiustare l'equals in prodotto per far sì che quando chiamiamo il .equals di Prodotto nella main mi restituisce true
    //se il contenuto informativo degli oggetti è uguale tra di loro.
    @Override
    public boolean equals(Object o) {
        System.out.println("Ho chiamato .equals");
        if(o == null || o.getClass() != Prodotto.class) {
            return false;
        }
        Prodotto other = (Prodotto) o;
        if(this.nome == null) {
            if(other.nome == null) {
                return costo == other.costo;
            }
            return false;
        }

        return this.nome.equals(other.nome) && this.costo == other.costo;
    }

    @Override
    public int hashCode() {
        System.out.println("Ho chiamato hashCode");
        return (nome != null ? nome.hashCode() : 1) + costo;
    }
}
