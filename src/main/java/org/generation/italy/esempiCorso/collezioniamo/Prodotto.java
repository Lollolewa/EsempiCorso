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
        if(this == o) //controlla se i puntatori puntano alla stessa cosa
            return true;
        if(o == null) //controlla se il puntatore o sta puntando a nulla
            return false;

        if(o == null || o.getClass() != Prodotto.class) { //controllo che la classe di o non sia nulla e che non sia diversa da Prodotto;
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
