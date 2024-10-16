package org.generation.italy.examples.interfaces;

public class Prodotto {
    String nome;
    int costo;
    // List<Prodotto> prodotti = new ArrayList<>();

    public Prodotto(String nome, int costo) {
        this.nome = nome;
        this.costo = costo;
    }
    public String aCaso(){
        return"ciao";
    }
   @Override
   public boolean equals(Object o){
       System.out.println("Ho chiamato equals");
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
   @Override
    public int hashCode(){
       System.out.println("Ho chiamato hashCode");
        return (nome != null ? nome.hashCode() : 1) + costo;
   }
}
