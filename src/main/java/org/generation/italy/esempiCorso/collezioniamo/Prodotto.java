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
    @Override
    public boolean equals(Object o){
        System.out.println("Ho chiamato equals");
        if(o==null || o.getClass() != Prodotto.class){
            //se la reference o che mi hai passato punta a niente oppure a un oggetto di un'altra classe torna false -> non sono uguali
            return false;
        }
        Prodotto other = (Prodotto) o; //cast serve per far compilare
        // sto obbligando il compilatore a lasciar puntare allo stesso oggetto due reference di tipo diverso
        // (prodotto e o), sto dicendo che dentro o c'è un oggetto
        //ho creato una reference di tipo prodotto che si chiama other e l'ho assegnata alla reference dell'oggetto passato in input
        if(this.nome == null){
            if(other.nome==null){
                return costo== other.costo;
            }
            return false;
        }
        return this.nome.equals(other.nome) && this.costo == other.costo;
        //sto richiamando il metodo equals delle stringhe
    }

    @Override
    public int hashCode(){
        System.out.println("ho chiamato hashCode");
        return (nome != null ? nome.hashCode() : 1) + costo;
    }
}
